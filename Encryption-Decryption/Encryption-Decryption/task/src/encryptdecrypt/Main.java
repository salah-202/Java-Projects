package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[] allChars = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
        char[] alphapatcs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        String option = "enc";
        String syntex = "";
        String alg = "shift";
        int k = 0;

        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-mode")) {
                option = args[i + 1].trim();
            } else if (args[i].equals("-key")) {
                k = Integer.parseInt(args[i + 1].trim());
            } else if (args[i].equals("-data")) {
                syntex = args[i + 1];
                break;
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
            } else if (args[i].equals("-in")) {
                String fileName = args[i + 1];

                File file = new File(fileName);
                StringBuilder fileContents = new StringBuilder((int) file.length());
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        fileContents.append(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error: File not found.");
                }
                syntex = fileContents.toString();
            }

        }


        String data = "";
        if(alg == "unicode"){
            if (option.equals("enc")) {
                data = enc(syntex, k, allChars,alg);
            } else if (option.equals("dec")) {
                data = dec(syntex, k, allChars,alg);
            }
        } else if (alg == "shift") {
            if (option.equals("enc")) {
                data = enc(syntex, k, alphapatcs,alg);
            } else if (option.equals("dec")) {
                data = dec(syntex, k, alphapatcs,alg);
            }
        }

        String fileName = "";
        boolean found = false;
        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-out")) {
                fileName = args[i + 1];
                found = true;
                break;
            }
        }
        if(found){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write(data);
                System.out.println("Data written to file successfully!");
            } catch (IOException e) {
                 System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }

        }else{
            System.out.println(data);
        }


    }

    public static String enc(String syntex,int k,char[] alphabet,String alg){
        String enc = "";
        for (char ch:syntex.toCharArray()) {
            boolean found = false;
            for (int i=0;i<alphabet.length;i++){
                if(ch == alphabet[i] && Character.isUpperCase(ch) && alg.equals("shift")){
                    enc += alphabet[(i+k) % alphabet.length];
                    found = true;
                    break;
                } else if (ch == alphabet[i] && !Character.isUpperCase(ch) && alg.equals("shift")) {
                    enc += alphabet[(i+k) % (alphabet.length/2)];
                    found = true;
                    break;
                } else if (ch == alphabet[i] && alg.equals("unicode")) {
                    enc += alphabet[(i+k) % alphabet.length];
                    found = true;
                    break;
                }
            }
            if(!found){
                enc += ch;
            }
        }
        return enc;
    }

    public static String dec(String syntex,int k,char[] alphabet,String alg){
        String dec = "";
        for (char ch:syntex.toCharArray()) {
            boolean found = false;
            for (int i=0;i<alphabet.length;i++){
                if(ch == alphabet[i] && Character.isUpperCase(ch) && alg.equals("shift")){
                    dec += alphabet[(i-k +alphabet.length) % alphabet.length];
                    found = true;
                    break;
                } else if (ch == alphabet[i] && !Character.isUpperCase(ch) && alg.equals("shift")) {
                    dec += alphabet[(i-k+alphabet.length/2) % (alphabet.length/2)];
                    found = true;
                    break;
                } else if (ch == alphabet[i] && alg.equals("unicode")) {
                    dec += alphabet[(i-k +alphabet.length) % alphabet.length];
                    found = true;
                    break;
                }
            }
            if(!found){
                dec += ch;
            }
        }
        return dec;
    }
}

