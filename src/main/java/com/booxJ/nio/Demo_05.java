package com.booxJ.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @description:为路径和文件系统操作使用NIO
 * @author: wb
 * @data: 2017/10/27 16:55
 * @see:
 * @since:
 */
public class Demo_05 {

    public static void main(String[] args) {

        Path filePath = Paths.get("nio.txt");

        System.out.println("File Name:" + filePath.getFileName());
        System.out.println("Path:" + filePath);
        System.out.println("Absolute Path:" + filePath.toAbsolutePath());
        System.out.println("Parent:" + filePath.getParent());

        if (Files.exists(filePath))
            System.out.println("File exists");
        else
            System.out.println("File does not exists");

        try {
            if (Files.isHidden(filePath))
                System.out.println("File is hidden");
            else
                System.out.println("File is not hidden");

        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }

        Files.isWritable(filePath);
        Files.isReadable(filePath);

        try {
            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            if (attributes.isDirectory()){

            }
            if (attributes.isRegularFile()){

            }
            if (attributes.isSymbolicLink()){

            }
        } catch (IOException e) {
            System.out.println("Error reading attributes: " + e);
        }

    }
}
