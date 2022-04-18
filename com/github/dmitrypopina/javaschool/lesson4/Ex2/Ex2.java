package com.github.dmitrypopina.javaschool.lesson4.Ex2;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) throws Exception {
        String URL;
        Scanner console = new Scanner(System.in);
        System.out.print("Введите URL сайта: ");
        URL = console.next();
        String content = URLConnection.getText(URL);
        System.out.println(content);
    }
}