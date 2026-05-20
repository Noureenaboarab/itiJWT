package gov.iti.dto;


import gov.iti.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;

    private String userName;

    private String email;

//    private String password;

    private Date BD;

    private String job;

    private String creditNo;

    private BigDecimal creditLimit;

    private String phone;

    private UserRole role;


}
