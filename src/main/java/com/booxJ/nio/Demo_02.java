package com.booxJ.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @description:通过通道写入文件
 * @author: wb
 * @data: 2017/10/27 16:22
 * @see:
 * @since:
 */
public class Demo_02 {

    public static void main(String[] args) {

//        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("nio_write.txt"),
//                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
//            ByteBuffer buffer = ByteBuffer.allocate(26);
//
//            for (int i = 0; i < 26; i++)
//                buffer.put((byte) ('A' + i));
//
//            buffer.rewind();
//
//            fileChannel.write(buffer);
//        } catch (InvalidPathException e) {
//            System.out.println("Path Error " + e);
//        } catch (IOException e) {
//            System.out.println("I/O Error " + e);
//        }

        try (FileChannel fileChannel=(FileChannel)Files.newByteChannel(Paths.get("nio_write.txt"),
                StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
            MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,26);

            for (int i=0;i<26;i++){
                byteBuffer.put((byte)('A'+i));
            }
        }catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }

    }
}
