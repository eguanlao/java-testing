package me.about.eguanlao.immutability;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class MutableListSupplierTest {

  private Supplier<List<String>> supplier1;

  private Supplier<List<String>> supplier2;

  @Before
  public void setUp() {
    final List<String> strings = Lists.newArrayList("foo", "bar");
    supplier1 = new MutableListSupplier(strings);
    supplier2 = new MutableListSupplier(strings);
  }

  @Test
  public void should_have_the_expected_initial_size() {
    assertThat(supplier1.get()).hasSize(2);
    assertThat(supplier2.get()).hasSize(2);
  }

  @Test
  public void should_increase_the_size_of_the_list() {
    supplier1.get().add("baz");
    supplier2.get().add("qux");

    assertThat(supplier1.get()).hasSize(4).contains("foo", "bar", "baz", "qux");
    assertThat(supplier2.get()).hasSize(4).contains("foo", "bar", "baz", "qux");;
  }

}
