package med.voll.api.domain.validations.agendamento;

import med.voll.api.domain.dtos.consultas.DadosAgendamentoConsultas;
import med.voll.api.domain.repositories.ConsultaRepository;
import med.voll.api.infrastructure.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsultas dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }

}
