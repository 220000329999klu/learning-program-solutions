package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@Import(GlobalExceptionHandler.class) // ✅ Needed if handler is in same package or external
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetUser_Found() throws Exception {
        when(userService.getUserById(1L)).thenReturn("John Doe");

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("John Doe"));
    }

    @Test
    void testGetUser_NotFound() throws Exception {
        when(userService.getUserById(2L)).thenThrow(new NoSuchElementException());

        mockMvc.perform(get("/users/2"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}