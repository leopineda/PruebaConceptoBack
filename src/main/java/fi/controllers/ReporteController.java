package fi.controllers;

import fi.dto.ErrorResponse;
import fi.dto.FiltroDTO;
import fi.dto.ReporteDTO;
import fi.services.IReporteService;
import fi.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Nombre: ReporteController
 * Descripcion: Clase que expone el servicio REST para la Gestión de Reportes
 *
 * @author Leonel Pineda
 * Fecha: 06/08/2020
 * @version 0.1
 */
@RestController
@RequestMapping("/reporte")
@Api(value = "Servicio que permite obtener los registros para generar un reporte.", produces = MediaType.APPLICATION_JSON_VALUE,  protocols = "http")
public class ReporteController {
    /**
     * Bean de la capa service para obtener los resultados
     */
    @Autowired
    private IReporteService ReporteService;

    /**
     * Bean de la fabrica de instancias
     */
    @Autowired
    BeanFactory beanFactory;

    /**
     * Instancia que registra los eventos en la bitacora
     */
    private final Logger log = LoggerFactory.getLogger(ReporteController.class);

    /**
     * Mensaje que sera enviado si se recuperaron los registros correctamente
     */
    private static final String MSG_SUCCESS = "Registros recuperados correctamente.";

    /**
     * Metodo que expone la operacion de servicio para recuperar los registros mediante criterios de búsqueda.
     * @param filtro Criterios de búsqueda
     * @return Response Objeto con la informacion obtenida.
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod ="GET", value = "Regresa la información de las calificaciones obtenidas.")
    @ApiResponses({ @ApiResponse(code = 200, response = Response.class, message = "Registros obtenidos"),
                    @ApiResponse(code = 400, response = ErrorResponse.class, message = "Parámetros inválidos."),
                    @ApiResponse(code = 404, response = ErrorResponse.class, message = "No existen registros para el catalogo especificado"),
                    @ApiResponse(code = 500, response = ErrorResponse.class, message = "Error no esperado") })
    public Response get(@RequestBody FiltroDTO filtro) {
        log.debug("Entrando a operacion de servicio ReporteController.get()...");

        log.debug("Intentando obtener el listado de registros para los criterios de búsqueda {}...");
        List<ReporteDTO> reporteDTO = ReporteService.getCalificaciones(filtro);

        log.debug("Regresando instancia Response con la respuesta obtenida: {}...", reporteDTO);
        return beanFactory.getBean(Response.class, HttpStatus.OK.toString(), MSG_SUCCESS, reporteDTO);
    }
}
