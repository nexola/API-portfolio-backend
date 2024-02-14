package com.nexola.apiportfolio.dto;

import com.nexola.apiportfolio.services.validations.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@UserInsertValid
public class UserInsertDTO extends UserMinDTO {
    @NotBlank(message = "Campo obrigatório")
    @Size(min = 8, message = "A senha precisa ter pelo menos 8 caracteres")
    private String password;

    UserInsertDTO() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
