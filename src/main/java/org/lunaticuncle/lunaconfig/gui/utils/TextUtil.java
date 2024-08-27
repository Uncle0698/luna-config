package org.lunaticuncle.lunaconfig.gui.utils;

public final class TextUtil {
	private static final String FORMAT_CODES = "0123456789abcdefklmnor";

	public static String getWrappedString(String inputString, int maxLineLength, boolean isFormatted) {
		if(inputString == null) {
			return null;
		}

		StringBuilder wrappedString = new StringBuilder();
		int inputLength = inputString.length();
		int curLineLength = 0;

		for(int i = 0; i < inputLength ; ++i) {
			char curChar = inputString.charAt(i);

			if(curChar == ' ') {
				wrappedString.append(curChar);
				++curLineLength;
				if(curLineLength >= maxLineLength) {
					wrappedString.append("\n");
					curLineLength = 0;
				}
			} else if(isFormatted && curChar == '§') {
				wrappedString.append(curChar);
				if(i + 1 >= inputLength) {
					break;
				}

				char nextChar = inputString.charAt(i + 1);
				if(FORMAT_CODES.contains(String.valueOf(nextChar))) {
					++i;
					wrappedString.append(nextChar);
				} else if(nextChar == '<') {
					++i;
					while(nextChar != '>' && i < inputLength) {
						nextChar = inputString.charAt(i);
						wrappedString.append(nextChar);
						++i;
					}
				}
			} else {
				wrappedString.append(curChar);
				++curLineLength;
			}
		}

		return wrappedString.toString();
	}

}
