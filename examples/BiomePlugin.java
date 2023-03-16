package com.ankoki.dobneun;

import com.ankoki.dobneun.biomes.*;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

// The plugin must load at STARTUP, before worlds are loaded.
public class BiomePlugin extends JavaPlugin implements Listener {

	private static Dobneun dobneun;
	private CustomBiome biome;

	@Override
	public void onEnable() {
		BiomePlugin.dobneun = new Dobneun(this); // This is unused for CustomBiomes, but a good practice.
		this.biome = new CustomBiome(this, "slaybiome")
				.copyDefaults() // This copies the terrain generation and monster spawning options.
				.setEffects(new BiomeEffects()
						.setFogColour("#93301B") // All colours must be hex codes.
						.setGrassColour("#3A1007") // The # is optional.
						.setSkyColour("#FF937C") // Exceptions will be thrown if not a liable colour.
						.setWaterColour("#1E2040")
						.setWaterFogColour("#693D36")
						.setFoliageColourOverride("#B19591")
						.setGrassColourModifier(GrassColourModifier.NONE) // The default, just to show.
						.setAmbientParticle(new AmbientParticle()
								.setType(AmbientParticle.ParticleType.DUST)
								.setColour(Color.PINK) // Colour and Scale are custom properties for the Dust particle.
								.setScale(0.5F) // Different particles may have different properties, and will be mentioned in the comments of methods.
								.setProbability(0.75F))
						.setMusic(new Music()
								.setOptions(MusicOptions.MUSIC_BIOME_WARPED_FOREST)
								.setReplaceCurrent(true))) // You can also set the minimum and maximum replay delay.
				.setTemperatureModifier(TemperatureModifier.NONE) // The following are all setting to the defaults, but can still be set.
				.setTemperature(0.7F)
				.setDownfall(0.8F)
				.setPrecipitation(Precipitation.NONE)
				.register(); // Registers our current biome! Must be called in onEnable.
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	// This sets the biome at the player to our custom one.
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		this.biome.setBiome(event.getPlayer().getChunk());
	}

}
