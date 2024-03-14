package med.voll.api.domain.dtos.medicos;

import med.voll.api.domain.models.Medico;

public record  DadosListagemMedicos (

        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
