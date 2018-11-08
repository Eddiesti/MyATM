package ru.otus;

import java.util.List;
import java.util.ArrayList;

public class Caretaker {
    List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

}
