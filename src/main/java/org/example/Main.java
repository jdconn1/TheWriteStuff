package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String file = "src\\people.csv";
        BufferedReader reader = null;
        String line = "";

        getReader(reader,line,file);

        try( PrintWriter writer = new PrintWriter(new FileWriter(file, true))){

            Scanner sc = new Scanner(System.in);

            System.out.println(" ");
            System.out.println("Enter Your name (first and last).");
            String name = sc.nextLine();
            System.out.println("Enter your age.");
            String age = sc.nextLine();
            System.out.println("Enter your gender.");
            String gender = sc.nextLine();
            System.out.println("Enter you Email.");
            String email = sc.nextLine();
            System.out.println("Enter you phone number in this format (XXX)XXX-XXXX");
            String phone = sc.nextLine();

            writer.println(name + "," + age + "," + gender + "," + email + "," + phone);
            System.out.println("New record added successfully.");

        }catch (Exception e){
            e.printStackTrace();
        }
        getReader(reader,line,file);
    }

    public static void getReader(BufferedReader reader, String line, String file){
        try{
            reader = new BufferedReader(new FileReader(file));

            while((line = reader.readLine()) != null){

                String[] row = line.split(",");

                for (String rows: row) {
                    System.out.printf("%-25s", rows);
                }
                System.out.println(" ");
            }
        } catch (Exception e){
            e.printStackTrace();

        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}