package io.github.salehparsa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Properties prop = new Properties();
        OutputStream output = null;
        Scanner s = new Scanner(System.in);
        int number;
        String property;
        String value;
        System.out.println("How many properties do you want in config file?");
        number = s.nextInt();
        try {
            output = new FileOutputStream("config.properties");
            // set the properties value
            for (int i=0; i <number; i++)
            {
                System.out.println("What's your property Name?");
                property = s.next();
                System.out.println("What's your property Value?");
                value = s.next();
                prop.setProperty(property, value);
            }
            // save properties to root directory
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
