package com.ankoki.dobneun.biomes;

import net.minecraft.world.level.biome.Biome;

public enum Precipitation {

	NONE(Biome.Precipitation.NONE),
	SNOW(Biome.Precipitation.SNOW),
	RAIN(Biome.Precipitation.RAIN);

	private final Biome.Precipitation root;
	Precipitation(Biome.Precipitation root) {
		this.root = root;
	}

	/**
	 * Gets the root of this precipitation.
	 *
	 * @return the minecraft precipitation.
	 */
	public Biome.Precipitation getRoot() {
		return root;
	}

}
