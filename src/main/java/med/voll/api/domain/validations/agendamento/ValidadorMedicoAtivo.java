package med.voll.api.domain.validations.agendamento;

import med.voll.api.domain.dtos.consultas.DadosAgendamentoConsultas;
import med.voll.api.domain.repositories.MedicoRepository;
import med.voll.api.infrastructure.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo {
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsultas dados){
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico");
        }
    }

}
