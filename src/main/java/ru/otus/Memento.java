package ru.otus;

public class Memento {
    private final Cell cell;

    public Cell getCell() {
        return cell;
    }

    public Memento(Cell cell) {
        this.cell = cell;
    }
}

