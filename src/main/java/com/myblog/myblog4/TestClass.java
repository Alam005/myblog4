package com.myblog.myblog4;

public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int val = testClass.test();
        System.out.println(val);
    }
    public int test(){
        int x =100;
        return x*x;
    }
}
