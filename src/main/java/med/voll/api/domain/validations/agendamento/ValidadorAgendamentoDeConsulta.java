package med.voll.api.domain.validations.agendamento;

import med.voll.api.domain.dtos.consultas.DadosAgendamentoConsultas;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsultas dados);

}
