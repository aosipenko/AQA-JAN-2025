package api.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    public StreetDto street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    public CoordinatesDto coordinates;
    public TimezoneDto timezone;
}
