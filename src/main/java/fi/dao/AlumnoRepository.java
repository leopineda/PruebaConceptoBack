package fi.dao;

import fi.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Nombre: AlumnoRepository
 * Descripcion: Repositorio que realiza las consultas sobre la entidad {@link Alumno}
 *
 * @author Leonel Pineda
 * Fecha: 06/08/2020
 * @version 0.1
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    /**
     * Metodo que obtiene el listado de los catalogos activos registrados en el sistema.
     * @return List<Catalogo> Lista con los catalogos activos registrados en el sistema.
     */
    @Query("SELECT a.id, a.nombres, a.numeroCuenta FROM Alumno a WHERE a.id = 1")
    List<Object[]> findAllByFiter();
}
