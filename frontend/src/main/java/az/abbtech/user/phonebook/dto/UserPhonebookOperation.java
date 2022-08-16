package az.abbtech.user.phonebook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPhonebookOperation {

    private Long user_id;
    private String operation_type;
    private String operation_status;

}
