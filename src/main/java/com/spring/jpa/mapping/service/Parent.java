package com.spring.jpa.mapping.service;

import java.io.*;
class Parent{

    public Parent(){
        System.out.println("Default constructor");
        new Parent(7);
    }
    public Parent(int a){
        System.out.println("Int Constructor");
        new Parent();
    }
    public static void main(String[] args)
    {
        Parent P = new Parent();
    }
}

