package med.voll.api.domain.dtos.consultas;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dtos.medicos.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultas(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime data,
        Especialidade especialidade) {
}
