package lc27;

//力扣链接
//https://leetcode.cn/problems/remove-element/
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, val);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }

//me
//    public static int removeElement(int[] nums, int val) {
//        int count=0;
//        for(int i=0;i<nums.length-count;i++){
//            if(nums[i] == val){
//                int temp= nums[i];
//                nums[i] = nums[nums.length-1-count];
//                nums[nums.length-1-count] = temp;
//                count++;
//                i--;
//            }
//        }
//        return nums.length-count;
//    }


    //快慢双指针

    public static int removeElement(int[] nums, int val) {
        int SlowIndex=0;
        for(int FastIndex=0;FastIndex<nums.length;FastIndex++){
            if(nums[FastIndex] != val){
                nums[SlowIndex++] = nums[FastIndex];
            }
        }
        return SlowIndex;
    }
}
