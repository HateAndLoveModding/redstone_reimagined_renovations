package com.example.redstone_reimagined_renovations;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import com.example.redstone_reimagined_renovations.screen.FreezerScreen;

import static com.example.redstone_reimagined_renovations.RedstoneReimaginedRenovations.FREEZER_SCREEN_HANDLER;

public class RedstoneReimaginedRenovationsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(FREEZER_SCREEN_HANDLER, FreezerScreen::new);
    }
}
