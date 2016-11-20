package me.about.eguanlao.immutability;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class UnmodifiableListSupplier implements Supplier<List<String>> {

  private List<String> objects;

  public UnmodifiableListSupplier(final List<String> objects) {
    this.objects = Collections.unmodifiableList(objects);
  }

  @Override
  public List<String> get() {
    return objects;
  }

}
