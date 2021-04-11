package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main1 {
    public static void main(String[] args) {

        //Copy the content of the file from Desktop to the file from Documents
        File fileFromDesktop = new File("C:\\Users\\User\\OneDrive\\Desktop\\fileFromDesktop.txt");
        File fileFromDocuments = new File("C:\\Users\\User\\OneDrive\\Documents\\fileFromDocuments.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileFromDesktop))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                OutputStream outputStream = new FileOutputStream(fileFromDocuments);
                byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
                outputStream.write(bytes);
                System.out.println("Text is successfully copied from fileFromDesktop.txt to fileFromDocuments.txt");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Copy the file from Desktop to Documents
        File fileFromDesktopCopy = new File("C:\\Users\\User\\OneDrive\\Documents\\fileFromDesktopCopy.txt");

        try (InputStream in = new BufferedInputStream(new FileInputStream(fileFromDesktop))) {
            OutputStream out = new BufferedOutputStream(new FileOutputStream(fileFromDesktopCopy));
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The fileFromDesktop.txt is successfully copied to Documents.");
    }
}