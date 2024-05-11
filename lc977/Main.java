package lc977;

//力扣链接
//https://leetcode.cn/problems/squares-of-a-sorted-array/
public class Main {
    public static void main(String[] args) {
        int[] nums = {-5,-3,-2,-1};
        int[] temp=sortedSquares(nums);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
        temp=sortedSquares_cite(nums);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }


    //me，双指针法，但是是从中间开始，找最小的，顺插；题解思路从两段开始，找最大的，倒插，更简洁易理解
    public static int[] sortedSquares(int[] nums) {
        int[]result= new int[nums.length];
        int left= 0;
        int right=nums.length-1;
        //寻找两指针初始位置
        for (int i=0;i< nums.length;i++){
            if(nums[i]>=0){
                right=i;
                break;
            }
            else{
                left=i;
            }
        }

        int count=0;

        //处理只有正数或只有负数的情况
        if(left==right){
            if (left==0){
                while (right< nums.length){
                    result[count++]=nums[right]*nums[right];
                    right++;
                }
            }
            else {
                while (left>=0){
                    result[count++]=nums[left]*nums[left];
                    left--;
                }
            }
            return result;
        }
        //处理正数和负数同时存在的情况
        while(left>=0&&right< nums.length){
            if (Math.abs(nums[left])>=Math.abs(nums[right])){
                result[count++]=nums[right]*nums[right];
                right++;
            }
            else{
                result[count++]=nums[left]*nums[left];
                left--;
            }
        }
        if (left>=0){
            while (left>=0){
                result[count++]=nums[left]*nums[left];
                left--;
            }
        }
        if(right< nums.length){
            while (right< nums.length){
                result[count++]=nums[right]*nums[right];
                right++;
            }
        }
        return result;
    }

    //cite
    public static int[] sortedSquares_cite(int[] nums) {
        int[]result=new int[nums.length];
        int count= nums.length-1;
        for(int i=0,j= nums.length-1;i<=j;){
            if (Math.abs(nums[i])<Math.abs(nums[j])){
                result[count--]=nums[j]*nums[j];
                j--;
            }
            else {
                result[count--]=nums[i]*nums[i];
                i++;
            }
        }
        return result;
    }

}
