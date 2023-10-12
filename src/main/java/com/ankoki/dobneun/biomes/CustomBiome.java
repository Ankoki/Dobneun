package com.ankoki.dobneun.biomes;

import com.ankoki.dobneun.biomes.effects.AmbientParticle;
import com.ankoki.dobneun.biomes.effects.BiomeEffects;
import com.ankoki.dobneun.biomes.entities.BiomeEntity;
import com.ankoki.dobneun.misc.Misc;
import com.ankoki.dobneun.reflection.Reflection;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeBuilder;
import net.minecraft.world.level.biome.BiomeSpecialEffects.Builder;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.craftbukkit.v1_20_R2.CraftChunk;
import org.bukkit.craftbukkit.v1_20_R2.CraftServer;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Optional;

/**
 * Creates a new CustomBiome.
 * Please be aware you will need to refresh chunks for the players who are in a custom biome.
 * All of them will need to be registered on STARTUP, so before worlds are loaded.
 */
@SuppressWarnings("unused")
public class CustomBiome {

	private final ResourceKey<Biome> key;
	private final JavaPlugin owner;
	private final String name;
	private final BiomeBuilder biome = new BiomeBuilder();
	private BiomeEffects effects;
	private float downfall = 0.8F;
	private float temperature = 0.7F;
	private TemperatureModifier temperatureModifier = TemperatureModifier.NONE;
	private Precipitation precipitation = Precipitation.NONE;
	private final List<BiomeEntity> entities = new ArrayList<>();
	private float creatureGenerationProbability = 0.07F;
	@Nullable
	private Holder<Biome> holder;

	/**
	 * Creates a new custom biome object.
	 *
	 * @param plugin the plugin to register it under.
	 * @param name   the name of the biome. Must have a unique name and be lowercase.
	 */
	public CustomBiome(JavaPlugin plugin, String name) {
		this.owner = plugin;
		this.name = name.toLowerCase();
		this.key = ResourceKey.create(Registries.BIOME, new ResourceLocation(plugin.getName().toLowerCase(), this.name));
	}

	/**
	 * Sets the given chunks to the given biome.
	 *
	 * @param custom the biome to set this chunk too.
	 * @param bukkit  the chunk to set this biome to.
	 */
	public static void setBiome(CustomBiome custom, Chunk bukkit) {
		try {
			int axisOne = bukkit.getX();
			int axisTwo = bukkit.getZ();
			// TODO find out what this is when obfuscated.
			// TO DO THIS, LOAD ON A SERVER AND LOOP ALL FIELDS OF CRAFTCHUNK AMD FIND THE ONE WITH A SERVERLEVEL TYPE.
			Field field = Reflection.getField(CraftChunk.class, "worldServer");
			ServerLevel level = (ServerLevel) field.get(bukkit);
			LevelChunk chunk = level.getChunk(axisOne, axisTwo);
			Holder<Biome> base = custom.getHolder();
			if (base != null) {
				for (LevelChunkSection section : chunk.getSections()) {
					for (int x = 0; x < 4; x++)
						for (int z = 0; z < 4; z++)
							for (int y = 0; y < 4; y++)
								section.setBiome(x, y, z, base);
				}
				ClientboundLevelChunkWithLightPacket packet = new ClientboundLevelChunkWithLightPacket(chunk, chunk.level.getLightEngine(), null, null, true);
				for (Player player : bukkit.getWorld().getPlayers()) {
					if (player.isOnline() && player.getLocation().distance(bukkit.getBlock(0, 0, 0).getLocation()) < (Bukkit.getServer().getViewDistance() * 16))
						((CraftPlayer) player).getHandle().connection.send(packet);
				}
			} else
				throw new IllegalArgumentException("Biome '" + custom.getKey() + "' has not been registered yet.");
		} catch (Exception ex) { Misc.handleException(ex); }
	}

	/**
	 * Gets the resource key that contains this biome.
	 *
	 * @return the key.
	 */
	public ResourceKey<Biome> getKey() {
		return key;
	}

	/**
	 * Gets the plugin which owns this biome.
	 *
	 * @return the owner.
	 */
	public JavaPlugin getOwner() {
		return owner;
	}

