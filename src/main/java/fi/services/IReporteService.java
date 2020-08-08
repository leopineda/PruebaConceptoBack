package fi.services;

import fi.dto.FiltroDTO;
import fi.dto.ReporteDTO;

import java.util.List;

/**
 * Nombre: ReporteService
 * Descripcion: Interface que define la operacion encargada de obtener los registros del reporte
 *
 * @author Leonel Pineda
 * Fecha: 06/08/2020
 * @version 0.1
 */
public interface IReporteService {
    /**
     * Metodo que obtiene la lista de registros obtenidos mediante los criterios de búsqueda
     * @return Lista con los registros obtenidos
     */
    List<ReporteDTO> getCalificaciones(FiltroDTO filtroDTO);
}
