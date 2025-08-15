package com.camiloatb.ping_page.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "formulario")
@Entity(name = "Inscripcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para crear automáticamente
    private Long id;
    @Column(name = "correo")
    private String email;
    @Column(name = "fecha_de_ingreso")
    private LocalDateTime fechaDeIngreso;

    public Inscripcion(InscripcionRegistro registro) {
        this.email = registro.correo();
    }

    @PrePersist
    public void prePersist(){
        this.fechaDeIngreso = LocalDateTime.now();
    }
}
