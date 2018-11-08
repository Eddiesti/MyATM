package ru.otus;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DepartamentImplTest {
    DepartamentImpl departament = new DepartamentImpl(new ArrayList<>());
    ATM atm = new ATM(new ArrayList<>());
    ATM atm2 = new ATM(new ArrayList<>());

    @Before
    public void init() {
        atm.addCell(2, Cell.Nominal.FIVETHOUSAND);
        departament.addATM(atm);
        atm2.addCell(2, Cell.Nominal.THOUSAND);
        departament.addATM(atm2);
    }

    @Test
    public void addATM() {
        int actual = 2;
        assertEquals(departament.size(), actual);
    }

    @Test
    public void balance() {
        int actualBalace = 12000;
        assertEquals(departament.balance(), actualBalace);
    }

    @Test
    public void restore() {
        int actual = departament.balance();
        atm.withdraw(5000);
        atm2.withdraw(1000);
        departament.restore();
        assertEquals(departament.balance(), actual);
    }
}