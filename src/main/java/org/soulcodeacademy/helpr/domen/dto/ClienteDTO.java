package org.soulcodeacademy.helpr.domen.dto;

import javax.validation.constraints.NotBlank;

public class ClienteDTO extends UsuarioDTO {
    //  @NotNull(message = "Telefone é obrigatorio") // verifica se tem valor ou não
    @NotBlank(message = "Telefone é obrigatorio") // obrigado ter um valor dentro
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
