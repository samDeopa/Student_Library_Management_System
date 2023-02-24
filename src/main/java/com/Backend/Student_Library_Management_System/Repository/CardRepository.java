package com.Backend.Student_Library_Management_System.Repository;

import com.Backend.Student_Library_Management_System.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
