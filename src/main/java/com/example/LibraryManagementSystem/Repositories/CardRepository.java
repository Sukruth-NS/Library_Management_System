package com.example.LibraryManagementSystem.Repositories;

import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
