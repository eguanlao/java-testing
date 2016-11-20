package me.about.eguanlao.immutability;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class UnmodifiableListSupplierTest {

  private Supplier<List<String>> listSupplier;

  @Before
  public void setUp() {
    listSupplier = new UnmodifiableListSupplier(Lists.newArrayList("foo", "bar"));
  }

  @Test
  public void should_have_the_expected_initial_size() {
    assertThat(listSupplier.get()).hasSize(2);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void should_increase_the_size_of_the_list() {
    listSupplier.get().add("baz");
  }

}
