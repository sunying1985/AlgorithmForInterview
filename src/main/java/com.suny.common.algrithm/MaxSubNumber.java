package com.suny.common.algrithm;

/**
 * Created by Frank Adolf
 * Date on 2016/12/8.
 * 求最大子串的和
 */
public class MaxSubNumber {

    public static int MaxSum(int array[],int n)
    {
        int b=0;
        int sum=0;

        for(int i = 0;i < n; i++)
        {
            if(b>0)
            {
                b+=array[i];
            }
            else
            {
                b=array[i];
            }
            if(b>sum)
            {
                sum=b;
                System.out.println(sum);
            }
        }
        return sum;
    }

    public static  void main(String [] args) {

        int [] arrays = {-4,11,-2,13,-7,-3,12};

        System.out.println(MaxSum(arrays,7));
    }
}
