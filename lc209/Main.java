package lc209;

public class Main {
    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int target=213;
        System.out.println(minSubArrayLen(target,nums));
        System.out.println(minSubArrayLen_2(target,nums));
        System.out.println(minSubArrayLen_cite(target,nums));
    }


    //me
    //大的测试样例超时
    public static int minSubArrayLen(int target, int[] nums) {
        int result=999999;
        for (int i=0;i< nums.length;i++){
            int sum=0;
            for (int j=i;j< nums.length;j++){
                sum=sum+nums[j];
                if (sum>=target){
                    if (j-i+1<result){
                        result=j-i+1;
                    }
                    break;
                }
            }
        }
        if (result==999999){
            return 0;
        }
        return result;
    }

    public static int updateResult(int result,int t){
        if (t<result){
            return t;
        }
        else {
            return result;
        }
    }

    //me
    //优化后方案
    //1.一个求和数组
    //2.二分查找
    public static int minSubArrayLen_2(int target, int[] nums) {
        int result=999999;
        int[]sum=new int[nums.length+1];
        sum[0]=0;
        for (int i=0;i< nums.length;i++){
            sum[i+1]=sum[i]+nums[i];
        }
        for (int i=0;i<nums.length;i++){
            int left=i;
            int right= nums.length-1;
            while (left<=right){
                int mid=(left+right)/2;
                if (sum[mid+1]-sum[i]>target){
                    result=updateResult(result,mid-i+1);
                    right=mid-1;
                } else if (sum[mid+1]-sum[i]==target) {
                    result=updateResult(result,mid-i+1);
                    break;

                } else{
                    left=mid+1;
                }
            }
        }
        if (result==999999){
            return 0;
        }
        return result;
    }

    //cite
    //前后双指针法，但是不是暴力遍历，同时移动前后双指针，使其一直保持在满足条件的边缘
    public static int minSubArrayLen_cite(int target, int[] nums){
        int right= 0;
        int sum=0;
        int result=9999999;
        for (int i=0;i<nums.length;){
            while (sum<target&&right< nums.length){
                sum=sum+nums[right++];
            }
            if (right== nums.length&&sum<target){
                break;
            }
            result=updateResult(result,right-i);
            sum=sum-nums[i];
            i++;
        }

        if (result==9999999){
            return 0;
        }
        return result;
    }
}
