package com.akhambir.solution;


import java.util.Arrays;

public class Network {

    private int[] id;

    public Network(int n) {

        if (n < 2) {
            throw new IllegalArgumentException("Constructor argument should be 2 or higher integer value");
        }

        id = new int[n + 1];

        for (int i = 1; i < id.length; i++) {
            id[i] = i;
        }
    }

    public void connect(int a, int b) {
        isValidArgs(a, b);
        int i = root(a);
        int j = root(b);
        id[i] = j;
    }

    public boolean query(int a, int b) {
        isValidArgs(a, b);
        return root(a) == root(b);
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }

        return i;
    }

    private void isValidArgs(int ... args) {
        for (int arg : args) {
            if (arg < 1) {
                throw new IllegalArgumentException("Arguments should be positive integers.");
            }
            if (arg > id.length - 1) {
                throw new IllegalArgumentException("Arguments should not be higher then size of a given set of integers.");
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}
