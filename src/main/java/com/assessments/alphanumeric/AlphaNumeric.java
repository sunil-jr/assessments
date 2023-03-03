package com.assessments.alphanumeric;

import java.util.Random;
import java.util.Scanner;

public class AlphaNumeric {


    public static void main(String[] args) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String all_characters = alphabets + alphabets.toUpperCase() + numbers;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of alphanumeric values: ");
        int length = scanner.nextInt();
        String alphanumeric = new Random()
                .ints(0, all_characters.length())
                .limit(length)
                .mapToObj(c -> String.valueOf(all_characters.charAt(c)))
                .reduce(String::concat).get();

        System.out.println("The random alphanumeric String is: " + alphanumeric);
    }
}
