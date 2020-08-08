package fi.services.impl;

import fi.dao.AlumnoRepository;
import fi.dao.CarreraRepository;
import fi.dao.MateriaRepository;
import fi.dto.FiltroDTO;
import fi.dto.ReporteDTO;
import fi.model.Alumno;
import fi.services.IReporteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Nombre: ReporteServiceImpl
 * Descripcion: Clase que implementa la operacion que obtiene los registros de calificaciones
 *
 * @author Leonel Pineda
 * Fecha: 06/08/2020
 * @version 0.1
 */
@Service
@Transactional(readOnly = true, value = "transactionManager")
public class ReporteServiceImpl implements IReporteService {
    /**
     * Logger para el registro de actividad en la bitacora
     */
    private final Logger log = LoggerFactory.getLogger(ReporteServiceImpl.class);

    @Autowired
    private MateriaRepository materiaRepository;

    /**
     * Metodo que obtiene la lista de calificaciones segun los criterios de búsqueda
     * @return List<ReporteDTO> Lista con las calificaciones obtenidas
     */
    @Override
    public List<ReporteDTO> getCalificaciones(FiltroDTO filtroDTO) {
        log.info("Consultando registros de catalogos del sistema...");

        List<ReporteDTO> results = null;

        if(filtroDTO.getCarrera() == 0 || filtroDTO.getGrupo() == 0 || filtroDTO.getMateria() == 0 || filtroDTO.getSemestre() == 0)
            results = materiaRepository.todas();
        else
            results = materiaRepository.findAllByFilter(filtroDTO.getCarrera(), filtroDTO.getGrupo(), filtroDTO.getMateria(), filtroDTO.getSemestre(), filtroDTO.getAlumno());

        return results;
    }
}