	/**
	 * Gets the name this biome was registered under.
	 *
	 * @return the name of the biome.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Copies the default mob spawning and terrain generation from a {@link org.bukkit.block.Biome#FOREST} biome.
	 *
	 * @return the current instance for chaining.
	 */
	public CustomBiome copyDefaults() {
		MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
		ResourceKey<Biome> key = ResourceKey.create(Registries.BIOME, new ResourceLocation("minecraft", "forest"));
		Optional<Registry<Biome>> optional = server.registryAccess().registry(Registries.BIOME);
		if (optional.isEmpty()) {
			Misc.handleException(new RuntimeException("Registry was not found while copying defaults. What happened?"));
			return this;
		}
		Registry<Biome> registry = optional.get();
		Biome base = registry.get(key);
		this.biome.mobSpawnSettings(base.getMobSettings());
		this.biome.generationSettings(base.getGenerationSettings());
		return this;
	}

	/**
	 * Gets the current effects of this biome.
	 *
	 * @return the effects.
	 */
	@Nullable
	public BiomeEffects getEffects() {
		return effects;
	}

	/**
	 * Sets the effects of this biome.
	 *
	 * @param effects the effects to have.
	 * @return the current instance for chaining.
	 */
	public CustomBiome setEffects(BiomeEffects effects) {
		this.effects = effects;
		return this;
	}

	/**
	 * Gets the downfall for this biome.
	 *
	 * @return the downfall.
	 */
	public float getDownfall() {
		return downfall;
	}

	/**
	 * Sets the downfall of this biome.
	 *
	 * @param downfall the new downfall.
	 * @return the current instance for chaining.
	 */
	public CustomBiome setDownfall(float downfall) {
		this.downfall = downfall;
		return this;
	}

	/**
	 * Gets the temperature for this biome.
	 *
	 * @return the temperature.
	 */
	public float getTemperature() {
		return temperature;
	}

	/**
	 * Sets the temperature of this biome.
	 *
	 * @param temperature the new temperature.
	 * @return the current instance for chaining.
	 */
	public CustomBiome setTemperature(float temperature) {
		this.temperature = temperature;
		return this;
	}

	/**
	 * Gets the precipitation for this biome.
	 *
	 * @return the precipitation.
	 */
	public Precipitation getPrecipitation() {
		return precipitation;
	}

	/**
	 * Sets the precipitation of this biome.
	 *
	 * @param precipitation the new precipitation.
	 * @return the current instance for chaining.
	 */
	public CustomBiome setPrecipitation(Precipitation precipitation) {
		this.precipitation = precipitation;
		return this;
	}

	/**
	 * Gets the temperature modifier for this biome.
	 *
	 * @return the temperature modifier.
	 */
	public TemperatureModifier getTemperatureModifier() {
		return temperatureModifier;
	}

	/**
	 * Sets the temperature modifier of this biome.
	 *
	 * @param temperatureModifier the new temperature modifier.
	 * @return the current instance for chaining.
	 */
	public CustomBiome setTemperatureModifier(TemperatureModifier temperatureModifier) {
		this.temperatureModifier = temperatureModifier;
		return this;
	}

	/**
	 * Sets the given chunk to this biome.
	 *
	 * @param chunk the chunk to set.
	 * @return the current instance for chaining.
	 */
	public CustomBiome setBiome(Chunk chunk) {
		CustomBiome.setBiome(this, chunk);
		return this;
	}

	/**
	 * Gets the current creature generation probability.
	 *
	 * @return the creature generation probability.
	 */
	public float getCreatureGenerationProbability() {
		return creatureGenerationProbability;
	}

	/**
	 * Sets the probability of creatures generating.
	 *
	 * @param creatureGenerationProbability the probability.
	 * @return the current instance for chaining.
	 */
	public CustomBiome setCreatureGenerationProbability(float creatureGenerationProbability) {
		this.creatureGenerationProbability = creatureGenerationProbability;
		return this;
	}

	/**
	 * Gets the entities which this entity will spawn.
	 *
	 * @return the entities.
	 */
	public List<BiomeEntity> getEntities() {
		return entities;
	}

