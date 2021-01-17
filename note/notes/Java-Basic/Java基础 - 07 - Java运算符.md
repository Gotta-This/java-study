# Java基础 - 07 - Java运算符、初识Math类

计算机之所以叫计算机，最重要的一点就是**计算**
我们在小时候，小学的时候就学过**计算**这个东西
而计算最重要的东西就是**运算符**

---

## 一、运算符

Java语言支持如下运算符：

---

### 算术运算符   `+`   `-`   `*`   `/`   `%`   `++`   `--`

- `+`   `-`   `*`   `/`   和数学公式一样没什么问题
- `%`是取余，小学就学过`5÷2=2...1`得出的值就是最后面的余数`1`
- 取余在Java中叫**模运算**   余数在Java中叫**模**
- `++`   `--`   是基于数本身+1或者-1，但不会存储在变量中，在后面算法中依然成立

```java
// 二元运算符
//Ctrl + D   ：  复制当前行到下一行
int a = 10;
int b = 20;
int c = 25;
int d = 25;

System.out.println(a+b);
System.out.println(a-b);
System.out.println(a*b);
System.out.println(a/b);//0

System.out.println(a/(double)b);//0.5

//取余
System.out.println(c%b);//5
//25 ÷ 20 = 1 ...5
```
- 由于a = 10，b = 20   10/20=0.5
- 但a是int型的，b也是int型，所以只保留整数0
- 所以需要强行转换为double类型的

```java
long a = 123123123123123L;
int b = 123;
short c = 10;
byte d = 8;

System.out.println(a+b+c+d);//变成Long类型的
System.out.println(b+c+d);//变成Int类型的
System.out.println(c+d);//变成Int类型的
```

- 多个数相加，只要有一个数是Long型的，结果就是Long型的
- 只要没一个数是Long型的，结果就是Int型的
- 这个叫  自动升型

```java
//一元运算符
// ++  --  是自增自减
int a = 3;//a的初始值是3
int b = a++;//a++相当于 a = a + 1;
//执行完这行代码后，先给b赋值，再自增
System.out.println(a);//4
//a++执行后才会+1

int c = ++a;
//执行这行代码钱，先给a自增，再给c赋值输出


System.out.println(a);//5
System.out.println(b);//3
System.out.println(c);//5
```

- ++  --  是自增自减
- 执行完a++后，先给b赋值，再自增
- 执行++a前，先给a自增，再给c赋值输出

---

### 赋值运算符   `=`

- ***注意：一个等号在Java中不是等于而是赋值***
- 比如`int a = 10` 读作：把`10`赋值给`a`

---

### 关系运算符   `>`   `<`   `>=`   `<=`   `==`   `!=`   `instanceof`

- `==`在Java中是等于的意思
- `!=`在Java中是不等于的意思
  - `!`在Java中是不的意思，相反的意思
- `instanceof `严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例

```java
int a = 10;
int b = 10;

System.out.println(a>b);//false
System.out.println(a<b);//true
System.out.println(a==b);//false
System.out.println(a!=b);//true
```

- 关系运算符返回的结果为：正确，错误
- 正确，错误就是布尔值表示的
- 关系运算符一般会和if语句一起使用

---

### 逻辑运算符   `&&`   `||`   `!`

- `&&`与   (and)
- `||`或   (or)
- `!`非   取反的意思   就是上面的`!=`不等于

```java
//  逻辑运算符就是与或非
//  与(and)   或(or)    非(not)
boolean a = true;
boolean b = false;

System.out.println("a && b："+(a&&b));//逻辑与运算，两个变量都为真，结果才为真
System.out.println("a || b："+(a||b));//逻辑或运算，两个变量有一个为真，结果都为真
System.out.println("!(a && b)："+(!(a && b)));//如果是真则为假，如果是假则为真
```

#### 短路运算

- 在与运算中，需要两个变量都为真，结果才为真
- 但是如果前面那个变量为假，后面语句就不会进行，直接输出假
- 当`a&&b`时，如果`a = false` ,则a后的式子不会运算

```java
int c = 5;
boolean d = (c<4&&(c++<4));
System.out.println(d);//false
System.out.println(c);//5
//这里c<4为false，c++<4为true
//第二句话把c输出，如果c = 6，那么证明不会短路
//如果c = 5，那么证明会短路
//结果为5，说明当a&&b时，如果a = false ,则a后的式子不会运算
```

---

### 位 运 算 符    `&`   `|`   `^`   `~`   `>>`   `<<`   `>>>`

- 与计算机位运算相关

``` java
/*
A = 0011 1100
B = 0000 1101

A&B 0000 1100
两个二进制数每一位进行比较，如果两个都为1，结果才为1，否则为0

同或运算
A|B 0011 1101
两个二进制数每一位进行比较，如果两个都为0,结果为0，否则为1

异或运算
A^B 0011 0001
两个二进制数每一位进行比较，如果两个相同则为0，不相同则为1

取反运算
~B 1111 0010
把1全部变成0，0全部变成1
*/
```

- `<<`	左移	  等于把数字*2
- `>>`	右移	  等于把数字/2
- ***左移右移操作数字效率极高！！！！！***
  - 常见面试题：`2*8`怎么运算最快
    - 可以拆分为`2*2*2*2`

```java
System.out.println(2<<3);//16
/*
0000 0000      0
0000 0001      1
0000 0010      2
0000 0011      3
0000 1000      8
0001 0000      16

等于说把1一直往左移动
*/
```

---

### 条件运算符   `?`   `:`       (三目运算符)

- 偷懒用的
- x  ?  y  :  z
- 如果x==true，则结果为y，否则结果为z

```java
int score = 80;
String type = score<60 ?"不及格":"及格";
System.out.println(type);
```

***重要！！！可以优化代码！！！***

---

### 扩展赋值运算符   `+=`   `-=`   `*=`   `/=`

- 偷懒用的
- `a+=b`的含义就是`a = a + b`
- `a-=b`的含义就是`a = a - b`
- ...... 

```java
int a = 10;
int b = 20;

a+=b;// a = a + b
a-=b;// a = a - b

System.out.println(a);//10
```

---

## 二、初识Math类
- 幂运算  2^3 = 2*2*2 = 8
- 很多运算，我们会使用一些工具类来操作！
- Math`类提供了很多科学工程计算需要的方法

```java
double pow = Math.pow(2, 3);
//double 名字 = Math.pow(m, n);
//计算m的n次方
System.out.println(pow);
```

---

## 三、字符串连接符 `+`

```java
int a = 10;
int b = 20;

System.out.println(a+b);//30
System.out.println(""+a+b);//1020
```

- ""内是字符串，后面的a和b自动转换成字符串输出，所以是1020

### 面试题

```java
int a = 10;
int b = 20;

System.out.println(""+a+b);
System.out.println(a+b+"");
```

***后面输出的两句有什么区别？***

- 第一个式子`System.out.println(""+a+b);`运行结果为1020
- 第二个式子`System.out.println(a+b+"");`运行结果为30

- ***如果字符串在前面，则a和b都变成字符串拼接输出 ***
- ***如果字符串在后面，则a和b先进行运算，再和字符串拼接输出***

---