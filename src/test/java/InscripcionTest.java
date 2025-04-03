import ar.edu.utn.ddsi.domain.Alumno;
import ar.edu.utn.ddsi.domain.Inscripcion;
import ar.edu.utn.ddsi.domain.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InscripcionTest {

    Materia algoritmos;
    Materia paradigmas;
    Materia disenio;
    Materia ingles1;
    Materia proyectoFinal;

    @BeforeEach
    void setUp() {
        algoritmos = new Materia("Algoritmos", List.of());
        paradigmas = new Materia("Paradigmas", List.of(algoritmos));
        disenio = new Materia("Diseño", List.of(paradigmas));
        ingles1 = new Materia("Ingles I", List.of());
        proyectoFinal = new Materia("Proyecto Final", List.of(ingles1,paradigmas,disenio));
    }

    @Test
    void testInscripcionAprobadaCuandoTieneTodasLasCorrelativas() {
        Alumno alumno = new Alumno("Juan", "Perez", "12XXX", List.of(algoritmos, paradigmas));
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(disenio, ingles1));
        assertTrue(inscripcion.aprobada());
    }

    @Test
    void testInscripcionRechazadaCuandoFaltanCorrelativas() {
        Alumno alumno = new Alumno("Juan", "Perez", "12XXX", List.of(algoritmos));
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(disenio));
        assertFalse(inscripcion.aprobada());
    }


    @Test
    void testInscripcionRechazadaCuandoFaltanCorrelativas2() {
        Alumno alumno = new Alumno("Juan", "Perez", "12XXX", List.of(disenio));
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(proyectoFinal, ingles1));
        assertFalse(inscripcion.aprobada());
    }
}