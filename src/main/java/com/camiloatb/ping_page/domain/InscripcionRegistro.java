package com.camiloatb.ping_page.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InscripcionRegistro(
        @Email
        @NotBlank
        String correo
) {
}
