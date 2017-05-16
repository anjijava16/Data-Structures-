package amazon.interview.questions.datastructure;

import java.util.Arrays;

/**
 * Created by govind.bhone on 5/16/2017.
 */
/*
Program: Write a program to implement ArrayList.

Description:
Write a program to implement your own ArrayList class. It should
contain add(), get(), remove(), size() methods. Use dynamic array logic.
It should increase its size when it reaches threshold.
*/
public class ArrayListExample {
    private Object [] state ;
    private int actualSize ;

    public ArrayListExample(){
        state = new Object[10];
    }

    public Object get(int index){
        if(index < 0 || index > actualSize) throw new ArrayIndexOutOfBoundsException("size issue");
        return state[index];
    }

    private void increaseSize(){
        Arrays.copyOf(state,state.length*2);
        System.out.println("\nNew length: "+state.length);
    }
    public void add(Object ele){
        if(state.length-actualSize <=5){
            increaseSize();
        }
        state[actualSize++]=ele ;
    }

    public Object remove(int index){
        if(index < actualSize){
            Object returning = state[index];
            state[index]=null;
            int tmp =index;

            while(tmp <actualSize){
                state[tmp]=state[tmp+1];
                state[tmp+1]=null;
                tmp++;
            }
            actualSize--;
            return  returning;
        }else{
            throw new ArrayIndexOutOfBoundsException("size issue");
        }
    }

    public int size(){
        return actualSize;
    }

    public static void main(String a[]){
        ArrayListExample mal = new ArrayListExample();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+mal.get(5));
        System.out.println("List size: "+mal.size());
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
    }
}
