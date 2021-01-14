# Java数组 - 01 - 定义和创建

## 一、什么是数组

数组是最简单的数据结构，数组这个词，就理解为一组数，`int`型可以存放一个数，数组可以存放一组数，`main`方法后面跟的`String args[]`就是定义了一个数组

- 数组是**相同类型**数据的有序集合
- 数组描述的是**相同类型**的若干个数据，按照一定的先后次序排列组合而成
- 其中，每一个数据称作一个**数组元素**，每个数组元素可以通过一个**下标**来访问它们
  - 数组的下标是从0开始的

---

### 二、数组声明创建

***如何用Java创建数组***

- 首先必须声明数组变量，才能在程序中使用数组。下面是声明数组变量的语法：

  ```java
  dataType[] arrayRefVar;				//首选的方法
  int[] nums;										//上一行的一个例子
  或
  dataType arrarRefVar[];				//效果相同，但不是首选方法
  int nums2[];									//上一行的一个例子
  ```

  平时不要使用第二种方式，这种方式是c和c++语言风格的，在Java中采用这个完全是为了让c和++程序员能够快速的掌握Java

- Java语言使用new操作符来创建数组，语法如下：

  ```java
  dataType[] arrayRefVar = new dataType[arraySize];
  例如：
  nums = new int[10];//这里可以存放10个int类型的数字
  ```

- 数组的元素是通过索引访问的，数组索引从0开始

- 如果没有赋值就输出，会输出默认值

- 获取数组长度：

  ```java
  array.length
  ```

---

## 三、学以致用

定义一个容量为10的数组，并通过遍历计算总和

```java
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

        //计算所有元素的和
        int sum = 0;
        //获取数组的长度：  arrays.length
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.println("总和为：" + sum);
    }
}
```

---

