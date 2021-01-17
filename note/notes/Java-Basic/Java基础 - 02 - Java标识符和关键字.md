# Java基础 - 02 - Java标识符和关键字

## 一、标识符
---
***java中标识符是为方法、变量或其他用户定义项所定义的名称。***标识符可以有一个或多个字符。在Java语言中，标识符的构成规则如下

- 标识符由数字(0 ~ 9)和字母(a~z和A~Z)、美元符号($)、下划线(__)以及Unicode字符集中符号大于0xC0的所有符号组合构成(各符号之间没有空格)
- **标识符的第一个符号为字母、下划线和美元符号，后面可以是任何字母、数字、美元符号或下划线**
- **Java区分大小写**，因此myvar和MyVar是两个不同的标识符
- **不能使用数字开头**
- **不能使用任何Java关键字作为标识符**，标识符可以包含关键字，但不能与关键字重名
- **不能赋予标识符任何标准的方法名**
---
标识符分为两类，分别为关键字和用户自定义标识符。
1. 关键字是有特殊含义的标识符，如 true、false 表示逻辑的真假。
2. 用户自定义标识符是由用户按标识符构成规则生成的非保留字的标识符，如 abc 就是一个标识符。

---

例如以下合法与不合法标识符。

- 合法标识符：date、$2011、_date、D_$date 等。
- 不合法的标识符：123.com、2com、for、if 等。

---

***标识符用来命名常量、变量、类和类的对象等。因此，一个良好的编程习惯要求命名标识符时，应赋予它一个有意义或有用途的名字***

《阿里巴巴Java开发手册》有对标识符命名规则的规定，虽然是阿里巴巴公司编写的，但对于我们有很重要的学习作用，百度云链接：[提取码: xcbc](https://pan.baidu.com/s/1BtOw_TtwW1tHF7DFdfuMfA)

---

## 二、 关键字

---

***关键字（或者保留字）是对编译器有特殊意义的固定单词，不能在程序中做其他目的使用。关键字具有专门的意义和用途，和自定义的标识符不同，不能当作一般的标识符来使用***

Java 的关键字对 Java 编译器有特殊的意义，它们用来表示一种数据类型，或者表示程序的结构等。保留字是为 Java 预留的关键字，它们虽然现在没有作为关键字，但在以后的升级版本中有可能作为关键字

---

Java 语言目前定义了 51 个关键字，这些关键字不能作为变量名、类名和方法名来使用。以下对这些关键字进行了分类。
1. 数据类型：boolean、int、long、short、byte、float、double、char、class、interface
2. 流程控制：if、else、do、while、for、switch、case、default、break、continue、return、try、catch、finally
3. 修饰符：public、protected、private、final、void、static、strict、abstract、transient、synchronized、volatile、native
4. 动作：package、import、throw、throws、extends、implements、this、supper、instanceof、new
5. 保留字：true、false、null、goto、const

***提示：由于 Java 区分大小写，因此 public 是关键字，而 Public 则不是关键字。但是为了程序的清晰及可读性，要尽量避免使用关键字的其他形式来命名****

---

