package com.ankoki.dobneun.biomes;

import net.minecraft.world.level.biome.BiomeSpecialEffects;

public enum GrassColourModifier {

	NONE(BiomeSpecialEffects.GrassColorModifier.NONE),
	DARK_FOREST(BiomeSpecialEffects.GrassColorModifier.DARK_FOREST),
	SWAMP(BiomeSpecialEffects.GrassColorModifier.SWAMP);

	private final BiomeSpecialEffects.GrassColorModifier modifier;
	GrassColourModifier(BiomeSpecialEffects.GrassColorModifier modifier) {
		this.modifier = modifier;
	}

	/**
	 * Gets the modifier associated with the enum.
	 *
	 * @return the modifier.
	 */
	public BiomeSpecialEffects.GrassColorModifier getModifier() {
		return modifier;
	}

}
