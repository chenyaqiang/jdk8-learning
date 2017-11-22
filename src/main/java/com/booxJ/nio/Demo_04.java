package com.booxJ.nio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * @description:为基于流的I/O使用NIO
 * @author: wb
 * @data: 2017/10/27 16:45
 * @see:
 * @since:
 */
public class Demo_04 {

    public static void main(String[] args) {
        int i;

        if (args.length != 1) {
            System.out.println("Usage:ShowFile filename");
            return;
        }
        //读
        try (InputStream fin = Files.newInputStream(Paths.get(args[0]))) {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }

        //写
        try (OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("nio_write.txt")))) {
            for (i = 0; i < 26; i++) {
                fout.write((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
