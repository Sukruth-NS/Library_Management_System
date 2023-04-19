package com.example.LibraryManagementSystem.DTOs.responseDTO;

import com.example.LibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CardResponseDto {
    private int id;

    private Date issueDate;

    private Date updateDate;

    private CardStatus cardStatus ;

    private String validTill;
}
