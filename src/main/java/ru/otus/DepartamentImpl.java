package ru.otus;

import java.util.List;

public class DepartamentImpl implements Departament {
    public List<ATM> getAtms() {
        return atms;
    }

    public void setAtms(List<ATM> atms) {
        this.atms = atms;
    }

    private List<ATM> atms;
    private Caretaker caretaker = new Caretaker();

    public DepartamentImpl(List<ATM> atms) {
        this.atms = atms;
    }

    @Override
    public void addATM(ATM atm) {
        caretaker.add(atm.getCell().saveToMemento());
        atms.add(atm);
    }

    @Override
    public int size() {
        return atms.size();
    }

    @Override
    public int balance() {
        int sum = 0;
        for (ATM atm : atms) {
            int balance = atm.getBalance();
            sum += balance;
        }
        return sum;
    }

    public void restore() {
        for (int i = 0; i < caretaker.mementoList.size(); i++) {
            Memento memento = caretaker.get(i);
            atms.get(i).getCell().restoreFromMemento(memento);
        }
    }
}
