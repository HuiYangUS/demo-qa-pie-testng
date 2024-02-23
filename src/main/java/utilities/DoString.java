package utilities;

public class DoString {

	public static String findTitleCase(String text) {
		if (text == null || text.isBlank())
			return text;

		char[] data = text.toCharArray();
		if (data.length > 0) {
			data[0] = Character.toTitleCase(data[0]);
			for (int i = 1; i < data.length; i++) {
				if (Character.isSpaceChar(data[i]))
					continue;

				if (Character.isSpaceChar(data[i - 1]))
					data[i] = Character.toTitleCase(data[i]);
			}
		}
		return String.valueOf(data);
	}

	private static String replace(String text) {
		return text.replace('-', ' ');
	}

	public static String getProperTitle(String text) {
		return findTitleCase(replace(text));
	}

}
