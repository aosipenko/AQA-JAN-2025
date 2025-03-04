package api.serialization;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//dto- data transfer object
public class ResultsDto {
    public List<AddressDto> results;
}
