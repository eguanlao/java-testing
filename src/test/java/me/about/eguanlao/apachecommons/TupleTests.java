package me.about.eguanlao.apachecommons;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TupleTests {

  @Test
  public void shouldCreateAnImmutablePair() {
    final String name = "Erick";
    final List<String> names = newArrayList(name);
    final Long bookingId = 1234L;

    final ImmutablePair<List<String>, Long> namesAndBookingId = new ImmutablePair<>(
        names, bookingId);

    assertThat(namesAndBookingId.getLeft(), is(names));
    assertThat(namesAndBookingId.getRight(), is(bookingId));
  }

}
