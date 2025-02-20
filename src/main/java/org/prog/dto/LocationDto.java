package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private StreetDto street;   // Вулиця
    private String city;        // Місто
    private String state;       // Штат
    private String country;     // Країна
    private String postcode;    // Поштовий індекс
    private CoordinatesDto coordinates;  // Координати
    private TimezoneDto timezone;        // Зміна типу timezone на TimezoneDto

}

