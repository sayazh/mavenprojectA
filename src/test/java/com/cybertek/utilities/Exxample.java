package com.cybertek.utilities;

public class Exxample {
    public static void main(String[] args) {
         String one =Singleton.get();
        System.out.println("one : "+one);

         String two =Singleton.get();
        System.out.println("two: "+two);

        String three =Singleton.get();
        System.out.println("three: "+three);
    }
}
