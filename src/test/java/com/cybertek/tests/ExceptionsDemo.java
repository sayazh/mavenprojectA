package com.cybertek.tests;

public class ExceptionsDemo {
    public static void main(String[] args) {
        //I teach on Tuesdays -> normal flow
        //if I get ick, ->> problem, issue
        // some will replace me ->> alternative flow
        try{
            System.out.println("Maruf is teaching on Tue");
        } catch(Exception e){
            System.out.println("Akbar will take over");
        }
    }
}
