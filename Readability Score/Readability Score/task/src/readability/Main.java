package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        /*
        String fileName = args[0];

        File file = new File(fileName);
        StringBuilder fileContents = new StringBuilder((int)file.length());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        String syntex = fileContents.toString();
        System.out.println("File contents: " + syntex);


         */
        Scanner sc = new Scanner(System.in);
        String syntex = sc.nextLine();

        String[] lines = syntex.split("[.!?]");
        String[] words = syntex.split("\\s+");
        double charLen = syntex.replaceAll("\\s","").length();
        double score = 4.71 * (charLen / (double) words.length) + 0.5 * ((double) words.length / (double) lines.length) - 21.43;

        int poly = 0;
        for (String word:words) {
            if(word.matches("\\w*[aeiouyAEIOUY]{1}\\w+[aeiouyAEIOUY]{1}\\w*")){
                poly++;
            }
            if(word.charAt(word.length() - 1) == 'e'){
                poly--;
            }
        }
        int syb = (int) Pattern.compile("\\b[^aeyuioAEYUIO\\s]+[aeyuioAEYUIO]\\b|[aeyuioAEYUIO]*[eE](?!\\b)[aeyuioAEYUIO]*|[ayuioAYUIO]+|\\d+[,.]\\d*").matcher(syntex).results().count();

        System.out.println("Words: "+words.length);
        System.out.println("Sentences: "+lines.length);
        System.out.println("Characters: "+(int) charLen);
        System.out.println("Syllables: "+ syb);
        System.out.println("Polysyllables: "+ poly);
        System.out.println("The score is: "+(double)Math.round(score * 100) / 100);
        System.out.println("This text should be understood by " + (int)(Math.ceil(score) + 4) +"-" +(int)(Math.ceil(score) + 5) + " year-olds.");
    }

    public static int countSyllables(String text,String[] words) {
        String[] vowles = text.split("[aeiouyAEIOUY]+");
        int count = vowles.length;
        for (String word:words) {
            if(word.charAt(word.length() - 1) == 'e'){
                count--;
            }
        }

        return count;
    }
}
