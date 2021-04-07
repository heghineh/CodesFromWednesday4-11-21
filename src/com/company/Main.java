package com.company;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Circle> stream = Stream.of(new Circle("Circle1", 4), new Circle("Circle2", 2));

        // System.out.println(circles);
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
    }
}
