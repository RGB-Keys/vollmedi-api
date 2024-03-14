package med.voll.api.domain.validations.cancelamento;

import med.voll.api.domain.dtos.consultas.DadosCancelamentoConsultas;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsultas dados);

}
