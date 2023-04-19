package com.example.LibraryManagementSystem.Services.impl;

import com.example.LibraryManagementSystem.DTOs.requestDTO.IssueBookRequestDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.IssueBookResponseDto;
import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Entities.Transaction;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Repositories.CardRepository;
import com.example.LibraryManagementSystem.Repositories.TransactionRepository;
import com.example.LibraryManagementSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card ;
        try {
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();

        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Card Id!!!");
        }
        transaction.setCard(card);
        Book book ;
        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id!!!");
        }
        transaction.setBook(book);

        if (card.getCardStatus() != CardStatus.ACTIVE){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not ACTIVE!!!");
        }

        if (book.isBookIsIssued() == true ){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not Available");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setBookIsIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBookList().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);//save card, boot & transaction

        //preparing response

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(card.getStudent().getMobNo());
        message.setSubject("Issue Book");

        String text = "Congrats!" + card.getStudent().getName() + "You have been issued the book" + book.getTitle();
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseDto;
    }
}
