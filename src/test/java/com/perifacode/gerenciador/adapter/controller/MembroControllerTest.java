package com.perifacode.gerenciador.adapter.controller;

import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.perifacode.gerenciador.GerenciadorApplication;
import com.perifacode.gerenciador.GerenciadorApplicationTest;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = GerenciadorApplication.class
)
@AutoConfigureMockMvc
class MembroControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @ParameterizedTest(name = "{0} deve retornar {2}")
  @DisplayName("testando POST /membros")
  @MethodSource("incluirArgs")
  void incluir(String descricao,
               ObjectNode input,
               HttpStatus expectedStatus ) throws Exception {
    mockMvc.perform(post("/membros")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(input)))
        .andDo(print())
        .andExpect(status().is(expectedStatus.value()));
  }

  public static Stream<Arguments> incluirArgs(){
    JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
    return Stream.of(
        Arguments.of(
            "deve cadastrar um membro quando passar todos os parametros validos",
            jsonNodeFactory
                .objectNode().put("email", "dearrudam@gmail.com")
                .put("usuario", "Maximillian")
                .put("aceitePolitica", true)
                .putPOJO("interesses", Arrays.asList("java","spring"))
                .put("ativo", true),
            HttpStatus.OK
        ),
        Arguments.of(
            "não deve cadastrar um membro quando passar email for inválido",
            jsonNodeFactory
                .objectNode().put("email", "dearrudamgmail.com")
                .put("usuario", "Maximillian")
                .put("aceitePolitica", true)
                .putPOJO("interesses", Arrays.asList("java","spring"))
                .put("ativo", true),
            HttpStatus.BAD_REQUEST
        )
    );

  }
}