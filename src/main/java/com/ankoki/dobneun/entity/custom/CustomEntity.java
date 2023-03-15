package com.ankoki.dobneun.entity.custom;

import com.ankoki.dobneun.misc.Misc;
import com.ankoki.dobneun.reflection.Reflection;
import com.mojang.authlib.GameProfile;
import net.minecraft.network.Connection;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.net.Socket;

// UNTESTED
public class CustomEntity extends ServerPlayer {

	public CustomEntity(World world, GameProfile profile) {
		super((MinecraftServer) Reflection.invokeMethod(Reflection.getCraftBukkit("CraftServer"), "getServer", Bukkit.getServer()),
				(ServerLevel) Reflection.invokeMethod(Reflection.getCraftBukkit("CraftWorld"), "getHandle", world),
				profile);
		Socket socket = new Socket() {
			@Override
			public InputStream getInputStream() {
				return new ByteArrayInputStream(new byte[50]);
			}

			@Override
			public OutputStream getOutputStream() {
				return new ByteArrayOutputStream(5);
			}
		};
		Connection connection = new Connection(PacketFlow.CLIENTBOUND) {
			@Override
			public boolean isConnected() {
				return true;
			}

			@Override
			public void send(Packet<?> packet, @Nullable PacketSendListener callbacks) {}
		};
		this.connection = new ServerGamePacketListenerImpl((MinecraftServer) Reflection.invokeMethod(Reflection.getCraftBukkit("CraftServer"), "getServer", Bukkit.getServer()), connection, this) {
			@Override
			public void send(Packet<?> packet, @Nullable PacketSendListener callbacks) {}
		};
		connection.setListener(this.connection);
		try {
			socket.close();
		} catch (IOException ex) { Misc.handleException(ex); }
	}

	/**
	 * Spawns the current entity.
	 *
	 * @return the bukkit representation of this player entity.
	 */
	public LivingEntity spawn() {
		return this.getBukkitEntity();
	}

}
