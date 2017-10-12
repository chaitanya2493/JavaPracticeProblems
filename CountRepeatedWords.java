class CountRepeatedWords{
	static int countWords(String[] arr){
		int i, j, count=0;
		for(i=0; i<arr.length;i++){
			for(j=i+1;j<arr.length;j++){
				if( arr[i] == arr[j]){
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String args[]){
		String[] arr={"Om", "Om1", "Shankar", "Tripathi", "Tom", "Jerry", "Jerry1"};
		System.out.println(countWords(arr));
	}
}