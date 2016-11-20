package me.about.eguanlao.codility;

import org.junit.Ignore;
import org.junit.Test;

public class SolutionTest {

  @Ignore
  @Test
  public void should() {
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
    assert sol.rollback();  // rollback transaction 2
    assert sol.top() == 7;          // stack: [4,7]
    sol.begin();                    // start transaction 3
    sol.push(10);
    assert sol.commit();    // transaction 3 is committed
    assert sol.top() == 10;
    assert sol.rollback();  // rollback transaction 1
    assert sol.top() == 4;          // stack: [4]
    assert !sol.commit();   // there is no open transaction
  }

}
