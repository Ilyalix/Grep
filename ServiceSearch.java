package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class ServiceSearch {
    public static void main(String[] args) {
        System.out.print("Введите текст:");

        Scanner in = new Scanner(System.in);
        String text = new String(in.nextLine());

        ServiceSearch serviceSearch = new ServiceSearch();
        try {
            serviceSearch.grep(args,text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void grep(String[] args, String text) throws FileNotFoundException, OutOfMemoryError {
        char[] CharText = text.toCharArray();

        ArrayList<String> MassString = new ArrayList<>();

        String str = "";

        for (int i = 0; i < CharText.length; i++) {
            if (CharText[i] == '.' || CharText[i] == '!' || CharText[i] == '?') {
                str = str + CharText[i];
                MassString.add(str);
                str = "";
            } else {
                if (CharText[i] == ' ' && (CharText[i - 1] == '.' || CharText[i - 1] == '!' || CharText[i - 1] == '?'))
                    i++;
                str = str + CharText[i];

            }
        }
        System.out.println("Отфильтрованный текст:");

        for (String a : MassString) {
            int counter = 0;
            for (int j = 0; j < args.length; j++) {
                if (a.toLowerCase().contains(args[j].toLowerCase()))
                    counter++;
            }

            if (counter == args.length) {
                System.out.println(a);
            }
        }
    }
}