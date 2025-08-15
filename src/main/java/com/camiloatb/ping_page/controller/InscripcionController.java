package com.camiloatb.ping_page.controller;

import com.camiloatb.ping_page.domain.Inscripcion;
import com.camiloatb.ping_page.domain.InscripcionRegistro;
import com.camiloatb.ping_page.domain.InscripcionRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class InscripcionController {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Transactional
    @PostMapping("/inscripcion")
    public ResponseEntity<Void> registrarGmail(@RequestBody @Valid InscripcionRegistro inscripcionRegistro, UriComponentsBuilder uriComponentsBuilder){ // @RequestBody @ModelAttribute
        var email = new Inscripcion(inscripcionRegistro);
        inscripcionRepository.save(email);
        var uri = uriComponentsBuilder.path("/inscripcion/{id}")
                .buildAndExpand(email.getId())
                .toUri();

        return  ResponseEntity.created(uri).build();
    }
}
