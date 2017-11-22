package com.booxJ.nio;

import java.io.IOException;
import java.nio.file.*;

/**
 * @description:文件复制
 * @author: wb
 * @data: 2017/10/27 16:38
 * @see:
 * @since:
 */

/**
 * StandardCopyOption.COPY_ATTRIBUTES 要求复制文件的属性
 * StandardOpenOption
 * StandardCopyOption.REPLACE_EXISTING 覆盖之前存在的文件
 */
public class Demo_03 {


    public static void main(String[] args){

        if (args.length!=2){
            System.out.println("Usage:Copy from to");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);

        }catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
