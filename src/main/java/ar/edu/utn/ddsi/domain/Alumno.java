package ar.edu.utn.ddsi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
public class Alumno {

    private String nombre;
    private String apellido;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, String legajo, Materia... materias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<Materia>();
        Collections.addAll(this.materiasAprobadas, materias);
    }
}
