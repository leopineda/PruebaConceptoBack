package fi.dao;

import fi.dto.ReporteDTO;
import fi.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

    @Query("SELECT new fi.dto.ReporteDTO(c.nombre, g.clave, m.nombre, c.semestre.clave, concat(a.nombres, ' ', a.apellidoPaterno, ' ', a.apellidoMaterno), " +
            "a.numeroCuenta, ag.calificacion) " +
            "FROM Materia m, fi.model.Grupo g, fi.model.PlanMateria pm, fi.model.PlanEstudios pe, fi.model.Carrera c, " +
            "fi.model.AlumnoGrupo ag, fi.model.Alumno a " +
            "WHERE g.materia.id = m.id " +
            "AND pm.materia.id = m.id " +
            "AND pm.planEstudios.id = pe.id " +
            "AND pe.carrera.id = c.id " +
            "AND ag.grupo.id = g.id " +
            "AND ag.alumno.id = a.id " +
            "AND c.id = :idCarrera " +
            "AND g.id = :idGrupo " +
            "AND m.id = :idMateria " +
            "AND c.semestre.id = :idSemestre " +
            "AND (concat(a.nombres, ' ', a.apellidoPaterno, ' ', a.apellidoMaterno) LIKE %:alumno% " +
            "OR a.numeroCuenta LIKE %:alumno%)")
    List<ReporteDTO> findAllByFilter(@Param("idCarrera") int idCarrera,
            @Param("idGrupo") int idGrupo,
            @Param("idMateria") int idMateria,
            @Param("idSemestre") int idSemestre,
            @Param("alumno") String alumno);

    @Query("SELECT new fi.dto.ReporteDTO(c.nombre, g.clave, m.nombre, c.semestre.clave, concat(a.nombres, ' ', a.apellidoPaterno, ' ', a.apellidoMaterno), " +
            "a.numeroCuenta, ag.calificacion) " +
            "FROM Materia m, fi.model.Grupo g, fi.model.PlanMateria pm, fi.model.PlanEstudios pe, fi.model.Carrera c, " +
            "fi.model.AlumnoGrupo ag, fi.model.Alumno a " +
            "WHERE g.materia.id = m.id " +
            "AND pm.materia.id = m.id " +
            "AND pm.planEstudios.id = pe.id " +
            "AND pe.carrera.id = c.id " +
            "AND ag.grupo.id = g.id " +
            "AND ag.alumno.id = a.id ")
    List<ReporteDTO> todas();
}
