package com.ankoki.dobneun.entity;

import com.ankoki.dobneun.misc.Misc;
import com.ankoki.dobneun.misc.Version;
import com.ankoki.dobneun.reflection.Reflection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// CURRENTLY UNUSED
public class DobneunPlayer {

	private static final Map<Player, DobneunPlayer> storage = new ConcurrentHashMap<>();

	// NMS
	private static Method getHandle;
	private static Field connectionField;
	private static Method send;

	static {
		try {
			getHandle = Class.forName(Bukkit.getServer().getClass().getPackage().getName() + ".entity.CraftPlayer").getDeclaredMethod("getHandle");
			connectionField = Reflection.getClass("server.level", "EntityPlayer").getDeclaredField(Version.v1_18_R1.isNewerThanCurrent() ? "playerConnection" : "b");
			send = Reflection.getClass("server.network", "PlayerConnection").getMethod(Version.v1_18_R1.isNewerThanCurrent() ? "sendPacket" : "a", Reflection.getClass("network.protocol", "Packet"));
		} catch (ReflectiveOperationException ex) { Misc.handleException(ex); }
	}

	private final Player player;
	private Object handle, connection;

	/**
	 * Creates a new DobneunPlayer for using reflection methods easier.
	 *
	 * @param player the player to wrap.
	 */
	public DobneunPlayer(Player player) {
		this.player = player;
		if (storage.containsKey(player)) {
			DobneunPlayer dplayer = storage.get(player);
			this.handle = dplayer.handle;
			this.connection = dplayer.connection;
		} else {
			try {
				this.handle = getHandle.invoke(player);
				this.connection = connectionField.get(handle);
				storage.put(player, this);
			} catch (ReflectiveOperationException ex) { Misc.handleException(ex, player); }
		}
	}

}
