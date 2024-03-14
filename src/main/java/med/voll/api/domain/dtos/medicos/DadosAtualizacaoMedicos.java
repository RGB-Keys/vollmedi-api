package med.voll.api.domain.dtos.medicos;

import med.voll.api.domain.dtos.enderecos.DadosEnderecos;

public record DadosAtualizacaoMedicos(Long id, String nome, String telefone, DadosEnderecos enderecos) {
}
