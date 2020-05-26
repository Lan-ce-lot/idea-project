package work.experiment6;

import java.util.ArrayList;
import java.util.Objects;

public class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<Object>();
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int getSize() {
        return list.size();
    }
    public Object peek() {
        return list.get(getSize() - 1);
    }
    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    public void push(Object o) {
        list.add(o);
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStack myStack = (MyStack) o;
        return Objects.equals(list, myStack.list);
    }

    @Override
    public Object clone() {
        try {
            MyStack stackClone = (MyStack)super.clone();
            stackClone.list = (ArrayList<Object>)(list.clone());
            return stackClone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        MyStack S = new MyStack();
        S.push(1);
        S.push(10);
        MyStack SClone = (MyStack)S.clone();
        System.out.println("S     : " + S + "\n" + "SClone: " + SClone);
        System.out.println("S == SClone      : " + (S == SClone));
        System.out.println("S.equals(SClone) : " + S.equals(SClone));
        System.out.println("S.list.equals(SClone.list): " + (S.list.equals(SClone.list)));
        System.out.println("S.list == SClone.list     : " + (S.list == SClone.list));
        SClone.push(11);
        System.out.println("对SClone压入元素11后");
        System.out.println("S     : " + S + "\n" + "SClone: " + SClone);
    }
}


