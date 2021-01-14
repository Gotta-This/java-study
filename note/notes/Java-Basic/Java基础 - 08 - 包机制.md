# Java基础 - 08 - 包机制

***为了更好地组织类，Java提供了包机制，用于区别类名的命名空间***

在操作系统(Win10)上，新建一个文件夹，在文件夹里新建一个文件叫A，再新建一个文件叫A，就会提示*此位置已经包含同名文件*。这个时候要么重新换个名字，要么就再新建一个文件夹，把相同名字的文件放进去。这就是包的作用。

***包的本质就是一个文件夹***

### 包语句的语法格式为

```java
package pkg1[. pkg2[. pkg3...]];
```

### 规范

- ***一般利用公司域名倒置作为包名***

  - www.baidu.com  ->  com.baidu.www

    ​								 com.baidu.baike

- 为了能够使用某一个包的成员，我们需要在Java程序中明确导入该包。使用`import`语句可完成此功能

  - `package`必定在最上面 import在下面

```java
import package1[.package2...].(classname|*);
```

### 必看一本书：阿里Java开发手册

[提取码: imrc](https://pan.baidu.com/s/1eIRnl-Frgw_Hduu78IT-5A )