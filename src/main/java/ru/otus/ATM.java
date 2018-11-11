package ru.otus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ATM {
    private static Logger logger = LoggerFactory.getLogger(ATM.class);
    private Cell cell;
    private List<Cell> cells;

    public ATM(List<Cell> cells) {
        this.cells = cells;
    }


    public Cell getCell() {
        return cell;
    }

    public void addCell(int amount, Cell.Nominal nominal) {
        if (nominal == null) {
            throw new IllegalArgumentException("Nominal can't be null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be > 0");
        }

        cell = new Cell(amount, nominal);
        cells.add(cell);
    }

    public Map<Cell.Nominal, java.lang.Integer> withdraw(int amount) {
        Map<Cell.Nominal, java.lang.Integer> data = new HashMap<>();
        int i = 1;
        if (amount > getBalance()) {
            throw new IllegalArgumentException("There is not so much money in your account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be > 0");
        }
        i = amount / Cell.Nominal.FIVETHOUSAND.value();
        for (Cell cell : cells) {
            if (cell.getNominal() == Cell.Nominal.FIVETHOUSAND) {
                if (i <= cell.getCount()) {
                    amount -= i * Cell.Nominal.FIVETHOUSAND.value();
                    if (i != 0) {
                        cell.withdrawCount(i);
                        data.put(Cell.Nominal.FIVETHOUSAND, i);
                        logger.debug("Five thousand rubles " + i);
                    }
                } else throw new IllegalArgumentException("There are no certain bills");
            }
        }

        i = amount / Cell.Nominal.THOUSAND.value();
        for (Cell cell : cells) {
            if (cell.getNominal() == Cell.Nominal.THOUSAND) {
                if (i <= cell.getCount()) {
                    amount -= i * Cell.Nominal.THOUSAND.value();
                    if (i != 0) {
                        cell.withdrawCount(i);
                        data.put(Cell.Nominal.THOUSAND, i);
                        logger.debug("Thousand rubles " + i);
                    }
                } else throw new IllegalArgumentException("There are no certain bills");
            }
        }

        i = amount / Cell.Nominal.FIVE_HOUNDRED.value();
        for (Cell cell : cells) {
            if (cell.getNominal() == Cell.Nominal.FIVE_HOUNDRED) {
                if (i <= cell.getCount()) {
                    amount = amount - i * Cell.Nominal.FIVE_HOUNDRED.value();
                    if (i != 0) {
                        cell.withdrawCount(i);
                        data.put(Cell.Nominal.FIVE_HOUNDRED, i);
                        logger.debug("Five houndred rubles " + i);
                    }
                } else throw new IllegalArgumentException("There are no certain bills");
            }

        }
        i = amount / Cell.Nominal.HOUNDRED.value();
        for (Cell cell : cells) {
            if (cell.getNominal() == Cell.Nominal.HOUNDRED) {
                if (i <= cell.getCount()) {
                    amount = amount - i * Cell.Nominal.HOUNDRED.value();
                    if (i != 0) {
                        cell.withdrawCount(i);
                        data.put(Cell.Nominal.HOUNDRED, i);
                        logger.debug("Houndred rubles " + i);
                    }
                } else throw new IllegalArgumentException("There are no certain bills");
            }
        }

        i = amount / Cell.Nominal.FIFTY.value();
        for (Cell cell : cells) {
            if (cell.getNominal() == Cell.Nominal.FIFTY) {
                if (i <= cell.getCount()) {
                    amount = amount - i * Cell.Nominal.FIFTY.value();
                    if (i != 0) {
                        cell.withdrawCount(i);
                        data.put(Cell.Nominal.FIFTY, i);
                        logger.debug("Fifty rubles " + i);
                    }
                } else throw new IllegalArgumentException("There are no certain bills");
            }
        }

        i = amount / Cell.Nominal.TEN.value();
        for (Cell cell : cells) {
            if (cell.getNominal() == Cell.Nominal.TEN) {
                if (i <= cell.getCount()) {
                    amount = amount - i * Cell.Nominal.TEN.value();
                    if (i != 0) {
                        cell.withdrawCount(i);
                        data.put(Cell.Nominal.TEN, i);
                        logger.debug("Ten  rubles " + i);
                    }
                } else {
                    throw new IllegalArgumentException("There are no certain bills");
                }
            }
        }
        return data;
    }

    public int getBalance() {
        int sum = 0;
        for (Cell cell : cells) {
            int balance = cell.getBalance();
            sum += balance;
        }
        return sum;
    }

    public void restore(List<ATM> atms, Caretaker caretaker, int i) {
        Memento memento = caretaker.get(i);
        atms.get(i).getCell().restoreFromMemento(memento);
    }
}