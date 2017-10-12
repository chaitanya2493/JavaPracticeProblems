/*
 given the dialer of a feature phone and a dictionary of words, 
 find the string suggestions after dialing n numbers .
 */

import java.util.Hashtable;

public class WordSuggestionsOnDial {
	public static void Words(int number[], int curr_digit, char output[], int n){
		Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>(){
		    {
		    	put(0,"");
		    	put(1,"");
		    	put(2,"abc");
		        put(3,"def");
		        put(4,"ghi");
		    	put(5,"jkl");
		    	put(6,"mno");
		    	put(7,"pqrs");
		        put(8,"tuv");
		        put(9,"wxyz");
		    }
		};
	    int i;
	    if (curr_digit == n)
	    {
	        System.out.println(output);
	        return ;
	    }
	 
	    // Try all 3 possible characters for current digir in number[]
	    // and recur for remaining digits
	    for (i=0; i< ((String)hashTable.get(number[curr_digit])).length(); i++)
	    {
	        output[curr_digit] = ((String) hashTable.get(number[curr_digit])).charAt(i);
	        Words(number, curr_digit+1, output, n);
	        if (number[curr_digit] == 0 || number[curr_digit] == 1)
	            return;
	    }
	}
	public static void suggestWords(int[] arr,int n){
	    char[] result = new char[n+1];
	    result[n] ='\0';
	    Words(arr, 0, result, n);
	}

	public static void main(String args[]) {
		int[] arr = {2,3,4};
		suggestWords(arr, arr.length);
	}
}