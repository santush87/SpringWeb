package com.aleksandrov.battleShips.models.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class CreateShipDto {
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    private long health;

    @Positive
    private long power;

    @PastOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate created;

    @Positive
    private int category = -1;


}
