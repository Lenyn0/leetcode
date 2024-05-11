package lc704;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2,5};
        int target = 5;
        System.out.println(search(nums, target));
    }


    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(right+left)/2;
        while(left<=right){
            if(nums[mid]>target){
                right=mid-1;
                mid=(right+left)/2;
            }
            else if(nums[mid]<target){
                left=mid+1;
                mid=(right+left)/2;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
