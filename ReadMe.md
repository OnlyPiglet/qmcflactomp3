# FlacToMp3
针对腾讯音乐的SQ加密音乐做的一个转换为Mp3的客户端。
[参考了此C++开源项目](https://github.com/Presburger/qmc-decoder)
开项目最低支持JDK1.7   
项目采用了同步阻塞多线程技术实现高效并发转换
# 待优化
* 项目的异步非阻塞未做
* Loadig界面的打开与关闭未做
* 多线程的内存溢出异常未进行有效的处理
