package med.voll.api.controllers;

import med.voll.api.domain.dtos.consultas.DadosAgendamentoConsultas;
import med.voll.api.domain.dtos.consultas.DadosDetalhamentoConsultas;
import med.voll.api.domain.dtos.medicos.Especialidade;
import med.voll.api.domain.services.ConsultaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultasControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoConsultas> dadosAgendamentoConsultasJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoConsultas> dadosDetalhamentoConsultasJson;

    @MockBean
    private ConsultaService consultaService;

    @Test
    @DisplayName("Deveria devolver http 400 quando infomacoes estao invalidas")
    @WithMockUser
    void agendar_cenario1() throws Exception {
        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();
        var resultado = assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informações estão validas")
    @WithMockUser
    void agendar_cenario2() throws Exception {
        var data = LocalDateTime.now().plusHours(1);
        var especialidade = Especialidade.CARDIOLOGIA;
        var dadosDetalhamento = new DadosDetalhamentoConsultas(null, 2l, 5l, data);
        when(consultaService.agendar(any())).thenReturn(dadosDetalhamento);

        var response = mvc
                .perform(
                        post("/consultas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosAgendamentoConsultasJson.write(
                                        new DadosAgendamentoConsultas(2l, 5l, data, especialidade)
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoConsultasJson.write(
                        dadosDetalhamento
                ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);

    }

}