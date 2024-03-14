package med.voll.api.domain.dtos.consultas;

import com.fasterxml.jackson.annotation.JsonAlias;
import med.voll.api.domain.models.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultas(
        Long id,
        @JsonAlias({"id_medico","medico_id","MedicoId"})
        Long idMedico,
        @JsonAlias({"id_paciente","paciente_id","PacienteId"})
        Long idPaciente,
        @JsonAlias({"Data"})
        LocalDateTime data) {
    public DadosDetalhamentoConsultas(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
