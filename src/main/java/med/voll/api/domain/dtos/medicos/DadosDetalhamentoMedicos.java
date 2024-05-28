package med.voll.api.domain.dtos.medicos;

import med.voll.api.domain.models.Endereco;
import med.voll.api.domain.models.Medico;

public record DadosDetalhamentoMedicos(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
