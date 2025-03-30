package edu.icai.p4;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
public class Controlador {
    private final Map<String, Raza> razas = new HashMap<>();

    @PostMapping("/api/razas")
    @ResponseStatus(HttpStatus.CREATED)
    public Raza crea(@Valid @RequestBody Raza razaNueva) {
        if (razas.containsKey(razaNueva.nombre())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        razas.put(razaNueva.nombre(), razaNueva);
        return razaNueva;
    }

    @GetMapping("/api/razas/{nombre}")  //PARA HACER GET DE 1 RAZA
    public Raza raza(@PathVariable String nombre) {
        Raza raza = razas.get(nombre);
        if (raza == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return raza;
    }
    @GetMapping("/api/razas") //PARA HACER GET DE TODAS LAS RAZAS
    public Collection<Raza> razas() {
        return razas.values();
    }

    @PutMapping("/api/razas/{nombre}/tamaño/{tamaño}/altura/{altura}/peso/{peso}")
    public Raza modifica(@PathVariable String nombre,
                           @PathVariable String tamaño,
                           @PathVariable Integer altura,
                           @PathVariable Integer peso) {
        Raza razaActual = razas.get(nombre);
        if (razaActual == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Raza razaModificada =
                new Raza(nombre, tamaño, altura, peso);
        razas.put(nombre, razaModificada);
        return razaModificada;
    }

    @DeleteMapping("/api/razas/{nombre}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void elimina(@PathVariable String nombre) {
        if (!razas.containsKey(nombre)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        razas.remove(nombre);
    }
}
