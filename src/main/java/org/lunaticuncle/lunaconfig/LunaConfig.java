package org.lunaticuncle.lunaconfig;

import net.fabricmc.api.ModInitializer;
import org.lunaticuncle.lunaconfig.gui.utils.TextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.List;


public class LunaConfig implements ModInitializer, GameStartEntrypoint{
    public static final String MOD_ID = "lunaconfig";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Luna-Config initialized.");
    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}
}
