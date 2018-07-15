package com.lessons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mail operation with file
 */
public class FileCommander {

    public static final String PATH = "../it-school/src/main/resources/any-file.txt";
    private final static Pattern MAILPATTERN = Pattern.compile("[0-9a-z]{1,}@[a-z]{1,}.[a-z]{2,3}");

    /**
     * Find all email in the file and write them in console
     */
    public static void writeAllValideEmail() {
        try {
            String fileWithMails = new String(Files.readAllBytes(Paths.get(PATH)));

            Matcher matcher = MAILPATTERN.matcher(fileWithMails);

            System.out.println("---------mails in file-----------");

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Input, validate and write to the file email
     */
    public static void addEmail() {
        Scanner scanner = new Scanner(System.in);
        String forScaner = "";

        System.out.println("Enter new any email, for quit 'q':");

        while (!forScaner.equals("q")) {

            forScaner = scanner.nextLine();

            if (!forScaner.equals("q") & validateEmail(forScaner)) {
                try {
                    Files.write(Paths.get(PATH), ("\n" + forScaner).getBytes(), StandardOpenOption.APPEND);
                    System.out.println(forScaner + " added to the file");
                } catch (IOException e) {
                    System.out.println("it's realy no deal with files...");
                }
            }

        }
    }

    private static boolean validateEmail(String email) {
        try {
            String[] partEmail = email.split("@");
            if (partEmail.length != 2 || partEmail[1].split("\\.").length != 2) {
                System.out.println("incorrect email : " + email);
                return false;
            }
        } catch (Exception e) {
            System.out.println("Some incorrect email");
            return false;
        }
        return true;
    }

}
