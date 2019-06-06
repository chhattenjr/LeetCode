import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * LeetCode Solutions
 */

/**
 * @date: 04/14/2019
 * @author chhatten
 * @description:
 *  Given a roman numeral, convert it to an integer.
 *  Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToInteger {

	public static int romanToInt(String romanToInteger) {
		int romanNumeralStringArrayCount = 0;
		int romanNumeralLength = romanToInteger.length();
		int romanNumeralInteger = 0;
		String[] romanNumeralStringArray = new String[romanNumeralLength];
		
		System.out.println("Roman Numeral: " + romanToInteger);
		
		for(int i = 0; i < romanNumeralLength; i++) {
			romanNumeralStringArray[i] = String.valueOf(romanToInteger.charAt(i));
		}
		
		romanNumeralStringArrayCount = romanNumeralStringArray.length;

		romanNumeralInteger = romanNumeralIntegerConvertor(romanNumeralStringArray, romanNumeralStringArrayCount);
		
		return romanNumeralInteger;
	}
	
	public static int romanNumeralIntegerConvertor(String[] romanNumeralStringArray, int arrayLength) {
		StackInteger romanNumerals = new StackInteger(arrayLength);
		StackInteger exceptionCases = new StackInteger(arrayLength);
		int integer = 0;
		String currentRomanNumeral = "";
		String nextRomanNumeral = "";
		String exceptionInteger = "";
		
		for(int i = 0; i < arrayLength; i++) {
			romanNumerals.push(String.valueOf(romanNumeralStringArray[i]));
		}
		
		for(int i = romanNumerals.getCount()-1; i >= 0; i--) {
			currentRomanNumeral = romanNumerals.pop();
			nextRomanNumeral = romanNumerals.peek();
			
			if(currentRomanNumeral.equals("V")) { 
				if(nextRomanNumeral.equals("I")) {
					romanNumerals.pop();
					exceptionCases.push("IV");
					i--;
				} else {
					integer+=romanNumeralConvertor(currentRomanNumeral);
				}
			}else if(currentRomanNumeral.equals("X")) {
				if(nextRomanNumeral.equals("I")){
					romanNumerals.pop();
					exceptionCases.push("IX");
					i--;
				} else {
					integer+=romanNumeralConvertor(currentRomanNumeral);
				}
			}else if(currentRomanNumeral.equals("L")) {
				if(nextRomanNumeral.equals("X")) {
					romanNumerals.pop();
					exceptionCases.push("XL");
					i--;
				} else {
					integer+=romanNumeralConvertor(currentRomanNumeral);
				}
			}else if(currentRomanNumeral.equals("C")) {
				if(nextRomanNumeral.equals("X")) {
					romanNumerals.pop();
					exceptionCases.push("XC");
					i--;
				} else {
					integer+=romanNumeralConvertor(currentRomanNumeral);
				}
			}else if(currentRomanNumeral.equals("D")) {
				if(nextRomanNumeral.equals("C")) {
					romanNumerals.pop();
					exceptionCases.push("CD");
					i--;
				} else {
					integer+=romanNumeralConvertor(currentRomanNumeral);
				}
			}else if(currentRomanNumeral.equals("M")) {
				if(nextRomanNumeral.equals("C")) {
					romanNumerals.pop();
					exceptionCases.push("CM");
					i--;
				} else {
					integer+=romanNumeralConvertor(currentRomanNumeral);
				}
			} else {
				integer+=romanNumeralConvertor(currentRomanNumeral);
			}
		}
		
		for(int i = exceptionCases.getCount()-1; i >= 0; i--) {
			exceptionInteger = exceptionCases.pop();
			integer+=romanNumeralConvertor(exceptionInteger);
		}
		
		return integer;
	}
	
	// Converts the Roman Numeral Character into an Integer
	public static int romanNumeralConvertor(String romanNumeral) {
		String numeral = romanNumeral;
		int romanNumeralInt = 0;
		
		switch(numeral) {
			case "I":
				romanNumeralInt = 1;
				break;
			case "V":
				romanNumeralInt = 5;
				break;
			case "X":
				romanNumeralInt = 10;
				break;
			case "L":
				romanNumeralInt = 50;
				break;
			case "C":
				romanNumeralInt = 100;
				break;
			case "D":
				romanNumeralInt = 500;
				break;
			case "M":
				romanNumeralInt = 1000;
				break;
			case "IV":
				romanNumeralInt = 4;
				break;
			case "IX":
				romanNumeralInt = 9;
				break;
			case "XL":
				romanNumeralInt = 40;
				break;
			case "XC":
				romanNumeralInt = 90;
				break;
			case "CD":
				romanNumeralInt = 400;
				break;
			case "CM":
				romanNumeralInt = 900;
				break;
			default:
				System.out.println("Invalid String");
				break;
		}
		
		return romanNumeralInt;
	}
	
	public static void main(String[] args) {
		System.out.println("Roman Numeral Integer: " + romanToInt("III"));
		System.out.println();
		System.out.println("Roman Numeral Integer: " + romanToInt("IV"));
		System.out.println();
		System.out.println("Roman Numeral Integer: " + romanToInt("IX"));
		System.out.println();
		System.out.println("Roman Numeral Integer: " + romanToInt("LVIII"));
		System.out.println();
		System.out.println("Roman Numeral Integer: " + romanToInt("MCMXCIV"));
	}
}

class StackInteger{
	// Class Variables
	private String[] data; // Stack Array 
	private static final int INITIAL_CAPACITY = 10; // Initial Capacity for the Stack Array
	private int size = 0; // Capacity of the Stack Array
	private int count = 0; //Number of elements inside of the Stack Array
	private String intToReturn = null; //Integer to return from Stack Array
	private boolean isEmpty = false; // The boolean value that associates with the Stack being empty or occupied

	// Default Constructor
	public StackInteger(){
		data = new String[INITIAL_CAPACITY];
	}
    
	// Custom Constructor
	public StackInteger(int initialCapacity){
		data = new String[initialCapacity];
	}
    
	// Returns the size of the string array
	public int getSize() {
		return size;
	}
	
	// Returns the amount of elements in the string array
	public int getCount() {
		return count;
	}
	
	public String peek() {
		String nextValue = "";
		
		if(!isEmpty()) {
			nextValue = data[count-1]; 
		} else {
			nextValue = "Stack is empty.";
		}
		
		
		return nextValue;
	}
	
	// Returns a boolean value 
	// that indicates if the String array is empty or not
	public boolean isEmpty() {
		if(count == 0) {
			isEmpty = true;
		}
		
		return isEmpty;
	}

	// Resizes the Stack
	public String[] dataReallocate(){
		data = Arrays.copyOf(data, size);
		return data;
	}
    
	// Pushes elements onto the Stack element
	public void push(String element){
		if(size == data.length){
			size*=2;
			data = dataReallocate();
		}    
        
		data[count] = element;
		count++;
		size++;
	}
    
	// Pops the top element off of the Stack Array
	// And returns that element
	public String pop(){
		if(count < 0){
			throw new EmptyStackException();
		}
		intToReturn = data[(count-1)];
		count--;
		size--;
		dataReallocate();
        
		return intToReturn;
	}

	public void print() {
		for(int i = 0; i < data.length; i++) {
        	if(i != data.length-1) {
        		System.out.print(data[i] + ", ");
        	} else {
        		System.out.print(data[i] + "\n");
        	}
        }
	}
}