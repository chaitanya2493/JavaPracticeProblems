
class DetectIndexArrayElement{
	static int findIndex(int[] arr,int low,int high){
		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] == 1 && (mid == 0 || arr[mid-1]== 0)){
				return mid;
			}else if(arr[mid-1] == 0){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return -1;
	}
	public static void main(String args[]){
		int[] arr = {0,0,0,0,0,1,1};
		System.out.println(findIndex(arr,0,arr.length-1));
	}
}