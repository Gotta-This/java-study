# mac终端命令行

---

1. ***此博客用来记录本人日常用的一些Shell命令行，不一定常用，不一定全面***

2. mac终端内类型不一定相同，本人的是**zsh**，参考：

   > https://blog.csdn.net/qq_21210473/article/details/48162887

---

## 一、一些基本和常用的命令

```shell
cd + 路径																					#进入到某路径中
```



## 二、探究Hackintool时

```shell
sudo spctl --master-disable												#显示允许任何来源 – 解决身份不明的开发者程序安装
sudo mount -uw /&& killall Finder									#Extensions可写
sudo -v																						#延长密码5分钟(保持不用输入密码的状态)
```

## 三、WIndows和mac双系统混用时出现的问题(NTFS挂载问题)

---

***一般挂载NTFS分区我会使用Mounty工具，这里附上官网***

> https://mounty.app/

***

有时会出现问题：`您正在移动的项目被另一个应用程序使用`，这时需要查看一下文件的权限：

```shell
ls -l + 文件名/目录															 	#查看某个文件权限的命令
ls -l + 文件夹名															 	 	#查看某个文件夹里所有文件/文件夹的权限
ls -l																				 		#如果要查看某个文件夹的权限，需要在该文件夹外部目录下执行
```

### 2020 - 06 - 11   解决办法 - 打开终端输入

```shell
xattr -d com.apple.FinderInfo 
```

- 注意空格
- 后加空格，然后把要恢复的文件拖进去

---

## 四、学习和研究Github

****

### git版本

```shell
git --version
```

---

### 清理rss

ssh就是用户名下有个`.shh`文件，终端下

```shell
cd ~/.ssh
```

若出现

```shell
-bash: cd: /Users/glamor/.ssh: No such file or directory
```

表示之前没有创建过ssh，直接进行下一步，否则需要**清理rss**
**清理rss：**

```shell
mkdir key_backup $ cp id_rsa* key_backup $ rm id_rsa*
```

---

### 生成shh

```shell
ssh-keygen -t rsa -C 1134018246@qq.com
```

出现Overwrite是因为之前生成过ssh，所以，会提示是否覆盖，如果是第一次使用，则不会出现。

确认完毕后，程序将生成一对密钥存放在以下文件夹：/users/用户/.ssh/

密钥分成两个文件，一个私钥（id_rsa）、一个公钥（id_rsa.pub）。

私钥保存在您的电脑上，公钥交项目负责人添加到服务器上。用户必须拥有与服务器公钥所配对的私钥，才能访问服务器上的代码库。

**注意**：***为了项目代码的安全，请妥善保管你的私钥！因为一旦私钥外泄，将可能导致服务器上的代码被泄漏！***

---

### 创建git库

```shell
git  init
```

给本地项目创建git仓库，执行该命令后，会在本地生成.git文件夹，用于本地项目代码版本管理，切记轻易不要改动，否则可能代码版本会混乱

---

### ‘将本地项目的文件添加到git，让git进行管理，执行

```shell
git add *
```

- 要进入项目文件夹中，此文件夹中有.github隐藏文件夹
- 无任何显示表示成功

---

### 提交到本地git仓库

```shell
git commit -m '注释内容'
```

---

### 将本地项目关联到gitee上

```shell
git remote add origin  https://gitee.com/darendu/demo.git
```

如果出现错误：fatal:remote origin already exists 意思是路径存在了，就需要删除原来的路径从新添加

```shell
git remote rm origin
git remote add origin  https://gitee.com/darendu/demo.git
```

---

### 将本地仓库代码push到远程仓库

```shell
 git push origin master
```

如果出现错误：`failed to push some refs to git `，则需要先将远程仓库的中的README.md文件pull到本地

```shell
git pull --rebase origin master  ,然后再执行  git push  origin master
```

最后等待上传成功即可使用远程仓库工程代码了

---

## 五、部署项目时

使用ssh登录远程服务器

### 使用密码登录

```shell
ssh <username>@<hostname or IP address>
```

### 使用秘钥登录

#### 执行以下命令，赋予私钥文件仅本人可读权限
说明：
如果您的本地电脑为 Mac OS 系统，需先打开系统自带的终端（Terminal），再执行以下命令。
如果您的本地电脑为 Linux 系统，可直接执行以下命令。
如果您的本地电脑为 Windows 10 或 Windows Server 2019 系统，需先打开命令提示符（CMD），再执行以下命令。

```shell
chmod 400 <下载的与云服务器关联的私钥的绝对路径>
```

#### 执行以下命令，进行远程登录

```shell
ssh -i <下载的与云服务器关联的私钥的绝对路径> <username>@<hostname or IP address>
```

- `username` 即为前提条件中获得的默认帐号。
- `hostname or IP address` 为您的 Linux 实例公网 IP 或自定义域名。

例如，执行 `ssh -i "Mac/Downloads/shawn_qcloud_stable" ubuntu@192.168.11.123` 命令，远程登录 Linux 云服务器。

---