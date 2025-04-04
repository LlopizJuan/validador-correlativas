import ar.edu.utn.ddsi.domain.Alumno;
import ar.edu.utn.ddsi.domain.Inscripcion;
import ar.edu.utn.ddsi.domain.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        algoritmos = new Materia("Algoritmos");
        paradigmas = new Materia("Paradigmas", algoritmos);
        disenio = new Materia("Diseño", paradigmas);
        ingles1 = new Materia("Ingles I");
        proyectoFinal = new Materia("Proyecto Final", ingles1,paradigmas,disenio);
    }

    @Test
    void testInscripcionAprobadaCuandoTieneTodasLasCorrelativas() {
        Alumno juan = new Alumno("Juan", "Perez", "12XXX", algoritmos, paradigmas);
        Inscripcion inscripcion = new Inscripcion(juan, disenio, ingles1);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    void testInscripcionRechazadaCuandoFaltanCorrelativas() {
        Alumno juan = new Alumno("Juan", "Perez", "12XXX", algoritmos);
        Inscripcion inscripcion = new Inscripcion(juan, disenio);
        assertFalse(inscripcion.aprobada());
    }


    @Test
    void testInscripcionRechazadaCuandoFaltanCorrelativas2() {
        Alumno juan = new Alumno("Juan", "Perez", "12XXX", disenio);
        Inscripcion inscripcion = new Inscripcion(juan, proyectoFinal, ingles1);
        assertFalse(inscripcion.aprobada());
    }
}