package com.guo.struct;

import java.util.Scanner;

public class IfDemo02 {
    public static void main(String[] args) {
        //考试分数大于60就是及格，小于60就不及格
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");
        int score = scanner.nextInt();

        if (score>=60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }

        scanner.close();
    }
}
