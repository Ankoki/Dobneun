package com.ankoki.dobneun.biomes.effects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class AmbientParticle {

	private net.minecraft.core.particles.ParticleType<?> type;
	private float probability = 0.005F;
	private Color colour;
	private float scale = 1;

	/**
	 * Safely casts a particle type to another.
	 *
	 * @param type the type to cast.
	 * @param clazz the class to cast to.
	 * @param <T> the cast value.
	 * @return the cast value, or null.
	 */
	@Nullable
	public static <T extends ParticleOptions> net.minecraft.core.particles.ParticleType<T> cast(net.minecraft.core.particles.ParticleType<?> type, Class<T> clazz) {
		try {
			return (net.minecraft.core.particles.ParticleType<T>) type;
		} catch (ClassCastException ignored) { return null; }
	}

	/**
	 * Gets the current particle type.
	 *
	 * @return the type.
	 */
	public net.minecraft.core.particles.ParticleType<?> getType() {
		return type;
	}

	/**
	 * Sets the current particle type.
	 *
	 * @return the current instance for chaining.
	 */
	public AmbientParticle setType(ParticleType type) {
		this.type = type.getType();
		return this;
	}

	/**
	 * Checks if this particle has a type.
	 *
	 * @return true if present.
	 */
	public boolean hasType() {
		return this.type != null;
	}

	/**
	 * Gets the current probability of this particle to spawn.
	 *
	 * @return the probability.
	 */
	public float getProbability() {
		return this.probability;
	}

	/**
	 * Sets the probability of this particle to spawn. Should be from 0-1.
	 *
	 * @param probability the probability.
	 * @return the current instance for chaining.
	 */
	public AmbientParticle setProbability(float probability) {
		this.probability = probability;
		return this;
	}

	/**
	 * Only used if {@link AmbientParticle#setType(ParticleType)} is set to {@link ParticleType#DUST}.
	 * Gets the colour of this particle.

	 * @return the colour.
	 */
	public Color getColour() {
		return this.colour;
	}

	/**
	 * Only use this if you're using {@link ParticleType#DUST} as a particle type.
	 * Sets the colour of this particle.
	 *
	 * @param colour the colour to set it too.
	 * @return the current instance for chaining.
	 */
	public AmbientParticle setColour(Color colour) {
		this.colour = colour;
		return this;
	}

	/**
	 * Only used if {@link AmbientParticle#setType(ParticleType)} is set to {@link ParticleType#DUST}.
	 * Checks if this particle has a colour.
	 *
	 * @return true if present.
	 */
	public boolean hasColour() {
		return this.colour != null;
	}

	/**
	 * Only used if {@link AmbientParticle#setType(ParticleType)} is set to {@link ParticleType#DUST}.
	 * Gets the scale of this particle.

	 * @return the scale.
	 */
	public float getScale() {
		return this.scale;
	}

	/**
	 * Only use this if you're using {@link ParticleType#DUST} as a particle type.
	 * Sets the scale of this particle.
	 *
	 * @param scale the scale to set it too.
	 * @return the current instance for chaining.
	 */
	public AmbientParticle setScale(float scale) {
		this.scale = scale;
		return this;
	}

	@SuppressWarnings("unused")
	public enum ParticleType {
		AMBIENT_ENTITY_EFFECT(ParticleTypes.AMBIENT_ENTITY_EFFECT),
		ANGRY_VILLAGER(ParticleTypes.ANGRY_VILLAGER),
		// BLOCK(ParticleTypes.BLOCK), Disabled until I work out a nice way to do BlockParticleOptions.
		// BLOCK_MARKER(ParticleTypes.BLOCK_MARKER), Disabled until I work out a nice way to do BlockParticleOptions.
		BUBBLE(ParticleTypes.BUBBLE),
		CLOUD(ParticleTypes.CLOUD),
		CRIT(ParticleTypes.CRIT),
		DAMAGE_INDICATOR(ParticleTypes.DAMAGE_INDICATOR),
		DRAGON_BREATH(ParticleTypes.DRAGON_BREATH),
		DRIPPING_LAVA(ParticleTypes.DRIPPING_LAVA),
		FALLING_LAVA(ParticleTypes.FALLING_LAVA),
		LANDING_LAVA(ParticleTypes.LANDING_LAVA),
		DRIPPING_WATER(ParticleTypes.DRIPPING_WATER),
		FALLING_WATER(ParticleTypes.FALLING_WATER),
		DUST(ParticleTypes.DUST),
		DUST_COLOUR_TRANSITION(ParticleTypes.DUST_COLOR_TRANSITION), // TODO add colour transition.
		EFFECT(ParticleTypes.EFFECT),
		ELDER_GUARDIAN(ParticleTypes.ELDER_GUARDIAN),
		ENCHANTED_HIT(ParticleTypes.ENCHANTED_HIT),
		ENCHANT(ParticleTypes.ENCHANT),
		END_ROD(ParticleTypes.END_ROD),
		ENTITY_EFFECT(ParticleTypes.ENTITY_EFFECT),
		EXPLOSION_EMITTER(ParticleTypes.EXPLOSION_EMITTER),
		EXPLOSION(ParticleTypes.EXPLOSION),
		SONIC_BOOM(ParticleTypes.SONIC_BOOM),
		// FALLING_DUST(ParticleTypes.FALLING_DUST), Disabled until I work out a nice way to do BlockParticleOptions.
		FIREWORK(ParticleTypes.FIREWORK),
		FISHING(ParticleTypes.FISHING),
		FLAME(ParticleTypes.FLAME),
		SCULK_SOUL(ParticleTypes.SCULK_SOUL),
		SCULK_CHARGE(ParticleTypes.SCULK_CHARGE),
		SCULK_CHARGE_POP(ParticleTypes.SCULK_CHARGE_POP),
		SOUL_FIRE_FLAME(ParticleTypes.SOUL_FIRE_FLAME),
		SOUL(ParticleTypes.SOUL),
		FLASH(ParticleTypes.FLASH),
		HAPPY_VILLAGER(ParticleTypes.HAPPY_VILLAGER),
		COMPOSTER(ParticleTypes.COMPOSTER),
		HEART(ParticleTypes.HEART),
		INSTANT_EFFECT(ParticleTypes.INSTANT_EFFECT),
		ITEM(ParticleTypes.ITEM),
		VIBRATION(ParticleTypes.VIBRATION), // TODO figure out how to add direction
		ITEM_SLIME(ParticleTypes.ITEM_SLIME),
		ITEM_SNOWBALL(ParticleTypes.ITEM_SNOWBALL),
		LARGE_SMOKE(ParticleTypes.LARGE_SMOKE),
		LAVA(ParticleTypes.LAVA),
		MYCELIUM(ParticleTypes.MYCELIUM),
		NOTE(ParticleTypes.NOTE),
		POOF(ParticleTypes.POOF),
		PORTAL(ParticleTypes.PORTAL),
		RAIN(ParticleTypes.RAIN),
		SMOKE(ParticleTypes.SMOKE),
		SNEEZE(ParticleTypes.SNEEZE),
		SPIT(ParticleTypes.SPIT),
		SQUID_INK(ParticleTypes.SQUID_INK),
		SWEEP_ATTACK(ParticleTypes.SWEEP_ATTACK),
		TOTEM_OF_UNDYING(ParticleTypes.TOTEM_OF_UNDYING),
		UNDERWATER(ParticleTypes.UNDERWATER),
		SPLASH(ParticleTypes.SPLASH),
		WITCH(ParticleTypes.WITCH),
		BUBBLE_POP(ParticleTypes.BUBBLE_POP),
		CURRENT_DOWN(ParticleTypes.CURRENT_DOWN),
		BUBBLE_COLUMN_UP(ParticleTypes.BUBBLE_COLUMN_UP),
		NAUTILUS(ParticleTypes.NAUTILUS),
		DOLPHIN(ParticleTypes.DOLPHIN),
		CAMPFIRE_COSY_SMOKE(ParticleTypes.CAMPFIRE_COSY_SMOKE),
		CAMPFIRE_SIGNAL_SMOKE(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE),
		DRIPPING_HONEY(ParticleTypes.DRIPPING_HONEY),
		FALLING_HONEY(ParticleTypes.FALLING_HONEY),
		LANDING_HONEY(ParticleTypes.LANDING_HONEY),
		FALLING_NECTAR(ParticleTypes.FALLING_NECTAR),
		FALLING_SPORE_BLOSSOM(ParticleTypes.FALLING_SPORE_BLOSSOM),
		ASH(ParticleTypes.ASH),
		CRIMSON_SPORE(ParticleTypes.CRIMSON_SPORE),
		WARPED_SPORE(ParticleTypes.WARPED_SPORE),
		SPORE_BLOSSOM_AIR(ParticleTypes.SPORE_BLOSSOM_AIR),
		DRIPPING_OBSIDIAN_TEAR(ParticleTypes.DRIPPING_OBSIDIAN_TEAR),
		FALLING_OBSIDIAN_TEAR(ParticleTypes.FALLING_OBSIDIAN_TEAR),
		LANDING_OBSIDIAN_TEAR(ParticleTypes.LANDING_OBSIDIAN_TEAR),
		REVERSE_PORTAL(ParticleTypes.REVERSE_PORTAL),
		WHITE_ASH(ParticleTypes.WHITE_ASH),
		SMALL_FLAME(ParticleTypes.SMALL_FLAME),
		SNOWFLAKE(ParticleTypes.SNOWFLAKE),
		DRIPPING_DRIPSTONE_LAVA(ParticleTypes.DRIPPING_DRIPSTONE_LAVA),
		FALLING_DRIPSTONE_LAVA(ParticleTypes.FALLING_DRIPSTONE_LAVA),
		DRIPPING_DRIPSTONE_WATER(ParticleTypes.DRIPPING_DRIPSTONE_WATER),
		FALLING_DRIPSTONE_WATER(ParticleTypes.FALLING_DRIPSTONE_WATER),
		GLOW_SQUID_INK(ParticleTypes.GLOW_SQUID_INK),
		GLOW(ParticleTypes.GLOW),
		WAX_ON(ParticleTypes.WAX_ON),
		WAX_OFF(ParticleTypes.WAX_OFF),
		ELECTRIC_SPARK(ParticleTypes.ELECTRIC_SPARK),
		SCRAPE(ParticleTypes.SCRAPE),
		SHRIEK(ParticleTypes.SHRIEK);

		private net.minecraft.core.particles.ParticleType<?> type;
		ParticleType(net.minecraft.core.particles.ParticleType<?> type) {
			this.type = type;
		}

		/**
		 * Gets the ParticleType of this type.
		 *
		 * @return the type.
		 */
		public net.minecraft.core.particles.ParticleType<?> getType() {
			return type;
		}

	}

}
