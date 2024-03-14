package med.voll.api.domain.dtos.pacientes;

import med.voll.api.domain.dtos.enderecos.DadosEnderecos;

public record DadosAtualizacaoPacientes(Long id, String nome, String telefone, DadosEnderecos enderecos) {
}
