package com.management.apollonia_dental.exceptions;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
public class ApiError {

    private String message;

    private String description;

    private LocalDate date;

}
