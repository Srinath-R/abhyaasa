package sri.misc;

public class KadaneAlgo {
	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		int kadaneSum = kSum(arr);
		System.out.println(kadaneSum);
	}

	private static int kSum(int[] arr) {
		int mi = arr[0];
		//let array's max value be ksum
		int ksum = arr[0];
		for(int i=1;i<arr.length;i++){
			mi = max(arr[i],mi+arr[i]);
			ksum = max(mi,ksum);
		}
		return ksum;
	}

	private static int max(int x,int y) {
		return (x>y) ? x : y;
	}
}
