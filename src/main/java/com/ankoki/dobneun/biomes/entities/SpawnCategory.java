package com.ankoki.dobneun.biomes.entities;

import net.minecraft.world.entity.MobCategory;

public enum SpawnCategory {

	MONSTER(MobCategory.MONSTER),
	CREATURE(MobCategory.CREATURE),
	AMBIENT(MobCategory.AMBIENT),
	AXOLOTLS(MobCategory.AXOLOTLS),
	UNDERGROUND_WATER_CREATURE(MobCategory.UNDERGROUND_WATER_CREATURE),
	WATER_CREATURE(MobCategory.WATER_CREATURE),
	WATER_AMBIENT(MobCategory.WATER_AMBIENT),
	MISC(MobCategory.MISC);

	private final MobCategory root;
	SpawnCategory(MobCategory root) {
		this.root = root;
	}

	/**
	 * The root of the category.
	 *
	 * @return the root.
	 */
	public MobCategory getRoot() {
		return root;
	}

}
