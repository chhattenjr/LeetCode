import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @date 04/22/2019
 * @author chhattenjr
 * @description
 * 	Given a string containing just the characters specified, 
 * 	determine if the input string is valid
 *
 */

public class ValidParentheses {
	public static boolean isValid(String s) {
		char[] parentheses = s.toCharArray();
		int lengthParentheses = parentheses.length;
		boolean isTrue = false;
		String character = "";
		String nextCharacter = "";
		
		StackInteger validParentheses = new StackInteger(lengthParentheses);
		
		/*
		for(int i = 0; i < lengthParentheses; i++) {
			System.out.println("Character at " + i + ": " + parentheses[i]);
		}
		*/
		
		if(lengthParentheses < 1) {
			isTrue = false;
			System.out.println("Empty String...");
		} else if(lengthParentheses > 0 && lengthParentheses < 2) {
			isTrue = false;
			System.out.println("String is not complete...");
		} else {
			for(int i = 0; i < lengthParentheses; i++) {
				validParentheses.push(String.valueOf(parentheses[i]));
			}
			
			validParentheses.print();
			
			character = validParentheses.pop();
			nextCharacter = validParentheses.peek();
			
			System.out.println("Character: " + character);
			System.out.println("Next Character: " + nextCharacter);			
		
			/*
			if(character == "(") {
				if(nextCharacter != ")" or
			} else if(character == "{") {
				
			} else if(character == "[") {
				
			} else
			*/
			
		}
		
		return isTrue;
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("({[]})"));
		System.out.println();
		System.out.println(isValid(""));
		System.out.println();
		System.out.println(isValid("("));
	}

}

class StackInteger{
	// Class Variables
	private String[] data; // Stack Array 
	private static final int INITIAL_CAPACITY = 10; // Initial Capacity for the Stack Array
	private int size = 0; // Capacity of the Stack Array
	private int count = -1; //Number of elements inside of the Stack Array
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
	
	// Returns a boolean value 
	// that indicates if the String array is empty or not
	public boolean isEmpty() {
		if(count == 0) {
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	public String peek() {
		return data[count];
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