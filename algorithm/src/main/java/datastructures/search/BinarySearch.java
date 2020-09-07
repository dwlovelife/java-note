package datastructures.search;

/**
 * 二分查找(前提：数组必须是有序的)
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 10, 89, 1000, 1234 };
		int index = binarySearch(arr, 0, arr.length - 1, 1);
		System.out.println(index);
	}

	// 二分查找
	/**
	 * 
	 * @param arr
	 *            要查找的数组
	 * @param left
	 *            左边的索引
	 * @param right
	 *            右边的索引
	 * @param findVal
	 *            要查找的值
	 * @return 如果找到就返回下标,如果没有找到,就返回-1
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		if (left > right) {
			return -1;
		}
		System.out.println("查找次数");
		int mid = (left + right) / 2;
		if (arr[mid] > findVal) {
			return binarySearch(arr, left, mid - 1, findVal);
		} else if (arr[mid] < findVal) {
			return binarySearch(arr, mid + 1, right, findVal);
		} else {
			return mid;
		}

	}

}
