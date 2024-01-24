package com.myblog.myblog4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI_TestClass {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 8, 11, 13, 17, 19, 23, 29, 31);
        List<Integer> collect = numbers.stream().filter(StreamAPI_TestClass::isPrime).collect(Collectors.toList());
        System.out.println(collect);
    }

//Defining prime number algoritham
        private static boolean isPrime(int number){
            if(number<=1){
                return false;
            }
            for(int i=2; i<Math.sqrt(number); i++){
                if(number%i==0){
                    return false;
                }
            }
            return true;
        }

    }

