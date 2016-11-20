package me.about.eguanlao.codility;

// you can also use imports, for example:

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {

  private final Deque<Integer> stack;

  private int size;

  private boolean transactionOn;

  private List<String> history;

  public Solution() {
    // write your code in Java SE 8
    stack = new ArrayDeque<Integer>();
    history = new ArrayList<String>();
  }

  public void push(int value) {
    stack.push(value);
    if (transactionOn) {
      history.add("push:" + value);
    }
  }

  public int top() {
    final Integer value = stack.peek();
    return value != null ? value : 0;
  }

  public void pop() {
    try {
      final Integer value = stack.pop();
      if (transactionOn) {
        history.add("pop:" + value);
      }
    } catch (final NoSuchElementException ignored) {
    }
  }

  public void begin() {
    synchronized (Solution.class) {
      transactionOn = true;
    }
  }

  public boolean rollback() {
    return false;
  }

  public boolean commit() {
    synchronized (Solution.class) {
      transactionOn = false;
    }
    return true;
  }

  public static void test() {
    // Define your tests here
    Solution sol = new Solution();
    sol.push(42);
    assert sol.top() == 42 : "top() should be 42";

    Solution sol1 = new Solution();
    sol1.push(5);
    sol1.push(2);
    assert sol1.top() == 2;
    sol1.pop();
    assert sol1.top() == 5;

    Solution sol2 = new Solution();
    assert sol2.top() == 0;
    sol2.pop();
    assert sol2.top() == 0;

    sol = new Solution();
    sol.push(4);
    sol.begin();                    // start transaction 1
    sol.push(7);                    // stack: [4,7]
    assert sol.top() == 7;
    sol.begin();                    // start transaction 2
    sol.push(2);                    // stack: [4,7,2]
    assert sol.top() == 2;
    assert sol.rollback() == true;  // rollback transaction 2
    assert sol.top() == 7;          // stack: [4,7]
    sol.begin();                    // start transaction 3
    sol.push(10);
    assert sol.commit() == true;    // transaction 3 is committed
    assert sol.top() == 10;
    assert sol.rollback() == true;  // rollback transaction 1
    assert sol.top() == 4;          // stack: [4]
    assert sol.commit() == false;   // there is no open transaction
  }
}
