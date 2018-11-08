package ru.otus;
public class Memento {
    private final int count;
    private final Cell.Nominal nominal;

    public int getCount() {
        return count;
    }

    public Cell.Nominal getNominal() {
        return nominal;
    }

    public Memento(int count, Cell.Nominal nominal) {
        this.count = count;
        this.nominal = nominal;
    }
}
