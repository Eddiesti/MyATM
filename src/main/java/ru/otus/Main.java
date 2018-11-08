package ru.otus;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(new ArrayList<>());
        atm.addCell(3, Cell.Nominal.THOUSAND);

        ATM atm2 = new ATM(new ArrayList<>());
        atm2.addCell(1, Cell.Nominal.FIVETHOUSAND);

        DepartamentImpl departament = new DepartamentImpl(new ArrayList<>());
        departament.addATM(atm);
        departament.addATM(atm2);
        System.out.println(atm.getBalance() + " atm before");
        atm.withdraw(1000);
        System.out.println(atm.getBalance() + " atm after");
        System.out.println(atm2.getBalance() + " atm2 before");
        atm2.withdraw(5000);
        System.out.println(atm2.getBalance() + " atm1 before");
        System.out.println("before restore depart " + departament.balance());
        departament.restore();
        System.out.println("after restore depart  " + departament.balance());
        System.out.println(atm.getBalance() + " 1 atm after restore");
        System.out.println(atm2.getBalance() + " 2 atm after restore");
    }
}
