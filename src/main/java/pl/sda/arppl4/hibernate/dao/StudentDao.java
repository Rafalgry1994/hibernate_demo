package pl.sda.arppl4.hibernate.dao;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.arppl4.hibernate.model.Student;
import pl.sda.arppl4.hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao implements IStudentDao {

    @Override
    public void dodajStudenta(Student student) {

        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();

        Transaction transaction = null;
        try (Session session = fabrykaPolaczen.openSession()) {

            transaction = session.beginTransaction();

            session.save(student);
            transaction.commit();

        } catch (SecurityException securityException) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void usunStudenta(Student student) {
        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();
        try (Session session = fabrykaPolaczen.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.remove(student);

            transaction.commit();
        }

    }

    @Override
    public Optional<Student> zwrocStudenta(Long id) {
        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();
        try(Session session = fabrykaPolaczen.openSession()){
            Student obiektStudent = session.get(Student.class, id);

            return Optional.ofNullable(obiektStudent);
        }
    }

    @Override
    public List<Student> zwrocListeStudentow() {
        List<Student> studentList = new ArrayList<>();

        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();
        try (Session session = fabrykaPolaczen.openSession()) {
            // Tworzymy zapytanie do bazy o obiekt typu student
            TypedQuery<Student> zapytanie = session.createQuery("from Student ", Student.class);
            List<Student> wynikZapytania = zapytanie.getResultList();

            studentList.addAll(wynikZapytania);
        } catch (SecurityException securityException) {
            System.err.printf("Błąd wczytania danych");
        }
        return studentList;
    }

    @Override
    public void updateStudent(Student student) {
        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();

        Transaction transaction = null;
        try (Session session = fabrykaPolaczen.openSession()) {

            transaction = session.beginTransaction();

            session.merge(student);
            transaction.commit();

        } catch (SecurityException securityException) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

