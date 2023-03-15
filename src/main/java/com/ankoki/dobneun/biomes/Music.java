package com.ankoki.dobneun.biomes;

public class Music {

	private MusicOptions music;
	private int minDelay = 6000;
	private int maxDelay = 24000;
	private boolean replaceCurrent = false;

	/**
	 * Gets the current music option.
	 *
	 * @return the option.
	 */
	public MusicOptions getOption() {
		return this.music;
	}

	/**
	 * Sets the current music option.
	 *
	 * @param music the music option.
	 * @return the current instance for chaining.
	 */
	public Music setOptions(MusicOptions music) {
		this.music = music;
		return this;
	}

	/**
	 * Checks if this music has a music option.
	 *
	 * @return true if exists.
	 */
	public boolean hasOptions() {
		return music != null;
	}

	/**
	 * Gets the minimum delay of this music.
	 *
	 * @return the minimum delay.
	 */
	public int getMinDelay() {
		return this.minDelay;
	}

	/**
	 * Sets the minimum delay of this music.
	 *
	 * @param minDelay the minimum delay.
	 * @return the current instance for chaining.
	 */
	public Music setMinDelay(int minDelay) {
		this.minDelay = minDelay;
		return this;
	}

	/**
	 * Gets the maximum delay of this music.
	 *
	 * @return the maximum delay.
	 */
	public int getMaxDelay() {
		return this.maxDelay;
	}

	/**
	 * Sets the maximum delay of this music.
	 *
	 * @param maxDelay the maximum delay.
	 * @return the current instance for chaining.
	 */
	public Music setMaxDelay(int maxDelay) {
		this.maxDelay = maxDelay;
		return this;
	}

	/**
	 * Checks if this music will replace the current music.
	 *
	 * @return true if replacing.
	 */
	public boolean willReplaceCurrent() {
		return this.replaceCurrent;
	}

	/**
	 * Sets if this music should replace the current playing.
	 *
	 * @param replaceCurrent true if replacing.
	 * @return the current instance for chaining.
	 */
	public Music setReplaceCurrent(boolean replaceCurrent) {
		this.replaceCurrent = replaceCurrent;
		return this;
	}

}
