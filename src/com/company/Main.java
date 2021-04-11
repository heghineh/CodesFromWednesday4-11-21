package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    //Create Circle1 & Circle2 and move to .txt
    public static void main(String[] args) {
        Stream<Circle> stream = Stream.of(new Circle("Circle1", 4), new Circle("Circle2", 2));

        File file = new File("document.txt");

        try (OutputStream outputStream = new FileOutputStream(file)) {
            String circles = stream
                    .map(Circle::toString)
                    .collect(Collectors.joining("\n"));

            byte[] bytes = circles.getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Reading file
        File file1 = new File("C:\\Users\\User\\IdeaProjects\\untitled6\\document.txt");

        String string;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))) {
            System.out.println("Reading all file.");
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }

            //Reading first 3 lines
            System.out.println("\nReading first 3 lines of the given file.");
            LineNumberReader reader = new LineNumberReader
                    (new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
            while (((string = reader.readLine()) != null) && reader.getLineNumber() <= 3) {
                System.out.println(string);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
