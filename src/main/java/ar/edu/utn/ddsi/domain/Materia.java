package ar.edu.utn.ddsi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre,Materia ... materias) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>();
        Collections.addAll(correlativas, materias);
    }
}
