package com.alpro;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

class BruteForce{
    public void brute(int input) {
        Hash hash = new Hash();
        byte[] inputUser=null;
        try {
            inputUser = hash.hashing(input);
        }catch (Exception e){
            brute(input);
        }
        for (int i = 0; i < 2000000000; i++) {
            System.out.println(i);
            if (MessageDigest.isEqual(hash.hashing(i), inputUser)){
                System.out.println("ditemukan selama : "+i+" percobaan");
                System.exit(0);
                break;
            }
        }
        System.out.println("tidak ketemu");
    }
}

class Hash{
    public byte[] hashing(int input) {
        byte[] output = null;
        String in=Integer.toString(input);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            output = digest.digest(in.getBytes(StandardCharsets.UTF_8));
            System.out.println(Arrays.toString(output));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return output;
    }
}

public class Main {

    public static void main(String[] args) {
        int password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("masukan pin :");
        password = scanner.nextInt();
        BruteForce bruteForce = new BruteForce();
        Hash hash = new Hash();
        hash.hashing(password);
        bruteForce.brute(password);
    }
}
