# Java流程控制 - 05 - 循环结构

选择结构始终无法让程序一直跑，运行一遍程序就停止了，在真实环境中，一个选择结构是不够用的，比如访问一个网站，这个网站是全程24小时在跑，需要规定一个程序运行多少次，运行多久，编程是为了处理人的思维，我们需要一个结构去让程序循环运行，循环结构诞生了

顺序结构的程序只能被执行一次，循环结构哦能让程序循环多次运行

---

## 一、三大循环结构

- `while`循环
- `do...while`循环
- ***`for`循环***(十分重要)

- 在Java5中引入了一种主要用于数组和对象的增强型`for`循环

---

## 二、`while`循环结构

`while`是最基本的循环，它的结构为：

```java
while(布尔表达式){
  //循环内容
}
```

- 只要布尔表达式为 true ,循环就会一直执行下去。

- ***我们大多数情况是会让循环停止下来的,我们需要一个让表达式失效的方式来结束循环***。

- 少部分情况需要循环一直执行,比如服务器的请求响应监听等。

- 循环条件一直为 true 就会造成无限循环【死循环】,我们正常的业务编程中应该尽量避免死循

  环。会影响程序性能或者造成程序卡死奔溃!

- 思考:计算1+2+3+…+100=?

### 输出1-100

```java
public class WhileDemo01 {
    public static void main(String[] args) {
        //输出1-100
        int i = 0;
        while (i<=100){
            System.out.println(i);
            i++;
        }
    }
}
```

### 死循环

```java
public class WhileDemo02 {
    public static void main(String[] args) {
        //死循环
        while (true){//条件为true时，循环会持续进行
            //正常写代码时尽量避免，但有时候会用到
            //比如用在等待客户端连接
            //定时检查
            //。。。。
        }
    }
}
```

### 计算1+2+3+…+100=?

```java
public class WhileDemo03 {
    public static void main(String[] args) {
        //计算1+2+3+...+100=？
        int sum = 0;
        int i = 0;
        while (i<=100){
            sum = sum + i;//sum += i
            i++;
        }
        System.out.println(sum);
    }
}
```

---

## 三、`do...while`循环

- 对于 `while`语句而言,如果不满足条件,则不能进入循环。但有时候我们需要即使不满足条件,也至少执行一次
- `do...while`循环和 `whille`循环相似,不同的是,`do…while`循环至少会执行一次。
- 我对`do...while`的理解就是，它先`do`了一次，然后再`while`

### 结构

```java
do{
  //代码语句
}while(布尔表达式);
```


### 计算1+2+3+…+100=?

```java
public class DoWhileDemo01 {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        do{
            sum = sum + i;//sum +=i
            i++;
        }while (i<=100);
        System.out.println(sum);
    }
}
```

---

### `while`和 `do-While`的区别:

- `while`先判断后执行。 `do...while`是先执行后判断!

- `do...while`总是保证循环体会被至少执行一次!这是他们的主要差别。

### 利用代码区别

```java
public class DoWhileDemo02 {
    public static void main(String[] args) {
        int a = 0;
        while (a<0){
            System.out.println(a);
            a++;
        }
        System.out.println("=========================");
        do{
            System.out.println(a);
            a++;
        }while (a<0);
    }
}
```
案例中，上面的while不会输出，但是下面的do...while却会输出

---

## 四、`for`循环********

- 虽然所有循环结构都可以用` while`或者`do...while`表示,但Java提供了另一种语句——`for`循环,使一些循环结构变得更加简单。
- `for`循环语句是支持迭代的一种通用结构,***是最有效、最灵活的循环结构***。
- `for`循环执行的次数是在执行前就确定的。语法格式如下:

```java
for(初始化;布尔表达式;更新){
  //代码语句
}
```

### `for`与`while`对比

