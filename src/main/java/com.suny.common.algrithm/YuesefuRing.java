package com.suny.common.algrithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank Adolf
 * Date on 2016/12/8.
 * 模拟约瑟夫环
 * N  人的总个数
 * M  间隔多少个人
 */
public class YuesefuRing {

    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        int k = 0;
        while (start.size() >0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size()-1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
    public static  int getLastPeople(int N, int M) {
        int result=0;//N=1情况

        for (int i=2; i<=N; i++)
        {
            result=(result+M)%i;
        }
        System.out.println("最后自杀的人是：" + (result+1));//result要加1
        return  result + 1;
    }

    public static  void main(String [] args) {
        int retPeople = getLastPeople(15,4);
        System.out.println(retPeople);
    }
}
