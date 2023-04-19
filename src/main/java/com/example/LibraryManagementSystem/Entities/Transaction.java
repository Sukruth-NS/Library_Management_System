package com.example.LibraryManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "student")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssueOperation;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;
}
