package com.meicilly;

/**
 * NIO 三大核心组件 Channel(通道) Buffer(通道) Selector(选择器)
 *
 * NIO与OIO的对比
 * 1.OIO是面向流的(stream Oriented)的，NIO是面向缓冲区(Buffer Oriented)的
 *      在一般的OIO操作中，面向字节流或字符流的IO操作总是以流式的方式顺序地从一个流(Stream)中读取一个或者多个字节，因此我们不能随意修改指针的位置
 *      在NIO中引入了Channel和Buffer的概念。面向缓冲区的读取和写入只需要从通道读取数据到缓冲区中，或将数据从缓冲区写入通道中
 * 2.OIO的操作是阻塞状态的，而NIO的操作状态是非阻塞的
 *      IOI 例如我们调用一个read方法读取一个文件的内容，调用read方法就会 被阻塞，直到read操作完成。
 *      NIO 当我们调用read方法时，如果此时有数据，则read读取数据并返回；如果此时没有数据，则read也会直接返回，而不会阻塞当前线程
 * 3.OIO中没有selector选择器
 *
 * 通道
 * OIO中，同一个网络会关系到两个流：一个是输入流(Input Stream)，另一个是输出流(Output Stream)
 * NIO中，一个网络连接使用一个通道表示，所有NIO的IO操作都是通过连接通道完成的。
 */
public class NIO {
    public static void main(String[] args) {

    }
}
