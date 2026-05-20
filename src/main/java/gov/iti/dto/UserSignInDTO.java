package gov.iti.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignInDTO {

    @NotBlank(message = "userName cannot be blank")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    private String password;


}