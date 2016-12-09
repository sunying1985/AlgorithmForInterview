package com.suny.common.algrithm;


/**
 * Created by Frank Adolf
 * Date on 2016/12/8.
 * 最长公共子字符串：类似最长子序列，只是公共子字符串要求必须是连续的。
 */

public final class CommituyMaxSub
{
    static private int seqStart = 0;
    static private int seqEnd = -1;

    /**
     * 连续的最大字串和简单方法
     */
    public static int maxSubSum1(int [] a)
    {
        int maxSum = 0;

        for( int i = 0; i < a.length; i++ ) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;

                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                    seqStart = i;
                    seqEnd = j;
                    System.out.println("start" + "\t"  + seqStart + "\t" + "end" + "\t" + seqEnd + "\t" + "maxSum\t" + maxSum);
                }
            }

        }
        return maxSum;
    }

    /**
     * 扩展方法
     */
    public static int maxSubSum2(int [] a)
    {
        int maxSum = 0;

        for( int i = 0; i < a.length; i++ )
        {
            int thisSum = 0;
            for( int j = i; j < a.length; j++ )
            {
                thisSum += a[ j ];

                if( thisSum > maxSum )
                {
                    maxSum = thisSum;
                    seqStart = i;
                    seqEnd   = j;
                }
            }
        }

        return maxSum;
    }

    /**
     *更好的方法
     */
    public static int maxSubSum3(int [] a)
    {
        int maxSum = 0;
        int thisSum = 0;

        for( int i = 0, j = 0; j < a.length; j++ )
        {
            thisSum += a[ j ];

            if( thisSum > maxSum )
            {
                maxSum = thisSum;
                seqStart = i;
                seqEnd   = j;
            }
            else if( thisSum < 0 )
            {
                i = j + 1;
                thisSum = 0;
            }
        }

        return maxSum;
    }

    /**
     * *ustczyy
     *zyyjiao@mail.ustc.edu.cn
     */
    private static int maxSumRec(int [] a, int left, int right)
    {
        int maxLeftBorderSum = 0, maxRightBorderSum = 0;
        int leftBorderSum = 0, rightBorderSum = 0;
        int center = ( left + right ) / 2;

        if( left == right )  // Base case
            return a[ left ] > 0 ? a[ left ] : 0;

        int maxLeftSum  = maxSumRec( a, left, center );
        int maxRightSum = maxSumRec( a, center + 1, right );

        for( int i = center; i >= left; i-- )
        {
            leftBorderSum += a[ i ];
            if( leftBorderSum > maxLeftBorderSum )
                maxLeftBorderSum = leftBorderSum;
        }

        for( int i = center + 1; i <= right; i++ )
        {
            rightBorderSum += a[ i ];
            if( rightBorderSum > maxRightBorderSum )
                maxRightBorderSum = rightBorderSum;
        }

        return max3( maxLeftSum, maxRightSum,
                maxLeftBorderSum + maxRightBorderSum );
    }

    /**
     * Return maximum of three integers.
     */
    private static int max3(int a, int b, int c)
    {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }

    /**
     * ustczyy
     *zyyjiao@mail.ustc.edu.cn
     */
    public static int maxSubSum4(int [] a)
    {
        return a.length > 0 ? maxSumRec( a, 0, a.length - 1 ) : 0;
    }

    /**
     * Simple test program.
     */
    public static void main( String [ ] args )
    {
        int a[ ] = { 4, -3, 5, -2, -1, -5, 6, -2 };
        int maxSum;
        /*
        maxSum = maxSubSum1( a );
        System.out.println( "Max sum is " + maxSum + "; it goes"
                + " from " + seqStart + " to " + seqEnd )*/
        /*maxSum = maxSubSum2( a );
        System.out.println( "Max sum is " + maxSum + "; it goes"
                + " from " + seqStart + " to " + seqEnd );
        */
        maxSum = maxSubSum3( a );
        System.out.println( "Max sum is " + maxSum + "; it goes"
                + " from " + seqStart + " to " + seqEnd );
        /*maxSum = maxSubSum4( a );
        System.out.println( "Max sum is " + maxSum );
        */


    }
}



