package me.about.eguanlao.codility;

import org.junit.Test;

public class CodilityTest {

  @Test
  public void should() {

  }

  private int someMethod(int[] A) {
    int n = A[0];
    int k, m, lsum, rsum;
    for (k = 0; k < n; ++k) {
      lsum = 0;
      rsum = 0;
      for (m = 0; m < k; ++m) {
        lsum += A[m];
      }
      for (m = k + 1; m < n; ++m) {
        rsum += A[m];
      }
      if (lsum == rsum) {
        return k;
      }
    }
    return -1;
  }

}
