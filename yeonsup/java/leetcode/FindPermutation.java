package yeonsup.java.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class FindPermutation {

    public int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int j = 0;

        for (int i = s.length() + 1; i > 0; i--) {
            stack1.push(i);
        }

        while (j < s.length()) {
            Integer n = stack1.pop();
            char c = s.charAt(j);
            if(c == 'I') {
                list.add(n);
                while (!stack2.isEmpty()) {
                    list.add(stack2.pop());
                }
            } else if (c == 'D') {
                stack2.push(n);
            }

            j++;
        }

        while (!stack1.isEmpty()) {
            list.add(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }



        System.out.println(list.toString());

        return list.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        new FindPermutation().findPermutation("II");
    }
}
