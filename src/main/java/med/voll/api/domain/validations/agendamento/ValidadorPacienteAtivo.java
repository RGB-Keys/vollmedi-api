package med.voll.api.domain.validations.agendamento;

import med.voll.api.domain.dtos.consultas.DadosAgendamentoConsultas;
import med.voll.api.domain.repositories.PacienteRepository;
import med.voll.api.infrastructure.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo {
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsultas dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }

}
