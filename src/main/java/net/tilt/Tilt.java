package net.tilt;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tilt implements ModInitializer{
	public static final Logger LOGGER = LoggerFactory.getLogger("tilt");

	@Override
	public void onInitialize() {
		LOGGER.info("Tilt Fix Loaded!");
	}
}
