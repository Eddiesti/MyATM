package ru.otus;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class ATMTest {
    List list = new ArrayList();
    ATM atm = new ATM(list);

    @Test
    public void addCell() {
        atm.addCell(5, Cell.Nominal.FIVETHOUSAND);
        assertEquals(1, list.size());
    }

    @Test
    public void getBalance() {
        atm.addCell(5, Cell.Nominal.HOUNDRED);
        int actual = atm.getBalance();
        assertEquals(500, actual);
    }

    @Test
    public void withdraw() {
        atm.addCell(5, Cell.Nominal.THOUSAND);
        Cell actualCell = new Cell(5, Cell.Nominal.THOUSAND);
        int balance = atm.getBalance();
        atm.withdraw(5000);
        assertNotEquals(balance,atm.getBalance());
        assertEquals(5, actualCell.getCount());
        assertEquals(Cell.Nominal.THOUSAND, actualCell.getNominal());
    }
}