package gov.iti.controllers;

import gov.iti.config.SecConfig;
import gov.iti.entity.User;
import gov.iti.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
    @Import(SecConfig.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserRepo userRepo;

    @MockitoBean
    DataSource dataSource;


    @Test
    @WithMockUser(username = "user", roles = {"ADMIN"})
    void shouldntAllowAdminRole() throws Exception {

        User mockUser = new User(); // set fields if needed
        when(userRepo.findById(any())).thenReturn(Optional.of(mockUser));

        mockMvc.perform(get("/1"))
                .andExpect(status().isForbidden());
    }
    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldAllowUserRole() throws Exception {

        User mockUser = new User(); // set fields if needed
        when(userRepo.findById(any())).thenReturn(Optional.of(mockUser));

        mockMvc.perform(get("/1"))
                .andExpect(status().isOk());

//        mockMvc.perform(get("/api/secure")
//                        .with(jwt().jwt(builder -> builder.claim("sub", "testUser"))))
//                .andExpect(status().isOk());
    }
}