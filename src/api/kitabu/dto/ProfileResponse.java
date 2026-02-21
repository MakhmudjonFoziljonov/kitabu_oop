package api.kitabu.dto;

import java.util.UUID;

public record ProfileResponse(
        UUID id,
        String name,
        String surname
)

{
 public    record ProfileShort(
            String name,
            String surname,
            String phone
    ){
    }
}
