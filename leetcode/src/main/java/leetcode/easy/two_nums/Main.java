package leetcode.easy.two_nums;

import java.util.LinkedList;

/**
 * 使用的是最简单的思路，就是穷举
 */
public class Main {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3,2,4}, 6);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i]+" ");
    }


    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        LinkedList<Integer> resultList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    resultList.add(i);
                    resultList.add(j);
                }
            }
        }
        int size = resultList.size();
        int[] result = new int[size];
        int index=0;
        for (int i: resultList) {
            result[index++]=i;
        }
        return result;
    }

}
