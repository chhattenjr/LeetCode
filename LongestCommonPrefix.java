import java.util.*;

/**
 * @date 04/15/2019
 * @author chhatten
 * @description
 * 	Function finds the longest common prefix string amongst an array of strings.
 *
 */
public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] stringArray) {
		// Class Variables
		int length = stringArray.length; // Used to keep track of the length of the array
		int elementSize = 0; // Used to keep track of the number of elements inside the array
		String elementToCompare = ""; // Used for comparing strings
		String elementToCompareAgainst = ""; // Used for comparing strings
		String longestCommonPrefix = ""; // Used for holding the longest common prefix
		List<String> modifiedStringArray = new ArrayList<String>(); // Holds the elements of the string array contents
		List<String> sharedCharacterString = new ArrayList<String>(); // Holds the shared characters of the string
		
		// Inserts the elements of the string input into an array list
		// For the purpose of modifying within the method
		for(int i = 0; i < stringArray.length; i++) {
			modifiedStringArray.add(stringArray[i]);
			
			if(elementSize < stringArray[i].length()) {
				elementSize = stringArray[i].length()*100;
			}
		}
		
		// If the string array has no elements..
		// The variable longestCommonPrefix will hold an empty string
		if(stringArray.length <= 0) {
			longestCommonPrefix = "";
		}
		
		// If the string array has one element..
		// The variable longestCommonPrefix will hold the element
		if(stringArray.length == 1) {
			longestCommonPrefix = modifiedStringArray.get(0);
		}
		
		// If the string array has multiple elements..
		// The string array will enter these procedural steps
		if(stringArray.length > 1) {
			// The elementSize variable will be used to hold the length of the
			// string array
			
			// For-loop is used to traverse the modifiedStringArray variable
			for(int i = 0; i < length; i++) {
				// Elements at index i will be retrieved and inserted into the elementToCompare variable
				elementToCompare = modifiedStringArray.get(i);
				
				// For-loop is used to traverse the modifiedStringArray variable
				// For comparing the elementToCompare against the elementToCompareAgainst
				for(int j = 0; j < length; j++) {
					// Elements at index j will be retrieved and inserted into the elementToCompareAgainst
					elementToCompareAgainst = modifiedStringArray.get(j);
					
					// If the elementToCompare does not equals the ElementToCompareAgainst
					// The compareStrings method returns the common string of characters
					// between the two strings
					if((!(elementToCompare.equals(elementToCompareAgainst)))) {
						sharedCharacterString.add(compareStrings(elementToCompare, elementToCompareAgainst));
						// Used to collect the common strings of characters between all of the strings
						// within the string array
					}
				}
				
				// For loop reallocates the modifiedStringArray
				// Leaving out the elementToCompare (Optional Use - Might not need)
				for(int k = 0; k < length; k++) {
					if(!(modifiedStringArray.contains(elementToCompare))) {
						modifiedStringArray.add(k, modifiedStringArray.get(k));
					}
				}
			}
			
			// If the sharedCharacterString array has more than one element..
			if(sharedCharacterString.size() > 1) {
				// For-Loop that traverses the sharedCharacterString array
				// returns the shortest string of character
				for(int i = 0; i < sharedCharacterString.size(); i++) {
					if(elementSize >= (sharedCharacterString.get(i).length())) {
						elementSize = sharedCharacterString.get(i).length();
						longestCommonPrefix = sharedCharacterString.get(i);
					}
				}
			// If the stringArray has one element..
			} else {
				longestCommonPrefix = stringArray[0];
			}	
		} 
		
		// Returns the longest common prefix between words
		return longestCommonPrefix;
	}
	
	public static String compareStrings(String element1, String element2) {
		// Class Variables
		int length = 0; // Holds the length of the longest element
		String element1String = element1; // Holds the element1 string
		String element2String = element2; // Holds the element2 string
		String sharedCharacterString = ""; // Holds the common characters between the two strings
		List<String> sharedCharacters = new ArrayList<String>(); // Used to hold the characters that match
		
		// If statement that retrieves the shortest string input
		if(element1String.length() < element2String.length()) {
			length = element1String.length();
		} else {
			length = element2String.length();
		}
		
		// For-Loop that compares the two strings
		for(int i = 0; i < length; i ++) {
			element1 = String.valueOf(element1String.charAt(i));
			element2 = String.valueOf(element2String.charAt(i));
			
			// Adds the string characters that are equivalent to sharedCharacters arrayList
			if((element1.equals(element2))){
				sharedCharacters.add(element1);
			} else {
				break;
			}
		}
		
		// Creates the sharedCharacterString String to return
		for(String element : sharedCharacters) {
			sharedCharacterString+=element;
		}
		
		// Return statement
        return sharedCharacterString;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strings = {"flower", "flow", "flight"};
		String[] strings2 = {"dog", "racecar", "car"};
		String[] strings3 = {"c", "c"};
		String[] strings4 = {"aca", "cba"};
		String[] strings5 = {""};
		String[] strings6 = {"s"};
		String[] strings7 = {"aa", "aa"};
		String[] strings8 = {"ab", "abcc"};
		
		
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings));
		System.out.println();
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings2));
		System.out.println();
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings3));
		System.out.println();
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings4));
		System.out.println();
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings5));
		System.out.println();
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings6));
		System.out.println();
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings7));
		System.out.println();
		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings8));
		
		System.out.println(compareStrings("c", "c"));

		
		String stringToCompare = "flower";
        String stringToCompare1 = "flow";
        String stringToCompare2 = "aca";
        String stringToCompare3 = "cba";
        
        System.out.println("Longest Common Prefix: " + compareStrings(stringToCompare, stringToCompare1));
        System.out.println();
        System.out.println("Longest Common Prefix: " + compareStrings(stringToCompare2, stringToCompare3));
        
		String[] strings9 = {"abca", "abc"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strings));
	}

}