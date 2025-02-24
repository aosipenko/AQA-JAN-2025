package api.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String firstName;
    private String lastName;
    private String city;
    private String nameOfStreet;
    private int numberOfStreet;
}
