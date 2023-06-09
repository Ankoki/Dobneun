package com.ankoki.dobneun.misc;

import com.ankoki.dobneun.Dobneun;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Misc {

	/**
	 * Handles an internal exception.
	 *
	 * @param ex the exception that was thrown.
	 * @param players any related players.
	 */
	public static void handleException(Exception ex, Player... players) {
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
		logger.severe("# Players Online: " + Bukkit.getOnlinePlayers().size());
		logger.severe("# ");
		if (players.length > 0) {
			logger.severe("# Related Player(s): " + Arrays.stream(players)
					.map(Player::getName)
					.collect(Collectors.joining(", ")));
			logger.severe("# ");
		}
		for (Player player : Bukkit.getOnlinePlayers()
				.stream()
				.filter(p -> p.hasPermission("dobneun.error_messages"))
				.toList())
			player.sendActionBar("§cThere was an internal error §7: §c" + message);
	}

	/**
	 * Gets an enum value safely which returns null if not found. Whitespace and lowercase letters will be converted to
	 * uppercase and _.
	 *
	 * @param type the class of the enum.
	 * @param name the name of the value to look for.
	 * @param <E>  the class which extends enum to get the value for.
	 * @return the found value, or null.
	 */
	public static <E extends Enum<E>> E get(Class<E> type, String name) {
		try {
			return Enum.valueOf(type, name.replace(" ", "_").toUpperCase());
		} catch (NullPointerException | IllegalArgumentException ex) { return null; }
	}

}
