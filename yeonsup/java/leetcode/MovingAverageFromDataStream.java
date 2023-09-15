package yeonsup.java.leetcode;

import java.util.ArrayDeque;

public class MovingAverageFromDataStream {

    private int size;
    private ArrayDeque<Integer> data = new ArrayDeque<>();

    public MovingAverageFromDataStream(int size) {
        this.size = size;
    }

    public double next(int val) {
        int sum = 0;
        data.push(val);

        ArrayDeque<Integer> temp = data.clone();
        int s = Math.min(size, temp.size());
        for (int i = 0; i < s; i++) {
            sum += temp.pollFirst();
        }

        return Math.round((double) sum / s * 100000) / 100000.0;
    }


    public static void main(String[] args) {
        MovingAverageFromDataStream aa = new MovingAverageFromDataStream(3);
        System.out.println(aa.next(1));
        System.out.println(aa.next(10));
        System.out.println(aa.next(3));
        System.out.println(aa.next(5));

    }
}
