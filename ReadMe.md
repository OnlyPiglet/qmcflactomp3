# :fire::musical_note:QmcFlacToMp3 :musical_note::fire:
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg?style=flat-square)](https://github.com/996icu/996.ICU/blob/master/LICENSE)  
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