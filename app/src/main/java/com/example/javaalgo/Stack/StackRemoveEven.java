package com.example.javaalgo.Stack;

import java.util.Stack;

public class StackRemoveEven {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(12);
        st.push(1);
        st.push(5);
        st.push(8);
        st.push(9);
        st.push(10);

        // order - 10, 9, 8, 5, 1, 12
        // result - 9, 5, 1

        Stack<Integer> result = removeEvenNumbersFromStack(st);
        while (!result.isEmpty()) {
            System.out.print(result.pop() + ", ");
        }
        System.out.println();
    }

    static Stack<Integer> removeEvenNumbersFromStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            Integer num = st.pop();
            if (num % 2 != 0) {
                temp.push(num);
            }
        }

        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

        return st;
    }
}
