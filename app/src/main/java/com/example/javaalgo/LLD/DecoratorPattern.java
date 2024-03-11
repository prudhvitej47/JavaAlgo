package com.example.javaalgo.LLD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class DecoratorPattern {

    public static void main(String[] args) {
        try {
            String str = "testing something";

            // creating empty output file initially
            File file = new File("temp.zip");

            // creating output stream to write in the data
            FileOutputStream fos = new FileOutputStream(file);
            ZipOutputStream zos = new ZipOutputStream(fos);

            // creating a text file inside the zip file
            ZipEntry ze = new ZipEntry("temp.txt");
            zos.putNextEntry(ze);

            // writing the data to output stream
            byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
            zos.write(byteArr, 0, byteArr.length);
            zos.closeEntry();
            zos.close();

            // ------------------------------------------------------------------

            // reading the input data
            FileInputStream fs = new FileInputStream("temp.zip");
            ZipInputStream zin = new ZipInputStream(fs);

            ZipEntry entry = null;
            while((entry = zin.getNextEntry()) != null) {
                System.out.println("Unzipping zip file " + entry.getName());
                File newFile = new File("somethingNew.txt");
                FileOutputStream newFileOutputStream = new FileOutputStream(newFile);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    newFileOutputStream.write(c);
                }
                newFileOutputStream.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
