package io.turntabl.execution.producerconsumer;

public interface Queue {
  void add(int num);
  int take();
}
