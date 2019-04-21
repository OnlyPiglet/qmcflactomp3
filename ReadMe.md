# :fire::musical_note:QmcFlacToMp3 :musical_note::fire:
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg?style=flat-square)](https://github.com/996icu/996.ICU/blob/master/LICENSE)
[![GPL Licence](https://badges.frapsoft.com/os/gpl/gpl.svg?v=103)](https://opensource.org/licenses/GPL-3.0/)
[![jdk>=1.7](https://img.shields.io/badge/jdk-%3E%3D1.7-yellowgreen.svg)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
[![stable-1.0.0](https://img.shields.io/badge/stable-1.0.0-orange.svg) ](https://github.com/OnlyPiglet/qmcflactomp3/tree/master/target)  
针对腾讯音乐的SQ加密音乐做的一个转换为Mp3的客户端。
[参考了此C++开源项目](https://github.com/Presburger/qmc-decoder)
开项目最低支持JDK1.7
如果喜欢这个项目的话可以:star:或者:two_men_holding_hands:我
项目采用了异步非阻塞多线程技术实现高效并发转换。
可执行下载target目录下的可执行jar，在具有java环境下双击即可运行程序，程序大小20k左右

# 效果图
![效果图](https://upload-images.jianshu.io/upload_images/13419832-41d0440fa6b31a63.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

# 待优化
* 项目的异步非阻塞未做
* Loadig界面的打开与关闭未做
* 多线程的内存溢出异常未进行有效的处理

# 20190420更新
# 优化
1. 更新了工程目录按照模块进行划分
1. 本次优化了错误提示内容以及错误处理的机制 
2. 以及异步非阻塞转换的实现
3. 添加打包后可执行文件 在target目录下
4. 使用更加规范的maven命名方式

# 待优化
* Loadig界面的打开与关闭未做
* 多线程的内存溢出异常未进行有效的处理
* 缺少使用教程

# 20190421更新
## 以优化
* 添加Loading界面这里参考引用了此两处网站特别指出，还有文件打开也参考了另一篇这里也一起列出，
  除了ui模块其他模块为作者所写。
  1. [JFileChooser (Java Swing提供的文件选择对话框)](https://blog.csdn.net/liang5630/article/details/25651491)
  2. [Wait with style in Swing](http://www.curious-creature.com/2005/02/15/wait-with-style-in-swing/)
  3. [SwingFX：漂亮进度面板](https://www.javalobby.org//java/forums/t19222.html)  
     ![新效果图](https://upload-images.jianshu.io/upload_images/13419832-c5f342182b230dc9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
* 关于多线程溢出问题只要单曲没有超过90M一般都没有问题。因为理论上没有经过调优的JVM虚拟机的最大堆内存为物理内存的1/4，所以一般2G物理内存，可用500M而我们同时有5个线程
  所以转换歌曲很多时，5个线程同时工作可分得100M，作者这边留有空余减了10M。理论上歌曲单曲支持大小=物理内存/4/5
* 将测试的文件已放入test文件下，可以用来测试软件是否安装成功
### 安装步骤  

1. 下载[jdk1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)并安装在安装过程中需要勾选add
   to path
2. 下载target目录下的[qmcflactomp3-all-1.0.0.jar](https://github.com/OnlyPiglet/qmcflactomp3/tree/master/target)
3. 下载src/test目录下的测试文件
4. 双击qmcflactomp3-all-1.0.0.jar，点击界面任意处，选择测试文件点击选择进行转换，在测试文件所在目录文生成同名MP3格式的文件。
# 稳定版1.0
  此版本为稳定版1.0，如无重大问题将不会升级。