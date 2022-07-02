package pl.sda.arppl4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.arppl4.hibernate.dao.StudentDao;
import pl.sda.arppl4.hibernate.model.Student;
import pl.sda.arppl4.hibernate.util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // tworzymy narzędzie do konfiguracji hibernate
//        Student student = new Student(null, "Pawel", "Gawel", "123", LocalDate.now());

        // Tworzymy DATA ACCESS OBJECT
        StudentDao dao = new StudentDao();

//        dao.dodajStudenta(student);

//        List<Student> lista = dao.zwrocListeStudentow();
//        System.out.println("Studenci: " + lista);
//
//        for (Student studencik : lista) {
//            if (studencik.getId() == 4) {
//                lista.remove(studencik);
//                dao.usunStudenta(studencik);
//                break;
//            }
//        }

        Optional<Student> optionalStudent = dao.zwrocStudenta(3L);
        if (optionalStudent.isPresent()) {
//            Student studentAktualizowany = new Student(3L, "Gawełek", "Pawełek", "555", LocalDate.now());
            Student studentAktualizowany = optionalStudent.get();
            studentAktualizowany.setName("Gawełek");
            studentAktualizowany.setSurname("Pawełek");
            studentAktualizowany.setIndexNumber("555");

            dao.updateStudent(studentAktualizowany);
        }

    }
}
