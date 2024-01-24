package com.myblog.myblog4;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        for(int i=0; i<10; i++){
            l.add(i);
        }
        Iterator itr = l.iterator();
        while (itr.hasNext()){
            Integer I = (Integer) itr.next();
            if(I%2==0){
                System.out.print(I+ " "); //0 2 4 6 8
            } else itr.remove();
        }
        System.out.println(l); //[0, 2, 4, 6, 8]
    }
}