```java
public class ForDemo01 {
    public static void main(String[] args) {
        int a = 1;//初始化条件
        while (a<100){//条件判断
            System.out.println(a);//循环体
            a += 2;//迭代  a = a + 2;
        }
        System.out.println("while循环结束！");
        //初始化//条件判断//迭代
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        System.out.println("for循环结束！");
        //快速生成 ： 100.for  回车
        for (int i = 0; i < 100; i++) {
        }
    }
}

```

### IDEA中快速生成：

在main方法中输入`100.for`按回车就会快速生成以下：

```java
for (int i = 0; i < 100; i++) {

}
```

### 关于  `for`  循环有以下几点说明


- 最先执行初始化步骤。可以声明一种类型,但可初始化一个或多个循环控制变星,也可以是空语句。
- 然后,检测布尔表达式的值。如果为true,循环体被执行。如果对aLse,循环终止,开始执行循环体后面的语句
- 执行一次新环后,更新循环控制变量(送代因子控制循环变量的增减)
- 再次检测布尔表达式。循环执行上面的过程。

### 练习

- 练习1：计算0到100之间的奇数和偶数的和

```java
public class ForDemo02 {
    public static void main(String[] args) {
        //练习1：计算0到100之间的奇数和偶数的和
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i <= 100; i++) {
            if(1%2!=0){
                oddSum+=i;
            }else {
                evenSum+=i;
            }
        }
        System.out.println("奇数的和："+oddSum);
        System.out.println("偶数的和："+evenSum);

    }
}
```

- 练习2：用while或for循环输出1-1000之间能被5整除的数，并且每行输出3个

```java
public class ForDemo03 {
    public static void main(String[] args) {
        //练习2：用while或for循环输出1-1000之间能被5整除的数，并且每行输出3个
        for (int i = 0; i <= 1000; i++) {
            if(i%5==0){
                System.out.print(i+"\t");
            }
            if(i%(5*3)==0){
                System.out.println();
                //System.out.print("\n");
            }
        }
        //println 输出完会换行
        //print  输出完不会换行
    }
}
```

- 练习3：打印九九乘法表

  1. 先打印第一列

  2. 把固定的1再用一个循环包起来

  3. 去掉重复项，i<=j

  4. 调整样式

```java
/*
1*1=1
2*1=2	2*2=4
3*1=3	3*2=6	3*3=9
4*1=4	4*2=8	4*3=12	4*4=16
5*1=5	5*2=10	5*3=15	5*4=20	5*5=25
6*1=6	6*2=12	6*3=18	6*4=24	6*5=30	6*6=36
7*1=7	7*2=14	7*3=21	7*4=28	7*5=35	7*6=42	7*7=49
8*1=8	8*2=16	8*3=24	8*4=32	8*5=40	8*6=48	8*7=56	8*8=64
9*1=9	9*2=18	9*3=27	9*4=36	9*5=45	9*6=54	9*7=63	9*8=72	9*9=81	
 */
public class ForDemo04 {
    public static void main(String[] args) {
        //练习3：打印九九乘法表
        /*
        1. 先打印第一列
        2. 把固定的1再用一个循环包起来
        3. 去掉重复项，i<=j
        4. 调整样式
         */
        for (int j = 1; j <= 9; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(j+"*"+i+"="+(j*i)+"\t");
            }
            System.out.println();
        }
    }
}
```

---

## 五、增强`for`循环

- 这里先只是见一面,做个了解,之后数组重点使用
- Java5引入了一种主要用于数组或集合的增强型`for`循环
- Java增强`for`循环语法格式如下:

```java
for(声明语句 : 表达式){
  //代码句子
}
```

- 声明语句:声明新的局部变量,该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块,其值与此时数组元素的值相等。
- 表达式:表达式是要访问的数组名,或者是返回值为数组的方法。

### 遍历数组的元素

```java
public class ForDemo05 {
    public static void main(String[] args) {
        int [] numbers = {10,20,30,40,50};//定义了一个数组
        for (int i = 0; i < 5; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("=====================");
        //遍历数组的元素
        for(int x:numbers){
            System.out.println(x);
        }
    }
}
```

---