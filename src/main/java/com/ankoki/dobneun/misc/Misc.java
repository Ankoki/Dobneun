package com.ankoki.dobneun.misc;

import com.ankoki.dobneun.Dobneun;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class Misc {

	/**
	 * Handles an internal exception.
	 *
	 * @param ex the exception that was thrown.
	 */
	public static void handleException(Exception ex) {
		Logger logger = Dobneun.getLogger();
		String message = ex.getLocalizedMessage();
		logger.severe("# There was an issue with Dobneun.");
		logger.severe("# Please report the whole error, including the useful information, to the applicable place.");
		logger.severe("# ");
		logger.severe("# " + ex.getClass().getName());
		logger.severe("# " + message);
		logger.severe("# ");
		for (StackTraceElement element : ex.getStackTrace())
			logger.severe("# " + element.toString());
		logger.severe("# ");
		logger.severe("# Useful Information:");
		logger.severe("# ");
		logger.severe("# Minecraft Server Version: " + Dobneun.getMinecraftVersion());
		logger.severe("# Dobneun Version: " + Dobneun.getVersion());
		logger.severe("# ");
		for (Player player : Bukkit.getOnlinePlayers()
				.stream()
				.filter(p -> p.hasPermission("dobneun.error_messages"))
				.toList()) {
			player.sendActionBar("§cThere was an internal error §7: §c" + message);
		}
	}

}
