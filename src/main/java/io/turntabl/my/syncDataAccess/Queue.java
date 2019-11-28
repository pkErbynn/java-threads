package io.turntabl.my.syncDataAccess;

public interface Queue {
  void add(int num);
  int take();
}
