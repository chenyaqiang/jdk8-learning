package com.booxJ.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * @description:通过通道读取文件
 * @author: wb
 * @data: 2017/10/27 15:57
 * @see:
 * @since:
 */
public class Demo_01 {

    public static void main(String[] args) {
        int count;

        //调用ByteBuffer的allocate分配缓冲区，读取文件
        try (SeekableByteChannel channel = Files.newByteChannel(Paths.get("nio.txt"))) {
            ByteBuffer buffer = ByteBuffer.allocate(128);
            do {
                count = channel.read(buffer);
                if (count != -1) {
                    //回绕缓冲区
                    buffer.rewind();
                    for (int i = 0; i < count; i++)
                        System.out.print((char) buffer.get());
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }


        //将文件映射到缓冲区,不需要显式读操作
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("nio.txt"))) {
            long fileSize = fileChannel.size();
            MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);

            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) byteBuffer.get());
            }
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
