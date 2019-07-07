package com.nio.leran.demo;

/**
 * Created by hexinquan on 2019/04/17.
 * 一.缓冲区(Buffer):在 Java NIO中负责数据的存取。缓冲区就是数组.用于存储不同的数据类型的数据
 * 根据数据类型不同(除boolean除外),提供类相应类型缓冲区:
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 上述缓冲区的管理方式几乎一致,allocate()获取缓冲区
 *
 * 二.
 * 缓冲区存取数据的两个核心方法:
 *  put():存入数据到缓冲区
 *  get():取出缓冲区数据
 *
 * 三.
 * 缓冲区中的四个核心属性:
 * capacity:容量,表示缓冲区中最大存储数据的容量.一旦声明不能改变
 * limit:界限，表示缓冲区中可以操作数据的大小.（limit 后数据不能进行读写）
 * position：位置,表示缓冲区中正在操作数据的位置。
 * position <= limit <=capacity
 */
public class TestBuffer {
    public static void main(String[] args) {
    }

}
