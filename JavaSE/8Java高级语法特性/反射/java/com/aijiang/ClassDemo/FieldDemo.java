package com.aijiang.ClassDemo;

import java.lang.reflect.Field;


class SupClass {
    public int a;
    private int b;
}

class SubClass extends SupClass {
    int c;
    private String d;
    protected float e;
}

public class FieldDemo {
    public static void main(String[] args) {

        Class cls = SubClass.class;

        try {
            Field field = cls.getDeclaredField("b");

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println("getDeclaredField " + e.getMessage());
        } catch (SecurityException e) {
            e.printStackTrace();
            System.out.println("getDeclaredField " + e.getMessage());
        }

        try {
            Field field = cls.getField("b");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println("getField " + e.getMessage());
        } catch (SecurityException e) {
            e.printStackTrace();
            System.out.println("getField " + e.getMessage());
        }


        Field[] filed1 = cls.getDeclaredFields();

        for (Field f : filed1) {
            System.out.println("Declared Field :" + f.getName());
        }

        Field[] filed2 = cls.getFields();

        for (Field f : filed2) {
            System.out.println("Field :" + f.getName());
        }

    }
}
