package leetcode;

import java.util.*;

public class Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
        }
        Collections.sort(list,Collections.reverseOrder());

        return list.get(k-1);
    }
}
