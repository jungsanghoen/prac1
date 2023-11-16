package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RequestDto {
    int hashid;
    String salt;
    String hash;
    String description;
    String passwd;
}
