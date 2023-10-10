package com.meicilly;



import java.nio.IntBuffer;
import java.util.logging.Logger;

/**
 * Buffer类是个抽象类 在NIO中有8种缓冲区
 * ByteBuffer
 * CharBuffer
 * DoubleBuffer
 * FloatBuffer
 * IntBuffer
 * LongBuffer
 * ShortBuffer
 * MappedByteBuffer 专门用于内存映射的类
 *
 * Buffer类有三个重要偶读成员属性
 * capacity(容量)
 *  表示内部容量的大小。一旦写入的对象数量超过capacity,缓冲区就满，不能再写入了
 * position(读写位置)
 *  表示当前的位置。position属性值与缓冲区的读写模式有关。在不通模式下的含义不同
 *  在写模式下
 *      1.在刚进入写模式时，position值为0，表示当前的写入位置为从头开始
 *      2.每当一个数据写到缓冲区之后，position会向后移动到下一个可写的位置
 *      3.初始的position值为0，最大可写值为limit-1。当position值达到limit时，缓冲区就已经无空间可写了
 *  在读模式下
 *      1.当缓冲区开始进入读模式，position会被重置为0
 *      2.当从缓冲区读取时，也是从position位置开始读。读取数据后，position向前移动到下一个可读位置。
 *      3.在读模式下，limit表示可读数据的上限。position的最大值为最大可读上限limit，当position达到limit时表明缓冲区已经无数据了。
 *  limit(读写限制)
 */
public class BufferNIO {
    //一个整型的Buffer静态变量
    static IntBuffer intBuffer = null;
    public static void main(String[] args) {
        allocateTest();
        putTest();
        flipTest();
        getTest();
        rewindTest();
        afterRead();
        clearDemo();
    }
    public static void allocateTest(){
        //创建一个buffer实例
        intBuffer = IntBuffer.allocate(20);
        System.out.println(" =========== allocateTest ===========");
        System.out.println("position="+ intBuffer.position());
        System.out.println("limit="+intBuffer.limit());
        System.out.println("capacity="+intBuffer.capacity());
    }

    /**
     * 在调用allocate()方法分配内存、返回了实例对象后，缓冲区实例对象处于写模式，可以写入对象，如果要把对象写入缓冲区，就需要调用put()方法
     */
    public static void putTest(){
        for (int i = 0; i < 5; i++) {
            //写入一个整数到缓冲区
            intBuffer.put(i);
        }
        System.out.println(" =========== putTest ===========");
        System.out.println("position="+ intBuffer.position());
        System.out.println("limit="+intBuffer.limit());
        System.out.println("capacity="+intBuffer.capacity());
    }

    /**
     * 如果需要读数据，要将缓冲区转换成读模式
     */
    public static void flipTest(){
        //翻转缓冲区，从写模式翻转成读模式
        intBuffer.flip();
        System.out.println(" =========== flipTest ===========");
        System.out.println("position="+ intBuffer.position());
        System.out.println("limit="+intBuffer.limit());
        System.out.println("capacity="+intBuffer.capacity());
    }

    /**
     * 调用flip()方法将缓冲区换成读模式之后，就可以开始从缓冲区读取数据了
     */
    public static void getTest(){
        //先读取两个数据
        for (int i = 0; i < 2; i++) {
            int j = intBuffer.get();
            System.out.println("j =" + j);
        }
        System.out.println(" =========== getTest ===========");
        System.out.println("position="+ intBuffer.position());
        System.out.println("limit="+intBuffer.limit());
        System.out.println("capacity="+intBuffer.capacity());
    }
    /**
     * 已经读取完的数据要重新读取就要调用rewind()
     */
    public static void rewindTest(){
        //倒带
        intBuffer.rewind();
        System.out.println(" =========== rewindTest ===========");
        System.out.println("position="+ intBuffer.position());
        System.out.println("limit="+intBuffer.limit());
        System.out.println("capacity="+intBuffer.capacity());
    }
    /**
     * mark()和reset()方法都是配套使用的
     * Buffer.mark()方法将当前position的值保存起来放在mark属性中，让mark属性记住这个临时位置
     * 然后调用Buffer.reset()方法将mark的值恢复到position中
     */
    public static void afterRead(){
        for (int i = 0; i < 2; i++) {
            int j = intBuffer.get();
            System.out.println("j =" + j);
        }
        //做标记
        intBuffer.mark();
        for (int i = 0; i < 2; i++) {
            int j = intBuffer.get();
            System.out.println("j =" + j);
        }
        //把前面保存在mark中的值恢复到position
        intBuffer.reset();
        System.out.println(" =========== afterRead ===========");
        System.out.println("position="+ intBuffer.position());
        System.out.println("limit="+intBuffer.limit());
        System.out.println("capacity="+intBuffer.capacity());
    }
    /**
     * clear()方法将缓冲区切换为写模式
     */
    public static void clearDemo(){
        //清空缓冲区 进入写模式
        intBuffer.clear();
        System.out.println(" =========== clear ===========");
        System.out.println("position="+ intBuffer.position());
        System.out.println("limit="+intBuffer.limit());
        System.out.println("capacity="+intBuffer.capacity());
    }
}
