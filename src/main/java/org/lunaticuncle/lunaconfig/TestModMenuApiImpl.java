package org.lunaticuncle.lunaconfig;

import io.github.prospector.modmenu.api.ModMenuApi;
import io.github.prospector.modmenu.util.TriConsumer;
import net.minecraft.client.gui.GuiScreen;
import org.lunaticuncle.lunaconfig.gui.LunaConfigScreen;
import org.lunaticuncle.lunaconfig.gui.utils.Vector2i;
import org.lunaticuncle.lunaconfig.gui.widgets.NormalRectangle;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestModMenuApiImpl implements ModMenuApi {

	@Override
	public String getModId() {
		return null;
	}

	@Override
	public Optional<Supplier<GuiScreen>> getConfigScreen(GuiScreen screen) {
		return ModMenuApi.super.getConfigScreen(screen);
	}

	@Override
	public Function<GuiScreen, ? extends GuiScreen> getConfigScreenFactory() {
		return (parentScreen) -> {
			return new
				LunaConfigScreen.Builder()
				.withParentScreen(parentScreen)
				.withChild(new NormalRectangle.Builder()
							   .withPosition(new Vector2i(100, 100))
							   .withSize(new Vector2i(100, 100))
							   .build())
				.build();
		};
	}

	@Override
	public void attachCustomBadges(TriConsumer<String, Integer, Integer> consumer) {
		ModMenuApi.super.attachCustomBadges(consumer);
	}
}
