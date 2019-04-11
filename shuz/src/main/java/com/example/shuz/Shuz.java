package com.example.shuz;

import java.util.Scanner;

public class Shuz {
    public static void main (String arg[]) {
        int i;
        int j;
        int temp;
        int a[]= {25,15,14,78,-7,26,-3,45,9,11};
        for(i=0;i<a.length-1;i++)
        {
            for(j=0;j<a.length-1-i;j++) {
                if(a[j]>a[j+1]) {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        System.out.println("由小到大排序的结果是：");
        for(i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
