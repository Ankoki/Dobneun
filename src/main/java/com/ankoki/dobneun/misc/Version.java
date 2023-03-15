package com.ankoki.dobneun.misc;

import com.ankoki.dobneun.Dobneun;
import org.bukkit.Bukkit;

public enum Version {
	v1_13_R1,
	v1_14_R1,
	v1_15_R1,
	v1_16_R1,
	v1_16_R2,
	v1_16_R3,
	v1_16_R4,
	v1_17_R1,
	v1_18_R1,
	v1_18_R2,
	v1_19_R1,
	v1_19_R2,
	UNKNOWN;

	public static Version CURRENT;

	static {
		String packageName = Bukkit.getServer().getClass().getPackage().getName();
		String version = packageName.substring(packageName.lastIndexOf('.') + 1);
		try {
			CURRENT = Version.valueOf(version);
		} catch (IllegalArgumentException ex) {
			CURRENT = UNKNOWN;
			Dobneun.getLogger().severe("You are using an unknown version (" + version + "). You could be using a version before 1.13, or a newer version that has not been supported yet.");
		}
	}

	/**
	 * Checks if this version is newer than the current version.
	 *
	 * @return true if newer.
	 */
	public boolean isNewerThanCurrent() {
		return this.ordinal() > CURRENT.ordinal();
	}

	/**
	 * Checks if this version is older than the current version.
	 *
	 * @return true if older.
	 */
	public boolean isOlderThanCurrent() {
		return this.ordinal() < CURRENT.ordinal();
	}

}
