package com.example.xqq407.activity;

import java.util.Scanner;

public class Mp {
    public static void mp(){
        Scanner input = new Scanner(System.in);
        int sort[] = new int[10];
        int temp;
        System.out.println("请输入10个排序的数据：");
        for (int i = 0; i < sort.length; i++) {
            sort[i]=input.nextInt();
        }

        for (int i = 0; i < sort.length-1; i++) {
            for (int j = 0; j < sort.length-i-1; j++) {
                if (sort[j]<sort[j+1]){
                    temp=sort[i];
                    sort[j]=sort[j+1];
                    sort[j+1]=temp;
                }
            }
        }
        System.out.println("排序后的顺序为：");
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i]+"");
        }
    }
    /*public static void main(String[] args){
        sort();
    }*/
}
