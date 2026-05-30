package de.tha.prog2.task01;

public class TextValidator {
	
	public static Validator getValidator() {
		
		return new Validator() {

			@Override
			public boolean isEmail(String input) {
				int adCount = 0;
				int adIndex = 0;
				boolean pointAfterAd = false;
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) == '@') {
						adCount++;
						adIndex = i;
					} else if (adCount == 1 && input.charAt(i) == '.') {
						pointAfterAd = true;
					}
				}
				if ((adCount < 1 || adCount > 1) || pointAfterAd == false) {
					return false;
				} else {
					return true;
				}
			}

			@Override
			public boolean isPalindrome(String input) {
				String cleanInput = input.replace(" ", "");
				String inputReverse = new StringBuilder(cleanInput).reverse().toString();
				if (cleanInput.toLowerCase().equals(inputReverse.toLowerCase())) {
					return true;
				}
				return false;
			}
	
		};
	}

}
