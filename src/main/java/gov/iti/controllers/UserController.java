package gov.iti.controllers;

import gov.iti.entity.User;
import gov.iti.repo.UserRepo;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Customer", description = "Customer management")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @PreAuthorize("hasRole('USER')")
    @PostAuthorize("returnObject.body.userName == authentication.principal")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/users/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") @Min(1) Long id) {

        //get current user auth principal
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("principal: "+((String) principal));
        User user = userRepo.findById(id).get();
//        user.getUserName()
        return ResponseEntity.ok(user);
    }
    @PreAuthorize("hasAuthority('course:write')")
//    @Secured("ROLE_USER")
//    @RolesAllowed("USER")
    @GetMapping(path = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepo.findAll();
        return ResponseEntity.ok(users);
    }
}
