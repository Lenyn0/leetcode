package lc349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet=new HashSet();
        int[] flag=new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            flag[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (flag[nums2[i]]>0){
                resultSet.add(nums2[i]);
            }
        }
        int[]result=new int[resultSet.size()];
        int count=0;
        for (int a: resultSet) {
            result[count++]=a;
        }
        return result;
    }
}
