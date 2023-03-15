package com.ankoki.dobneun.biomes;

import net.minecraft.world.level.biome.Biome;

public enum TemperatureModifier {

	NONE(Biome.TemperatureModifier.NONE),
	FROZEN(Biome.TemperatureModifier.FROZEN);

	private final Biome.TemperatureModifier root;
	TemperatureModifier(Biome.TemperatureModifier root) {
		this.root = root;
	}

	/**
	 * Gets the root of this modifier.
	 *
	 * @return the root.
	 */
	public Biome.TemperatureModifier getRoot() {
		return this.root;
	}

}
