package med.voll.api.domain.dtos.pacientes;

import med.voll.api.domain.models.Paciente;

public record DadosListagemPacientes(
        String nome,
        String email,
        String cpf
) {
    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
