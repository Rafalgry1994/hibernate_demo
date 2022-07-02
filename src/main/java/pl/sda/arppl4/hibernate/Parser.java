package pl.sda.arppl4.hibernate;

import pl.sda.arppl4.hibernate.dao.StudentDao;
import pl.sda.arppl4.hibernate.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Parser {
    private Scanner scanner;
    private StudentDao studentDao;

    public void działaj() {
        String linia;
        do {
            System.out.printf("Wpisz komendę");
            linia = scanner.nextLine();
            if (linia.equals("dodaj")) {
                System.out.printf("Podaj imię");
                String imie = scanner.nextLine();
                System.out.printf("Podaj nazwisko");
                String nazwisko = scanner.nextLine();
                System.out.printf("Podaj nrIndeksu");
                String nrIndeksu = scanner.nextLine();
                Student student = new Student(null, nrIndeksu, nazwisko, LocalDate.now(), imie);
                studentDao.dodajStudenta(student);
            } else if (linia.equals("list")) {

            }
        } while (!linia.equals("quit"));
    }
}
