package gov.iti.mappers;

import gov.iti.dto.UserDTO;
import gov.iti.dto.UserSignUpDTO;
import gov.iti.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
    List<UserDTO> toUserDTOs(List<User> users);

    UserSignUpDTO toUserDTOFromSignUp(User user);
    User toUserFromSignUp(UserSignUpDTO userDTO);
}
