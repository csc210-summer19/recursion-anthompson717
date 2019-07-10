/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Alexander Thompson
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
    if(n==k)
    	return 1;
    else if (k==1)
    	return n;
    else
    	return combinations(n-1,k-1)+combinations(n-1,k);
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
	if (n/100 < 10)
		return Integer.toString(n);
	String retnum = Integer.toString(n%1000);
	if (n % 1000 < 10) 
		retnum = "0" + retnum;
	if (n % 1000 < 100) 
		retnum = "0" + retnum;
    return intWithCommas(n/1000) + "," + retnum;
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
    if (index==(x.length-1)/2) {
    	if (x.length%2 == 0) {
    		int swap = x[index];
        	x[index] = x[len-1];
        	x[len-1] = swap;
    	}
    	return;
    }
    else {
    	int swap = x[index];
    	x[index] = x[len-1];
    	x[len-1] = swap;
    	reverseArray(x, index+1, len-1);
    }
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
	
    return maxHelper(a, 0) - minHelper(a, 0);
  }

  private int minHelper(int[] a, int i) {
	if (i == a.length)
			return Integer.MAX_VALUE;
	else
		return Math.min(a[i], minHelper(a,i+1));
}


private int maxHelper(int[] a, int pos) {
	if (pos == a.length)
		return Integer.MIN_VALUE;
	else
		return Math.max(a[pos], maxHelper(a,pos+1));
}


// Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
	if (nums.length == 0)
		return true;
    // Need to send down 0 to keep track of the index
    return isSorted(nums, 0);
  }

  private boolean isSorted(int[] nums, int i) {
	if (i == nums.length-1)
		return true;
	else if (nums[i] > nums[i+1])
		return false;
	else
		return isSorted(nums, i+1);
}


// Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
     
	 return found(search, strs, 0);
  }


private boolean found(String search, String[] strs, int i) {
	if (i == strs.length)
		return false;
	else if (search.equals(strs[i]))
		return true;
	else
		return found(search, strs, i+1);
}
}
