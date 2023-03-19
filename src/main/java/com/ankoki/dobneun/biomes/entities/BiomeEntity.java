package com.ankoki.dobneun.biomes.entities;

public class BiomeEntity {

	private EntityType entityType;
	private SpawnCategory spawnCategory;
	private int weight;
	private int minimumGroupSize;
	private int maximumGroupSize;
	private int minimumCount;
	private int maximumCount;
	private float possibility;

	/**
	 * Sets the entity type of this biome entity.
	 *
	 * @param entityType the type.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setEntityType(EntityType entityType) {
		this.entityType = entityType;
		return this;
	}

	/**
	 * Gets the current entity type.
	 *
	 * @return the entity type.
	 */
	public EntityType getEntityType() {
		return entityType;
	}

	/**
	 * Sets the spawn category for this entity.
	 *
	 * @param spawnCategory the spawn category.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setSpawnCategory(SpawnCategory spawnCategory) {
		this.spawnCategory = spawnCategory;
		return this;
	}

	/**
	 * Gets the current spawn category.
	 *
	 * @return the spawn category.
	 */
	public SpawnCategory getSpawnCategory() {
		return spawnCategory;
	}

	/**
	 * Set the weight of this entity,
	 *
	 * @param weight the weight.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setWeight(int weight) {
		this.weight = weight;
		return this;
	}

	/**
	 * Gets the current weight of this entity.
	 *
	 * @return the weight.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the minimum group size this entity can spawn in.
	 *
	 * @param minimumGroupSize the minimum group size.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setMinimumGroupSize(int minimumGroupSize) {
		this.minimumGroupSize = minimumGroupSize;
		return this;
	}

	/**
	 * Gets the minimum group size of this entity.
	 *
	 * @return the minimum group size.
	 */
	public int getMinimumGroupSize() {
		return minimumGroupSize;
	}

	/**
	 * Sets the maximum group size this entity can spawn in.
	 *
	 * @param maximumGroupSize the maximum group size.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setMaximumGroupSize(int maximumGroupSize) {
		this.maximumGroupSize = maximumGroupSize;
		return this;
	}

	/**
	 * Gets the maximum group size.
	 *
	 * @return the maximum group size.
	 */
	public int getMaximumGroupSize() {
		return maximumGroupSize;
	}

	/**
	 * Sets the minimum count that can spawn for this entity.
	 *
	 * @param minimumCount the minimum count.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setMinimumCount(int minimumCount) {
		this.minimumCount = minimumCount;
		return this;
	}

	/**
	 * Gets the minimum count of this entity.
	 *
	 * @return the minimum count.
	 */
	public int getMinimumCount() {
		return minimumCount;
	}

	/**
	 * Sets the maximum count that can spawn for this entity.
	 *
	 * @param maximumCount the maximum count.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setMaximumCount(int maximumCount) {
		this.maximumCount = maximumCount;
		return this;
	}

	/**
	 * Gets the maximum count of this entity.
	 *
	 * @return the maximum count.
	 */
	public int getMaximumCount() {
		return maximumCount;
	}

	/**
	 * Sets the possibility of this biome entity spawning.
	 *
	 * @param possibility the possibility.
	 * @return the current instance for chaining.
	 */
	public BiomeEntity setPossibility(float possibility) {
		this.possibility = possibility;
		return this;
	}

	/**
	 * Gets the current possibility.
	 *
	 * @return the possibility.
	 */
	public float getPossibility() {
		return possibility;
	}

