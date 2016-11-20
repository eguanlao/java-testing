package me.about.eguanlao.immutability;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class ImmutableListSupplier implements Supplier<List<String>> {

  private List<String> objects;

  ImmutableListSupplier(final List<String> objects) {
    this.objects = new ArrayList<>(objects);
  }

  @Override
  public List<String> get() {
    return new ArrayList<>(objects);
  }

}

