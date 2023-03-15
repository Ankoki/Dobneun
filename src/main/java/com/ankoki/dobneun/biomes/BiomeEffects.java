package com.ankoki.dobneun.biomes;

import net.minecraft.sounds.Music;

/**
 * {@link CustomBiome#setEffects(BiomeEffects)}
 */
public class BiomeEffects {

	private int fogColour = -1;
	private int waterColour = -1;
	private int waterFogColour = -1;
	private int skyColour = -1;
	private int grassColour = -1;
	private int foliageColourOverride = -1;
	private GrassColourModifier grassColourModifier = GrassColourModifier.NONE;
	private Music music;
	private MusicOptions ambientLoop;
	private AmbientParticle ambientParticle;

	/**
	 * Gets the current fog colour of this effect.
	 *
	 * @return the fog colour.
	 */
	public int getFogColour() {
		return fogColour;
	}

	/**
	 * Sets the fog colour of this effect. Please provide a hexcode colour value. The # at the start is optional.
	 *
	 * @param fogColour the new fog colour.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setFogColour(String fogColour) {
		this.fogColour = Integer.parseInt(fogColour.replace("#", ""), 16);
		return this;
	}

	/**
	 * Checks if this effect has a fog colour.
	 *
	 * @return true if present.
	 */
	public boolean hasFogColour() {
		return this.fogColour != -1;
	}

	/**
	 * Gets the water colour of this effect.
	 *
	 * @return the water colour.
	 */
	public int getWaterColour() {
		return waterColour;
	}

	/**
	 * Sets the water colour of this effect. Please provide a hexcode colour value. The # at the start is optional.
	 *
	 * @param waterColour the new water colour.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setWaterColour(String waterColour) {
		this.waterColour = Integer.parseInt(waterColour.replace("#", ""), 16);
		return this;
	}

	/**
	 * Checks if this effect has a water colour.
	 *
	 * @return true if present.
	 */
	public boolean hasWaterColour() {
		return this.waterColour != -1;
	}

	/**
	 * Gets the water fog colour of this effect.
	 *
	 * @return the water fog colour.
	 */
	public int getWaterFogColour() {
		return waterFogColour;
	}

	/**
	 * Sets the water fog colour of this effect. Please provide a hexcode colour value. The # at the start is optional.
	 *
	 * @param waterFogColour the new water fog colour.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setWaterFogColour(String waterFogColour) {
		this.waterFogColour = Integer.parseInt(waterFogColour.replace("#", ""), 16);
		return this;
	}

	/**
	 * Gets the sky colour of this effect.
	 *
	 * @return the sky colour .
	 */
	public int getSkyColour() {
		return skyColour;
	}

	/**
	 * Sets the sky colour of this effect. Please provide a hexcode colour value. The # at the start is optional.
	 *
	 * @param skyColour the new sky colour.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setSkyColour(String skyColour) {
		this.skyColour = Integer.parseInt(skyColour.replace("#", ""), 16);
		return this;
	}

	/**
	 * Checks if this effect has a sky colour.
	 *
	 * @return true if present.
	 */
	public boolean hasSkyColour() {
		return this.skyColour != -1;
	}

	/**
	 * Gets the grass colour of this effect.
	 *
	 * @return the grass colour.
	 */
	public int getGrassColour() {
		return grassColour;
	}

	/**
	 * Sets the grass colour of this effect. Please provide a hexcode colour value. The # at the start is optional.
	 *
	 * @param grassColour the new grass colour.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setGrassColour(String grassColour) {
		this.grassColour = Integer.parseInt(grassColour.replace("#", ""), 16);
		return this;
	}

	/**
	 * Checks if this effect has a grass colour.
	 *
	 * @return true if present.
	 */
	public boolean hasGrassColour() {
		return this.grassColour != -1;
	}

	/**
	 * Gets the foliage colour override of this effect.
	 *
	 * @return the foliage colour override.
	 */
	public int getFoliageColourOverride() {
		return foliageColourOverride;
	}

