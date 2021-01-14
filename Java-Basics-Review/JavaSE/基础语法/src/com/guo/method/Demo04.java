package com.guo.method;

public class Demo04 {
            public static void main(String[] args) {
                Demo04 demo04 = new Demo04();
                demo04.test(1,2,3,4,45,5);
            }
            public static void printMax(double ... numbers){
                if(numbers.length == 0){
                    System.out.println("No argument passed");
                    return;
                }
                double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] > result){
                result = numbers[i];
            }
        }
        System.out.println("The max value is  " + result);
    }

    public void test(int ... i){
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);
        System.out.println(i[3]);
        System.out.println(i[4]);
        System.out.println(i[5]);
    }
}
