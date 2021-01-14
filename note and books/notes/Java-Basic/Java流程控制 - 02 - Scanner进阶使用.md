# Java流程控制 - 02 - Scanner进阶使用

---

## 一、判断输入数字类型

之前敲到`hasNextInt()`方法时，IDEA就已经弹出了一大堆的方法，其中就有`hasNestFloat()`等

```java
import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //从键盘接收数据
        int i = 0;
        float f = 0.0f;

        System.out.println("请输入整数：");

        //如果...那么...
        if(scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.println("整数数据："+i);
        }else{
            System.out.println("输入的不是整数数据！！");
        }

        System.out.println("请输入小数：");

        //如果...那么...
        if(scanner.hasNextFloat()){
            f = scanner.nextFloat();
            System.out.println("小数数据："+f);
        }else{
            System.out.println("输入的不是小数数据！！");
        }

        scanner.close();
    }
}
```

---

## 二、有关输入的一个小案例

题目：我们可以输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入兵输出执行结果

```java
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //我们可以输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入兵输出执行结果：
        Scanner scanner = new Scanner(System.in);

        //和
        double sum = 0;
        //计算输入了多少个数字
        int m = 0;

        System.out.println("请输入数据：");
        //通过循环判断是否还有输入，并在里面对每一次进行求和统计
        while (scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m = m + 1;//m++   ++m
            sum = sum + x;//sum += x
            System.out.println("你输入了第"+m+"个数据，然后当前结果sum="+sum);
        }
        System.out.println(m + "个数总和为：" + sum);
        System.out.println(m + "个数的平均值为：" +(sum / m));

        scanner.close();
    }
}
```

---