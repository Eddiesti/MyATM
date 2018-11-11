package ru.otus;

public class Cell {
    private int count;
    private Nominal nominal;

    public Memento saveToMemento() {
        return new Memento(new Cell(count, nominal));
    }

    public void restoreFromMemento(Memento memento) {
        this.count = memento.getCell().getCount();
        this.nominal = memento.getCell().getNominal();
    }

    public enum Nominal {
        TEN(10), FIFTY(50), HOUNDRED(100), FIVE_HOUNDRED(500), THOUSAND(1000), FIVETHOUSAND(5000);

        private final int value;

        Nominal(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    public Cell(int count, Nominal nominal) {
        this.count = count;
        this.nominal = nominal;
    }

    public int getCount() {
        return count;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public void withdrawCount(int count) {
        this.count -= count;
    }

    public int getBalance() {
        return count * nominal.value;
    }

}


