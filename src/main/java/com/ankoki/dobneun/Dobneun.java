package com.ankoki.dobneun;

import com.ankoki.dobneun.entity.DobneunPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * The class which handles the wrapping of players and NMS mappings.
 * It is recommended to only have one instance of Dobneun running at a time.
 */
public record Dobneun(JavaPlugin plugin) {

	private static final String minecraft = Bukkit.getBukkitVersion().split("-R")[0];
	private static final String version = "1.0";
	private static final Logger logger = new Logger("Dobneun", null) {
		@Override
		public void log(LogRecord record) {
			super.log(record);
		}
	};

	static {
		Dobneun.logger.setParent(Bukkit.getLogger());
		Dobneun.logger.setLevel(Level.ALL);
	}

	/**
	 * Gets the minecraft version of this server.
	 *
	 * @return the minecraft version.
	 */
	public static String getMinecraftVersion() {
		return minecraft;
	}

	/**
	 * Gets the version of Dobneun that is running.
	 *
	 * @return the version of Dobneun.
	 */
	public static String getVersion() {
		return version;
	}

	/**
	 * Gets the logger associated with Dobneun.
	 *
	 * @return the logger.
	 */
	public static Logger getLogger() {
		return logger;
	}

	public Dobneun(JavaPlugin plugin) {
		this.plugin = plugin;
		logger.info("Plugin '" + plugin.getName() + "' has successfully hooked into Dobneun.");
	}

	/**
	 * Wraps a bukkit player to a DobneunPlayer.
	 *
	 * @param player the player to wrap.
	 * @return the corresponding DobneunPlayer.
	 */
	public DobneunPlayer wrap(Player player) {
		return new DobneunPlayer(player);
	}

}
