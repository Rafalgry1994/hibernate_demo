package pl.sda.arppl4.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity //encja = rekord = instancja= wpis w bazie
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto_increment
    private Long id;

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String indexNumber;

}
