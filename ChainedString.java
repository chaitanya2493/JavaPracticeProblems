import java.util.HashMap;
import java.util.Map;

/*
 * given an array of Strings , not necessarily in any order, find out 
 * if the string create a chain, such that first last char of a string 
 * is the first character of another and thus making a chain including 
 * at least all string
*/

public class ChainedString {
	public static void getChain( String[] arr, int n){
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0; i<n;i++){
			for( int j = 0; j<n;j++){
				if((i != j) && arr[i].charAt(arr[i].length()-1) == arr[j].charAt(0)){
					map.put(arr[i],  arr[j]);
				}
			}
		}
		System.out.println(map);
	}
	public static void main(String args[]){
		String[] arr = {"ghi","cde","efg","abc","jkl"};
		getChain(arr, arr.length);
	}
}
