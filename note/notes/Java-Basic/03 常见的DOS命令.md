# 常见的DOS和运行命令

### 打开CMD的方式

1. Windows菜单 - Windows系统 - 命令提示符
2. Win + R(运行) 输入**cmd**打开控制台
3. 在任意的文件夹下面按住**Shift键 + 鼠标右键点击**，选择**在此处打开Power Shell**(Power Shell即为命令行窗口)
4. 资源管理器的地址栏输入**cmd** 回车即可进入 若是输入**cmd + 空格 + 地址** 则是进入这个路径下的cmd窗口
5. 单点**Win键**进入**Windows菜单** 直接输**cmd** 会直接进行搜索 搜索结果即为cmd(***常用的以及我推荐的方法***)

***其中，第234种方式无法以管理员的方式打开，所以本人觉得第五种方式比较好***

## DOS命令大全

***

常用的内部命令有

- md (Make Directory)
- cd (Change Directory)
- rd (Remove Directory)
- dir (Directory)
- path
- cp (Copy)
- type
- edit
- ren
- del (Delete)
- cls (Clean Screen)
- ver (Version)
- date
- time
- prompt

常用的外部命令有

- deltree(Delete Tree)
- format
- diskcopy
- label
- vol
- sys
- xcopy
- fc
- attrib
- mem
- tree

---

### 目录有关

```bash
cd ..														#回到上一目录
cd /													  #返回到根目录
cd /d f: 												#参数说明	/d -> 跨盘符切换
cd tmp 													#cd + 目录名字 表示进入下一级(同级下)
cd>a.txt 												#在此目录下创建文件 cd>文件名
mkdir test											#mkdir 目录名 建立目录(make directory)
rmdir test											#rmdir 删除子目录，目录内没有文档。
rm -a a,txt										  #rm -a 目录名删除目录及子目录
D:															#盘符切换 盘符号后加:	(注意为英文的冒号)
pwd															#查询当前所在的目录位置
dir															#显示当前目录文件,ls -al 显示包括隐藏文件（同win2k的 dir）
dir ls -al
chmod														#设定档案或目录的存取权限
```

### 文件有关

```bash
cat a.txt												#cat 文件名 查看文件内容
cat >a.txt											#往a.txt文件上写入内容
more a.txt											#more 文件名 以一页一页的方式显示一个文本文件
cp a.txt												#cp 文件名 复制文件 (Copy)
mv a.txt												#mv文件名 移动文件 (Move)
rm a,txt												#rm 文件名 删除文件
grep 														#在档案中查找字符串
diff 														#档案文件比较
find 														#档案搜寻
```

### 功能有关

```bash
cls															#清理屏幕	(clear screen)
exit														#退出终端
ipconfig												#查看电脑的ip
ping www.xxx.com								#查看www.xxx.com的ip
date 														#现在的日期、时间
```

### 用户有关

```bash
w 															#查询目前上机者的详细资料
whoami 													#查看自己的帐号名称
groups 													#查看某人的group
passwd 													#更改密码
history 												#查看自己下过的命令
ps 															#显示进程状态
kill 														#停止某进程
gcc 														#黑客通常用它来编译c语言写的文件
su 															#权限转换为指定使用者
telnet ip telnet								#连接对方主机（同win2k），当出现bash$时就说明连接成功。
ftp 														#ftp连接上某服务器（同win2k）
```

### 打开应用

```bash
calc														#打开计算器	(calculator)
mspaint													#打开画图工具	(mspaint)
notepad													#新建记事本	(notepad)
```

### 网络命令有关

```bash
compmgmt.msc										#计算机管理
net stop messenger 							#停止信使服务
conf 														#启动netmeeting
dvdplay 												#dvd播放器
charmap 												#启动字符映射表
diskmgmt.msc 										#磁盘管理实用程序
calc 														#启动计算器
dfrg.msc 												#磁盘碎片整理程序
chkdsk.exe 											#chkdsk磁盘检查
devmgmt.msc 										#设备管理器
regsvr32 /u *.dll 							#停止dll文件运行
drwtsn32 												#系统医生
dxdiag 													#检查directx信息
regedt32 												#注册表编辑器
msconfig.exe 										#系统配置实用程序
rsop.msc 												#组策略结果集
mem.exe 												#显示内存使用情况
regedit.exe 										#注册表
winchat 												#xp自带局域网聊天
progman 												#程序管理器
winmsd 													#系统信息
perfmon.msc 										#计算机性能监测程序
winver 													#检查windows版本
sfc /scannow 										#扫描错误并复原
gpedit.msc 											#组策略
sndrec32 												#录音机
nslookup 												#ip地址侦测器
explorer 												#打开资源管理器
logoff 													#注销命令
tsshutdn 												#60秒倒计时关机命令
lusrmgr.msc 										#本机用户和组
services.msc 										#本地服务设置
oobe/msoobe /a 									#检查xp是否激活
notepad 												#打开记事本
cleanmgr 												#垃圾整理
net start messenger 						#开始信使服务
```

## windows运行命令大全

```bash
winver													#检查windows版本
dxdiag													#检查directx信息
mem.exe													#显示内存使用情况
sndvol32												#音量控制程序
sfc.exe													#系统文件检查器
gpedit.msc 											#组策略
regedit.exe 										#注册表
msconfig.exe 										#系统配置实用程序
cmd.exe 												#cmd命令提示符
chkdsk.exe 											#chkdsk磁盘检查
mem.exe													#显示内存使用情况
gpedit.msc 											#组策略
regedit.exe 										#注册表
msconfig.exe 										#系统配置实用程序
cmd.exe 												#cmd命令提示符
services.msc 										#服务
lusrmgr.msc 										#本地账户管理
drwtsn32 												#系统医生
cleanmgr 												#垃圾整理
iexpress 												#木马捆绑工具，系统自带
mmc 														#控制台
dcpromo 												#活动目录安装
ntbackup 												#系统备份和还原
rononce -p 											#15秒关机
taskmgr 												#任务管理器
conf 														#启动netmeeting
devmgmt.msc 										#设备管理器
diskmgmt.msc 										#nt的磁盘管理器
compmgmt.msc 										#计算机管理
winchat 												#win自带局域网聊天 win10已不可用
dvdplay 												#dvd播放器
mplayer2 												#简易widnows media player
mspaint 												#画图板
nslookup 												#网络管理的工具
syskey 													#系统加密，一旦加密就不能解开，保护windows xp系统的双重密码
wupdmgr 												#widnows update
clipbrd 												#剪贴板查看器
odbcad32 												#odbc数据源管理器
nslookup 												#ip地址侦测器
```