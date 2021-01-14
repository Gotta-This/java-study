# Java基础 - 04 - 数据类型拓展和面试题

---

## 一、整数拓展：进制问题

- 二进制	0b开头
- 八进制	0开头
- 十进制	就是我们平时使用的数
- 十六进制 0x开头

***当然，Java中也可以输出进制数：***

```java
int i = 10;
int i2 = 010;   //八进制0
int i3 = 0x10;  //十六进制0x

System.out.println(i);
System.out.println(i2);
System.out.println(i3);
```

---

## 二、浮点数拓展：银行业务怎么表示？这么多钱

先提出答案：Java中有一个数学工具类`BigDecimal`可以表示
但为什么不用浮点数表示呢？而且切记：

- ***最好完全避免使用浮点数进行比较***
- ***最好完全避免使用浮点数进行比较***
***最好完全避免使用浮点数进行比较***

先看例子：

```java
float f = 0.1f;     //0.1
double d = 1.0/10;  //0.1

System.out.println(f==d);//false
System.out.println(f);
System.out.println(d);

float d1 = 15665165165161f;
float d2 = d1 + 1;

System.out.println(d1==d2);//true
```

上面例子中，`float f`和`double d`输出都是0.1但是比较他们大小的时候返回的为`false`
当定义`float d2 = d1 + 1;`时，比较`d1`与`d2`的大小时却为`true`

从上面总结出浮点数可以用这几个词来描述：***有限、离散、舍入误差、大约、接近但不等于***
所以不能用这种数据类型来表示银行的钱

---

## 三、字符拓展

字符可以是中文字符，也可以是英文字符

```java
char c1 = 'a';
char c2 = '中';
```

我们可以把这两个字符输出，也可以把这两个类型强制转换成int型(***类型强制转换在要转换的标识符前加()里面写要转换成什么类型***)

```java
System.out.println(c1);
System.out.println(c2);

System.out.println((int)c1);//97
System.out.println((int)c2);//20013
```

`c1`本来结果为`a`，`c2`本来是中文`中`，但转成`int`类型后，`c1`变成了`97`，`c2`变成了`20013`，这里得出结论：
															***所有的字符在本质上还是数字***

---

## 四、其他拓展

###  char 数据类型涉及到了一个知识点：编码

#### 编码：Unicode
- 编码可以处理各种语言文字	它有一张编码表：
- 这个表中的**97**对应的就是**a**，**65**对应的就是**A**
- 编码值占两个字节，最多可以表示0 ~ 65536
- 在Excel表中，行数最多只有2的16次方，而2的16次方就等于65536
- Unicode编码的表示方式是U0000 UFFFF，范围就是U0000-UFFFF

在Java中，前面加上一个`\`就能转义，`\u`代表给后面这个数字转义

```java
char c3 = '\u0061';
System.out.println(c3);//a
```

---

#### 转义字符

| 转义字符 | 意义                                | ASCII码值（十进制） |
| -------- | ----------------------------------- | ------------------- |
| \a       | 响铃(BEL)                           | 007                 |
| \b       | 退格(BS) ，将当前位置移到前一列     | 008                 |
| \f       | 换页(FF)，将当前位置移到下页开头    | 012                 |
| \n       | 换行(LF) ，将当前位置移到下一行开头 | 010                 |
| \r       | 回车(CR) ，将当前位置移到本行开头   | 013                 |
| \t       | 水平制表(HT) （跳到下一个TAB位置）  | 009                 |
| \v       | 垂直制表(VT)                        | 011                 |
| \\       | 代表一个反斜线字符''\'              | 092                 |
| \'       | 代表一个单引号（撇号）字符          | 039                 |
| \"       | 代表一个双引号字符                  | 034                 |
| \?       | 代表一个问号                        | 063                 |
| \0       | 空字符(NUL)                         | 000                 |
| \ddd     | 1到3位八进制数所代表的任意字符      | 三位八进制          |
| \xhh     | 十六进制所代表的任意字符            | 十六进制            |

*注意：*
*1. 区分，斜杠："/" 与 反斜杠："\" ,此处不可互换*
*2. \xhh 十六进制转义不限制字符个数 '\x000000000000F' == '\xF'*

---

#### 好玩的操作——以后会学习的

```java
String sa = new String("Hello world");
String sb = new String("Hello world");
System.out.println(sa == sb);//false

String sc = "Hello world";
String sd = "Hello world";
System.out.println(sc == sd);//true

private static class Sring {
  public Sring(String hello_world) {
  }
}
```

当String作为一个对象被new时，相同的一串字符串却不相等
当String作为一个变量被定义时，相同的一串字符串会是相等的

---

#### 布尔值拓展

```java
boolean flag = true;
if(flag==true){ }//如果flag为true则运行大括号中的代码
if(flag){ }//和上面一样
```

以后会学到一个知识点——条件
第二句表示如果flag为true则运行大括号中的代码
第三句和第二句含义相似

而新手会像第二行一样写代码，而老手会写第三行的
Java中有这样一个概念：***Less Is More! —— 代码要精简易读***