package com.Backend.Student_Library_Management_System.Service;

import com.Backend.Student_Library_Management_System.Enum.CardStatus;
import com.Backend.Student_Library_Management_System.Models.Card;
import com.Backend.Student_Library_Management_System.Models.Student;
import com.Backend.Student_Library_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        Card  card = new Card();
        student.setCard(card);
        card.setStudent(student);
        card.setCardStatus(CardStatus.ACTIVATED);
        studentRepository.save(student);
        return ("Student "+student.getName()+" Saved successfully along with the card");

    }

    public Student getStudent(int id) {
        return  studentRepository.getReferenceById(id);
    }
}