	public enum EntityType {
		ALLAY(net.minecraft.world.entity.EntityType.ALLAY),
		AREA_EFFECT_CLOUD(net.minecraft.world.entity.EntityType.AREA_EFFECT_CLOUD),
		ARMOUR_STAND(net.minecraft.world.entity.EntityType.ARMOR_STAND),
		ARROW(net.minecraft.world.entity.EntityType.ARROW),
		AXOLOTL(net.minecraft.world.entity.EntityType.AXOLOTL),
		BAT(net.minecraft.world.entity.EntityType.BAT),
		BEE(net.minecraft.world.entity.EntityType.BEE),
		BLAZE(net.minecraft.world.entity.EntityType.BLAZE),
		BLOCK_DISPLAY(net.minecraft.world.entity.EntityType.BLOCK_DISPLAY),
		BOAT(net.minecraft.world.entity.EntityType.BOAT),
		CAMEL(net.minecraft.world.entity.EntityType.CAMEL),
		CAT(net.minecraft.world.entity.EntityType.CAT),
		CAVE_SPIDER(net.minecraft.world.entity.EntityType.CAVE_SPIDER),
		CHEST_BOAT(net.minecraft.world.entity.EntityType.CHEST_BOAT),
		CHEST_MINECART(net.minecraft.world.entity.EntityType.CHEST_MINECART),
		CHICKEN(net.minecraft.world.entity.EntityType.CHICKEN),
		COD(net.minecraft.world.entity.EntityType.COD),
		COMMAND_BLOCK_MINECART(net.minecraft.world.entity.EntityType.COMMAND_BLOCK_MINECART),
		COW(net.minecraft.world.entity.EntityType.COW),
		CREEPER(net.minecraft.world.entity.EntityType.CREEPER),
		DOLPHIN(net.minecraft.world.entity.EntityType.DOLPHIN),
		DONKEY(net.minecraft.world.entity.EntityType.DONKEY),
		DRAGON_FIREBALL(net.minecraft.world.entity.EntityType.DRAGON_FIREBALL),
		DROWNED(net.minecraft.world.entity.EntityType.DROWNED),
		EGG(net.minecraft.world.entity.EntityType.EGG),
		ELDER_GUARDIAN(net.minecraft.world.entity.EntityType.ELDER_GUARDIAN),
		END_CRYSTAL(net.minecraft.world.entity.EntityType.END_CRYSTAL),
		ENDER_DRAGON(net.minecraft.world.entity.EntityType.ENDER_DRAGON),
		ENDER_PEARL(net.minecraft.world.entity.EntityType.ENDER_PEARL),
		ENDERMAN(net.minecraft.world.entity.EntityType.ENDERMAN),
		ENDERMITE(net.minecraft.world.entity.EntityType.ENDERMITE),
		EVOKER(net.minecraft.world.entity.EntityType.EVOKER),
		EVOKER_FANGS(net.minecraft.world.entity.EntityType.EVOKER_FANGS),
		EXPERIENCE_BOTTLE(net.minecraft.world.entity.EntityType.EXPERIENCE_BOTTLE),
		EXPERIENCE_ORB(net.minecraft.world.entity.EntityType.EXPERIENCE_ORB),
		EYE_OF_ENDER(net.minecraft.world.entity.EntityType.EYE_OF_ENDER),
		FALLING_BLOCK(net.minecraft.world.entity.EntityType.FALLING_BLOCK),
		FIREWORK_ROCKET(net.minecraft.world.entity.EntityType.FIREWORK_ROCKET),
		FOX(net.minecraft.world.entity.EntityType.FOX),
		FROG(net.minecraft.world.entity.EntityType.FROG),
		FURNACE_MINECART(net.minecraft.world.entity.EntityType.FURNACE_MINECART),
		GHAST(net.minecraft.world.entity.EntityType.GHAST),
		GIANT(net.minecraft.world.entity.EntityType.GIANT),
		GLOW_ITEM_FRAME(net.minecraft.world.entity.EntityType.GLOW_ITEM_FRAME),
		GLOW_SQUID(net.minecraft.world.entity.EntityType.GLOW_SQUID),
		GOAT(net.minecraft.world.entity.EntityType.GOAT),
		GUARDIAN(net.minecraft.world.entity.EntityType.GUARDIAN),
		HOGLIN(net.minecraft.world.entity.EntityType.HOGLIN),
		HOPPER_MINECART(net.minecraft.world.entity.EntityType.HOPPER_MINECART),
		HORSE(net.minecraft.world.entity.EntityType.HORSE),
		HUSK(net.minecraft.world.entity.EntityType.HUSK),
		ILLUSIONER(net.minecraft.world.entity.EntityType.ILLUSIONER),
		INTERACTION(net.minecraft.world.entity.EntityType.INTERACTION),
		IRON_GOLEM(net.minecraft.world.entity.EntityType.IRON_GOLEM),
		ITEM(net.minecraft.world.entity.EntityType.ITEM),
		ITEM_DISPLAY(net.minecraft.world.entity.EntityType.ITEM_DISPLAY),
		ITEM_FRAME(net.minecraft.world.entity.EntityType.ITEM_FRAME),
		FIREBALL(net.minecraft.world.entity.EntityType.FIREBALL),
		LEASH_KNOT(net.minecraft.world.entity.EntityType.LEASH_KNOT),
		LIGHTNING_BOLT(net.minecraft.world.entity.EntityType.LIGHTNING_BOLT),
		LLAMA(net.minecraft.world.entity.EntityType.LLAMA),
		LLAMA_SPIT(net.minecraft.world.entity.EntityType.LLAMA_SPIT),
		MAGMA_CUBE(net.minecraft.world.entity.EntityType.MAGMA_CUBE),
		MARKER(net.minecraft.world.entity.EntityType.MARKER),
		MINECART(net.minecraft.world.entity.EntityType.MINECART),
		MOOSHROOM(net.minecraft.world.entity.EntityType.MOOSHROOM),
		MULE(net.minecraft.world.entity.EntityType.MULE),
		OCELOT(net.minecraft.world.entity.EntityType.OCELOT),
		PAINTING(net.minecraft.world.entity.EntityType.PAINTING),
		PANDA(net.minecraft.world.entity.EntityType.PANDA),
		PARROT(net.minecraft.world.entity.EntityType.PARROT),
		PHANTOM(net.minecraft.world.entity.EntityType.PHANTOM),
		PIG(net.minecraft.world.entity.EntityType.PIG),
		PIGLIN(net.minecraft.world.entity.EntityType.PIGLIN),
		PIGLIN_BRUTE(net.minecraft.world.entity.EntityType.PIGLIN_BRUTE),
		PILLAGER(net.minecraft.world.entity.EntityType.PILLAGER),
		POLAR_BEAR(net.minecraft.world.entity.EntityType.POLAR_BEAR),
		POTION(net.minecraft.world.entity.EntityType.POTION),
		PUFFERFISH(net.minecraft.world.entity.EntityType.PUFFERFISH),
		RABBIT(net.minecraft.world.entity.EntityType.RABBIT),
		RAVAGER(net.minecraft.world.entity.EntityType.RAVAGER),
		SALMON(net.minecraft.world.entity.EntityType.SALMON),
		SHEEP(net.minecraft.world.entity.EntityType.SHEEP),
		SHULKER(net.minecraft.world.entity.EntityType.SHULKER),
		SHULKER_BULLET(net.minecraft.world.entity.EntityType.SHULKER_BULLET),
		SILVERFISH(net.minecraft.world.entity.EntityType.SILVERFISH),
		SKELETON(net.minecraft.world.entity.EntityType.SKELETON),
		SKELETON_HORSE(net.minecraft.world.entity.EntityType.SKELETON_HORSE),
		SLIME(net.minecraft.world.entity.EntityType.SLIME),
		SMALL_FIREBALL(net.minecraft.world.entity.EntityType.SMALL_FIREBALL),
		SNIFFER(net.minecraft.world.entity.EntityType.SNIFFER),
		SNOW_GOLEM(net.minecraft.world.entity.EntityType.SNOW_GOLEM),
		SNOWBALL(net.minecraft.world.entity.EntityType.SNOWBALL),
		SPAWNER_MINECART(net.minecraft.world.entity.EntityType.SPAWNER_MINECART),
		SPECTRAL_ARROW(net.minecraft.world.entity.EntityType.SPECTRAL_ARROW),
		SPIDER(net.minecraft.world.entity.EntityType.SPIDER),
		SQUID(net.minecraft.world.entity.EntityType.SQUID),
		STRAY(net.minecraft.world.entity.EntityType.STRAY),
		STRIDER(net.minecraft.world.entity.EntityType.STRIDER),
		TADPOLE(net.minecraft.world.entity.EntityType.TADPOLE),
		TEXT_DISPLAY(net.minecraft.world.entity.EntityType.TEXT_DISPLAY),
		TNT(net.minecraft.world.entity.EntityType.TNT),
		TNT_MINECART(net.minecraft.world.entity.EntityType.TNT_MINECART),
		TRADER_LLAMA(net.minecraft.world.entity.EntityType.TRADER_LLAMA),
		TRIDENT(net.minecraft.world.entity.EntityType.TRIDENT),
		TROPICAL_FISH(net.minecraft.world.entity.EntityType.TROPICAL_FISH),
		TURTLE(net.minecraft.world.entity.EntityType.TURTLE),
		VEX(net.minecraft.world.entity.EntityType.VEX),
		VILLAGER(net.minecraft.world.entity.EntityType.VILLAGER),
		VINDICATOR(net.minecraft.world.entity.EntityType.VINDICATOR),
		WANDERING_TRADER(net.minecraft.world.entity.EntityType.WANDERING_TRADER),
		WARDEN(net.minecraft.world.entity.EntityType.WARDEN),
		WITCH(net.minecraft.world.entity.EntityType.WITCH),
		WITHER(net.minecraft.world.entity.EntityType.WITHER),
		WITHER_SKELETON(net.minecraft.world.entity.EntityType.WITHER_SKELETON),
		WITHER_SKULL(net.minecraft.world.entity.EntityType.WITHER_SKULL),
		WOLF(net.minecraft.world.entity.EntityType.WOLF),
		ZOGLIN(net.minecraft.world.entity.EntityType.ZOGLIN),
		ZOMBIE(net.minecraft.world.entity.EntityType.ZOMBIE),
		ZOMBIE_HORSE(net.minecraft.world.entity.EntityType.ZOMBIE_HORSE),
		ZOMBIE_VILLAGER(net.minecraft.world.entity.EntityType.ZOMBIE_VILLAGER),
		ZOMBIFIED_PIGLIN(net.minecraft.world.entity.EntityType.ZOMBIFIED_PIGLIN),
		PLAYER(net.minecraft.world.entity.EntityType.PLAYER),
		FISHING_BOBBER(net.minecraft.world.entity.EntityType.FISHING_BOBBER);

		private final net.minecraft.world.entity.EntityType<?> root;
		EntityType(net.minecraft.world.entity.EntityType root) {
			this.root = root;
		}

		/**
		 * Gets the root of this EntityType.
		 *
		 * @return the root.
		 */
		public net.minecraft.world.entity.EntityType<?> getRoot() {
			return root;
		}
	}

}
