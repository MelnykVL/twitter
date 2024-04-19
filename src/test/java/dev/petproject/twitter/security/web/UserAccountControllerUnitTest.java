package dev.petproject.twitter.security.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.petproject.twitter.security.usecase.RegisterUserAccountUseCase;
import dev.petproject.twitter.security.web.model.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserAccountControllerUnitTest {

  private MockMvc mockMvc;

  @Mock
  private RegisterUserAccountUseCase registerUserAccountUseCase;

  @InjectMocks
  private UserAccountController userAccountController;

  @BeforeEach
  void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(userAccountController)
        .build();
  }

  @Test
  void registerAccount_GivenValidRegisterRequest_ShouldReturnStatusCreated() throws Exception {
    // given
    RegisterRequest registerRequest = new RegisterRequest("test_user@gmail.com", "test_pass");

    doNothing().when(registerUserAccountUseCase)
        .register(registerRequest);

    ObjectMapper objectMapper = new ObjectMapper();
    byte[] registerRequestInBytes = objectMapper.writeValueAsBytes(registerRequest);

    // when
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(registerRequestInBytes))
        .andExpect(status().isCreated());

    // then
    verify(registerUserAccountUseCase, times(1)).register(registerRequest);
  }

  @Test
  void registerAccount_GivenInvalidRegisterRequest_ShouldReturnStatus400() throws Exception {
    // given
    RegisterRequest registerRequest = new RegisterRequest("not_mail", "test_pass");

    ObjectMapper objectMapper = new ObjectMapper();
    byte[] registerRequestInBytes = objectMapper.writeValueAsBytes(registerRequest);

    // when
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(registerRequestInBytes))
        .andExpect(status().is4xxClientError())
        .andReturn();
    Exception actualException = mvcResult.getResolvedException();

    // then
    assertNotNull(actualException);
    assertInstanceOf(MethodArgumentNotValidException.class, actualException);
    verify(registerUserAccountUseCase, never()).register(any());
  }
}