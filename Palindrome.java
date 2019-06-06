import java.util.*;

public class Palindrome {    

    public static boolean isPalindrome(int x) {
	    int j = 0; // Used to track the position of each element inside of the reverseCharArrayOfInteger
	    String testInteger = String.valueOf(x); // Transforms the integer inputted into a string
	    String poppedElement; // This variable is a poppedElement that is used to hold the elements that are removed from the top of the stack
	    String stringInteger = null; // Used to hold the string variable of the original integer.
	    String reverseStringInteger = ""; // Holds the reverse string version of the original integer
	    String[] reverseCharArrayOfInteger = new String[testInteger.length()]; // This string array is used to hold the elements that are removed from the top of the stack
	    boolean isPalindrome = false; // Indicates if the integer is a palindrom or not
	    
	    // In order to implement the correct operations on the integer, 
	    // the integer must be converted into a string
	    stringInteger = String.valueOf(testInteger);
	    
	    // The string length is used to create the proper string array using the custom stack constructor 
	    // defined in the stack class
	    StackInt data = new StackInt(stringInteger.length());
	    
	    // the characters of the string are traversed and pushed upon the stack
	    for(int i = 0; i < stringInteger.length(); i++) {
	    	data.push(String.valueOf(stringInteger.charAt(i)));
	    }
	    
	    // The characters push onto of the string are popped 
	    // and then placed into a String array
	    for(int i = data.getCount(); i > 0; i--) {
	    	poppedElement = data.pop();
	    	reverseCharArrayOfInteger[j] = poppedElement;
	    	j++;
	    }
	    
	    // In order to create a string that can be compared to the original, 
	    // another for loop must be created
	    for(int i = 0; i < reverseCharArrayOfInteger.length; i++) {
	    	reverseStringInteger+=reverseCharArrayOfInteger[i];
	    }
	    
	    System.out.println("Original String: " + testInteger);
	    System.out.println("Reverse String: " + reverseStringInteger);
	    
	    // Then the reverse string is compared to the original
	    if(stringInteger.equals(reverseStringInteger)) {
	    	isPalindrome = true;
	    }
	    
	    // Indicates if the integer that is inputted 
	    // is a palindrome or not
    	return isPalindrome;
    }
     
    public static void main(String[] args){
        System.out.println(isPalindrome(121));
        System.out.println();
        System.out.println(isPalindrome(-121));
        System.out.println();
        System.out.println(isPalindrome(10));
    }
    
}

class StackInt{
	// Class Variables
	private String[] data; // Stack Array 
	private static final int INITIAL_CAPACITY = 10; // Initial Capacity for the Stack Array
	private int size = 0; // Capacity of the Stack Array
	private int count = 0; //Number of elements inside of the Stack Array
	private String intToReturn = null; //Integer to return from Stack Array
	private boolean isEmpty = false; // The boolean value that associates with the Stack being empty or occupied

	// Default Constructor
	public StackInt(){
		data = new String[INITIAL_CAPACITY];
	}
    
	// Custom Constructor
	public StackInt(int initialCapacity){
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


