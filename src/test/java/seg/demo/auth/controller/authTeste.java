package seg.demo.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import seg.demo.config.jwt.JwtRequest;

/**
 *
 * @author juliano.hein
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class authTeste {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuthController authController;
    
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(WebApplicationContext context) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void autorizar() throws Exception {
        JwtRequest request = new JwtRequest();
        request.setUsername("julianoosmir");
        request.setSenha("123456");
        String jsonString = this.objectMapper.writeValueAsString(request);
        mockMvc.perform(post("/auth/signin")
                .contentType("application/json").content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void naoAutorizado() throws Exception {
        JwtRequest request = new JwtRequest();
        request.setUsername("julianoosmir");
        request.setSenha("1234");
        String jsonString = this.objectMapper.writeValueAsString(request);

        MvcResult resultPost = mockMvc.perform(post("/auth/signin")
                .contentType("application/json").content(jsonString))
                .andExpect(status().isOk()).andReturn();

//        Exception badCredentialsException   = objectMapper.readValue(resultPost
//                .getResponse().getContentAsString(), Exception.class);

        String retorno = resultPost.getResponse().getContentAsString();

     //   Assertions.assertEquals(Exception.class, resultPost.getResolvedException().getClass());
        Assertions.assertEquals(retorno, "CREDENCIAIS INVALIDAS");

    }
}