	/**
	 * Adds the given entity to the monster generation.
	 *
	 * @param entity the entity to add.
	 * @return the current instances for chaining.
	 */
	public CustomBiome addEntity(BiomeEntity entity) {
		this.entities.add(entity);
		return this;
	}

	/**
	 * Gets the holder of this biome. {@link CustomBiome#register()} must be called first, otherwise this will be null.
	 *
	 * @return the holder of the biome.
	 */
	@Nullable
	public Holder<Biome> getHolder() {
		return holder;
	}

	/**
	 * Registers the given biome to the biome registry.
	 * Must be called in onEnable, or it will not be applied to loaded worlds.
	 *
	 * @throws IllegalStateException if the given biome effects aren't valid.
	 * @return the current instance for chaining.
	 */
	public CustomBiome register() {
		if (this.effects == null) {
			Misc.handleException(new IllegalAccessException("Cannot create a new biome with no effects (effects was null)."));
			return this;
		}
		try {
			this.effects.validate();
		} catch (IllegalStateException ex) {
			Misc.handleException(ex);
			return this;
		}
		this.biome.downfall(this.downfall);
		this.biome.temperature(this.temperature);
		this.biome.hasPrecipitation(this.precipitation != Precipitation.NONE);
		this.biome.temperatureAdjustment(this.temperatureModifier.getRoot());
		Builder builder = new Builder();
		builder.fogColor(this.effects.getFogColour());
		builder.waterColor(this.effects.getWaterColour());
		builder.waterFogColor(this.effects.getWaterFogColour());
		builder.skyColor(this.effects.getSkyColour());
		if (this.effects.hasGrassColour())
			builder.grassColorOverride(this.effects.getGrassColour());
		if (this.effects.hasGrassColourModifier())
			builder.grassColorModifier(this.effects.getGrassColourModifier().getModifier());
		if (this.effects.hasFoliageColourOverride())
			builder.foliageColorOverride(this.effects.getFoliageColourOverride());
		if (this.effects.hasMusic())
			builder.backgroundMusic(this.effects.getMusic());
		if (this.effects.hasAmbientLoop())
			builder.ambientLoopSound(this.effects.getAmbientLoop().getHolder());
		if (this.effects.hasAmbientParticle()) {
			AmbientParticle particle = this.effects.getAmbientParticle();
			ParticleType<?> type = particle.getType();
			float probability = particle.getProbability();
			if (type instanceof SimpleParticleType simple)
				builder.ambientParticle(new AmbientParticleSettings(simple, probability));
			else if (AmbientParticle.cast(type, DustParticleOptions.class) != null) {
				if (particle.hasColour()) {
					Color colour = particle.getColour();
					Vector3f vec = Vec3.fromRGB24(colour.getRGB()).toVector3f();
					builder.ambientParticle(new AmbientParticleSettings(new DustParticleOptions(vec, particle.getScale()), probability));
				}
			}
		}
		if (this.entities.size() > 0) {
			MobSpawnSettings.Builder settingsBuilder = new MobSpawnSettings.Builder();
			// TODO mob spawn cost
			for (BiomeEntity entity : this.entities) {
				MobCategory category = entity.getSpawnCategory().getRoot();
				EntityType<?> type = entity.getEntityType().getRoot();
				MobSpawnSettings.SpawnerData data = new MobSpawnSettings.SpawnerData(type, entity.getWeight(), entity.getMinimumGroupSize(), entity.getMaximumGroupSize());
				settingsBuilder.addSpawn(category, data);
			}
			settingsBuilder.creatureGenerationProbability(this.creatureGenerationProbability);
			this.biome.mobSpawnSettings(settingsBuilder.build());
		}
		this.biome.specialEffects(builder.build());
		MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
		Registry<Biome> registry = server.registryAccess().registryOrThrow(Registries.BIOME);
		Biome biome = this.biome.build();
		Class<?> clazz = registry.getClass();
		Reflection.setField(clazz, registry, "l", false);
		Reflection.setField(clazz, registry, "m", new IdentityHashMap<>());
		this.holder = registry.createIntrusiveHolder(biome);
		Registry.register(registry, this.key, biome);
		Reflection.setField(clazz, registry, "l", true);
		Reflection.setField(clazz, registry, "m", null);
		return this;
	}

}
