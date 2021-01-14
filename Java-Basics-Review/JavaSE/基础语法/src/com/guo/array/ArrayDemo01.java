package com.guo.array;

public class ArrayDemo01 {
    //变量的类型    变量的名字   =    变量的值;
    public static void main(String[] args) {
        //1. 声明一个数组
        int[] nums;

        //创建一个数组
        nums = new int[10];//这里可以存放10个int类型的数字

        //3. 给数组元素赋值
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 6;
        nums[6] = 7;
        nums[7] = 8;
        nums[8] = 9;
        nums[9] = 10;

        //如果取第十一个元素呢？
        //现在数组的大小为10
        //System.out.println(nums[10]);

        //计算所有元素的和
        int sum = 0;
        //获取数组的长度：  arrays.length
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.println("总和为：" + sum);
    }
}
