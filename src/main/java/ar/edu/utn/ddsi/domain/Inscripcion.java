package ar.edu.utn.ddsi.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Inscripcion {
    private final Alumno alumno;
    private final List<Materia> materiasAInscribirse;

    public Inscripcion(Alumno alumno,Materia... materias) {
        this.alumno = alumno;
        this.materiasAInscribirse = new ArrayList<Materia>();
        Collections.addAll(materiasAInscribirse, materias);
    }

    public Boolean aprobada() {
        return materiasAInscribirse.stream()
                .allMatch(materia -> alumno.getMateriasAprobadas().containsAll(materia.getCorrelativas()));
    }

}
