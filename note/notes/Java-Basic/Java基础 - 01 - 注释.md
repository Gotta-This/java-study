# Java基础 - 01 - 注释

- 平时我们编写代码，在代码比较少的时候，我们还是可以看懂我们自己写的代码，但是当项目结构一旦复杂起来，我们就需要用到注释了。
- 注释并不会被执行，是给我们写代码的人看的
- ***书写注释是一个非常好的习惯***
- ***平时写代码一定要注意规范，一个好的公司都有一个好的编码习惯***

## Java中的三种注释

### 一、单行注释

由两个斜杠`//`来表示
IDEA中快捷键：

- Windows下：`Ctrl + /`
- Mac OS下：`Command + /`

```java
//这里是注释内容
//单行注释
```

### 二、多行注释

由两个斜杠和两个星号组成`/* */`，中间写注释内容，由`/*`开头，`*/`结尾
IDEA中快捷键：

- Windows下：`Ctrl + Shift + /`
- Mac OS下：`Command + Shift + /`

```java
/*
这里写注释内容
多行注释
可以注释一段文字
*/
```

### 三、文档注释(用于JavaDoc)

由两个斜杠和三个星号组成`/** */`，和多行注释比较像，但它是``/**``开头，`*/`结尾

***可以在里面写注解****

```java

/**
@Description HelloWorld
@Author 某某某
*/
```

