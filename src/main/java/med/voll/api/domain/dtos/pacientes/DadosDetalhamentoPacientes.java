package med.voll.api.domain.dtos.pacientes;

import med.voll.api.domain.models.Endereco;
import med.voll.api.domain.models.Paciente;

public record DadosDetalhamentoPacientes(Long id, String nome, String telefone, Endereco endereco, String cpf) {
    public DadosDetalhamentoPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getEndereco(), paciente.getCpf());
    }
}