	/**
	 * Sets the foliage colour override of this effect. Please provide a hexcode colour value. The # at the start is optional.
	 *
	 * @param foliageColourOverride the new foliage colour override.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setFoliageColourOverride(String foliageColourOverride) {
		this.foliageColourOverride = Integer.parseInt(foliageColourOverride.replace("#", ""), 16);
		return this;
	}

	/**
	 * Checks if this effect has a foliage colour override.
	 *
	 * @return true if present.
	 */
	public boolean hasFoliageColourOverride() {
		return this.foliageColourOverride != -1;
	}

	/**
	 * Gets the grass colour modifier of this effect.
	 *
	 * @return the grass colour modifier.
	 */
	public GrassColourModifier getGrassColourModifier() {
		return grassColourModifier;
	}

	/**
	 * Sets the colour modifier for grass for this effect.
	 *
	 * @param grassColourModifier the modifier to use.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setGrassColourModifier(GrassColourModifier grassColourModifier) {
		this.grassColourModifier = grassColourModifier;
		return this;
	}

	/**
	 * Checks if this effect has a grass colour modifier;
	 *
	 * @return true if present.
	 */
	public boolean hasGrassColourModifier() {
		return grassColourModifier != null;
	}

	/**
	 * Gets the current music of this effect.
	 *
	 * @return the music.
	 */
	public Music getMusic() {
		return this.music;
	}

	/**
	 * Sets the music of the effect.
	 *
	 * @param music the music to set it too.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setMusic(com.ankoki.dobneun.biomes.Music music) {
		if (!music.hasOptions())
			return this;
		this.music = new Music(music.getOption().getHolder(), music.getMinDelay(), music.getMaxDelay(), music.willReplaceCurrent());
		return this;
	}

	/**
	 * Checks if the effect has music.
	 *
	 * @return true if present.
	 */
	public boolean hasMusic() {
		return this.music != null;
	}

	/**
	 * Sets the ambient loop sound for this effect.
	 *
	 * @param ambientLoop the new ambient loop sound.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setAmbientLoop(MusicOptions ambientLoop) {
		this.ambientLoop = ambientLoop;
		return this;
	}

	/**
	 * Gets the ambient loop sound.
	 *
	 * @return the loop sound.
	 */
	public MusicOptions getAmbientLoop() {
		return this.ambientLoop;
	}

	/**
	 * Checks if this biome has an ambient loop sound.
	 *
	 * @return true if present.
	 */
	public boolean hasAmbientLoop() {
		return this.ambientLoop != null;
	}

	/**
	 * Gets the current ambient particle of this effect.
	 *
	 * @return the ambient particle,
	 */
	public AmbientParticle getAmbientParticle() {
		return this.ambientParticle;
	}

	/**
	 * Sets the current ambient particle.
	 *
	 * @param ambientParticle the new ambient particle.
	 * @return the current instance for chaining.
	 */
	public BiomeEffects setAmbientParticle(AmbientParticle ambientParticle) {
		this.ambientParticle = ambientParticle;
		return this;
	}

	/**
	 * Checks if this effect has an ambient particle.
	 *
	 * @return true if present.
	 */
	public boolean hasAmbientParticle() {
		return ambientParticle != null;
	}

	/**
	 * Asserts that this BiomeEffects can be transferred correctly.
	 *
	 * @throws IllegalStateException if this BiomeEffects can be built.
	 */
	public void validate() {
		if (this.fogColour == -1)
			throw new IllegalStateException("Required effect 'fogColour' was not set.");
		else if (this.waterColour == -1)
			throw new IllegalStateException("Required effect 'waterColour' was not set.");
		else if (this.waterFogColour == -1)
			throw new IllegalStateException("Required effect 'waterFogColour' was not set.");
		else if (this.skyColour == -1)
			throw new IllegalStateException("Required effect 'skyColour' was not set.");
	}

}
