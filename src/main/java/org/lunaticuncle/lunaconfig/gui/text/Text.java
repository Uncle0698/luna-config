package org.lunaticuncle.lunaconfig.gui.text;

import net.minecraft.core.lang.I18n;
import org.lunaticuncle.lunaconfig.gui.utils.TextUtil;

import java.util.Arrays;
import java.util.List;


public class Text {
	private final String langTranslationKey;
	private final boolean containsPlaceholders;
	private final Object[] placeholders;

	public Text(String langTranslationKey, Object... placeholders) {
		this.langTranslationKey = langTranslationKey;
		this.placeholders = placeholders;
        this.containsPlaceholders = (placeholders.length != 0);
	}

	public String getTranslatedText() {
		I18n translator = I18n.getInstance();
		if(containsPlaceholders) {
			return translator.translateKeyAndFormat(this.langTranslationKey, this.placeholders);
		}
		return translator.translateKey(this.langTranslationKey);
	}

	public String getWrappedString(int maxLineLength) {
		return TextUtil.getWrappedString(getTranslatedText(), maxLineLength, true);
	}

	public List<String> getWrappedStringAsList(int maxLineLength) {
		return Arrays.asList(getWrappedString(maxLineLength).split("\n"));
	}

	public String toString() {
		return getTranslatedText();
	}
}
