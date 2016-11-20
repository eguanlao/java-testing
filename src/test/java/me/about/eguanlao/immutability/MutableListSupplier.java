package me.about.eguanlao.immutability;

import java.util.List;
import java.util.function.Supplier;

class MutableListSupplier implements Supplier<List<String>> {

  private List<String> objects;

  MutableListSupplier(final List<String> objects) {
    this.objects = objects;
  }

  @Override
  public List<String> get() {
    return objects;
  }

}
