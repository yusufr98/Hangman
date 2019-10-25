package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	    Scanner k = new Scanner(System.in);
	    Random r = new Random();
	    String[] words = {"tree","rain","bear","encourage","promise","soup","chess","insurance","pancakes","stream"};
        String answer = words[r.nextInt(words.length)];
        char[] check = answer.toCharArray();
        char[] guess = new char[answer.length()];
        boolean repeat = true;
        int count = 0;
        for(int i = 0; i < check.length; i++){
            guess[i] = '_';
        }
        System.out.println("Welcome, let's play hangman!");
        System.out.print("Here is the word I'm looking for: ");
        for(char c : guess){
            System.out.print(c + " ");
        }
        System.out.println();
        do {
            System.out.print("Enter your guess: ");
            String g = k.next();
            boolean correct = false;
            boolean complete = false;
            if (g.length() == 1) {
                for (int i = 0; i < check.length; i++) {
                    if (check[i] == g.charAt(0)) {
                        guess[i] = g.charAt(0);
                        correct = true;
                    }
                }
                if (!correct) {
                    count++;
                }
                for (int i = 0; i < check.length; i++){
                    if (guess[i] == check[i]) {
                        complete = true;
                    } else {
                        complete = false;
                        break;
                    }
                }
            } else {
                if (g.length() == check.length) {
                    for (int i = 0; i < check.length; i++) {
                        if (g.charAt(i) == check[i]) {
                            complete = true;
                        } else {
                            complete = false;
                            count++;
                            break;
                        }
                    }
                }
            }
            if (!complete) {
                System.out.print("Your guess so far: ");
                for (char c : guess) {
                    System.out.print(c + " ");
                }
                System.out.println();
                if (count > 0) {
                    System.out.println("You have guessed incorrectly " + count + "/6 times");
                    man(count);
                }
                if (count == 6) {
                    System.out.println("Sorry, you have no guesses left. You are dead. The word was " + answer + ".");
                    repeat = false;
                }
            }
            else{
                System.out.println("You've won! The word was " + answer + ".");
                repeat = false;
            }
        } while (repeat);
    }
    public static void man(int count){
        System.out.println("______");
        for (int i = 0; i < 3; i++){
            System.out.println("\t |");
        }
        if(count >= 1){
            System.out.println("\t O ");
        }
        if(count == 2){
            System.out.println("\t | ");
        }
        else if (count == 3){
            System.out.println("\t/| ");
        }
        else if (count >= 4){
            System.out.println("\t/|\\");
        }
        if (count == 5){
            System.out.println("\t/");
        }
        if (count == 6){
            System.out.println("\t/ \\");
        }
    }
}
