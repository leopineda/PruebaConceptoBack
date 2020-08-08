package fi.dao;

import fi.dto.ReporteDTO;
import fi.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Query("SELECT new fi.dto.ReporteDTO(c.nombre, 'grupo', 'materia', c.semestre.clave, 'alumno', 'cuenta', 9.8) FROM Carrera c WHERE c.id = :idCarrera")
    List<ReporteDTO> findAllByFiter(@Param("idCarrera") int idCarrera);
}
