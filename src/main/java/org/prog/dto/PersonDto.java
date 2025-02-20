package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private NameDto name;  // Ім'я
    private LocationDto location;
    private String gender;
    private String nat;

}
