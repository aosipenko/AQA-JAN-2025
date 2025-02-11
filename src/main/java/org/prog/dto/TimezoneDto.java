package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimezoneDto {

    private String offset;      // Зсув часового поясу
    private String description; // Опис часового поясу
}