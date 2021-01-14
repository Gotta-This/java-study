package com.guo.array;

public class ArrayDemo04 {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5};

//        //JDK1.5新特性，增强for循环
//        //缺点：无法取到下标
//        for (int array : arrays) {
//            System.out.println(array);
//        }
        printArray(arrays);
        int[] reverse = reverse(arrays);
        printArray(reverse);
    }

    //打印数组元素
    public static void printArray(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    //反转数组
    public static int[] reverse(int[] arrays) {
        int[] result = new int[arrays.length];

        //反转的操作
        for (int i = 1, j = result.length - 1; i < arrays.length; i++, j--) {
            result[j] = arrays[i];
        }
        return result;
    }
}
