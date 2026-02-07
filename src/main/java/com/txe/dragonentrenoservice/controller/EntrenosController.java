package com.txe.dragonentrenoservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.txe.dragonentrenoservice.dto.EntrenosDto;
import com.txe.dragonentrenoservice.dto.EntrenosSearchDto;
import com.txe.dragonentrenoservice.service.EntrenosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/entrenos")
@Tag(name = "entrenos", description = "CRUD colección Mongo entrenos")
public class EntrenosController {
	
	private static final Logger LOG = LoggerFactory.getLogger(EntrenosController.class);

    @Autowired
    EntrenosService entrenosService;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "/ping")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "ping", description = "Ver si el servicio está operativo")
    @ApiResponses({
 		    @ApiResponse(responseCode = "204", description = "Servicio operativo"),
            @ApiResponse(responseCode = "400", description = "Algún error debido a los parámetros al intentar crear una sesión, ver el mensaje"),
            @ApiResponse(responseCode = "404", description = "Algún recurso no encontrado al intentar crear una sesión, ver el mensaje"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Void> ping() throws Exception {
    	LOG.info("EntrenosController - ping");
    	    	
    	return ResponseEntity.noContent().build(); // 204
    }
   

    /***
	 * Esta operación crea un recurso sesión dentro de la BBDD MongoDB.
	 * @param sesionDto Objeto sesión que se va a crear en la BBDD MongoDB
	 * @return
	 * @throws Exception
	 */
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crea una sesión nueva", description = "Esta operación crea un recurso sesión dentro de la BBDD MongoDB.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Sesión creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Algún error debido a los parámetros al intentar crear una sesión, ver el mensaje"),
            @ApiResponse(responseCode = "404", description = "Algún recurso no encontrado al intentar crear una sesión, ver el mensaje"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Void> post(@RequestBody @Valid EntrenosDto sesionDto) throws Exception {
    	LOG.info("EntrenosController - post: Creando sesión con datos: {}", sesionDto);
    	entrenosService.create(sesionDto);
    	LOG.info("EntrenosController - post: Sesión creada correctamente");
    	
    	return ResponseEntity.noContent().build(); // 204
    }

    /***
     * Esta operación obtiene un recurso sesion de la BBDD MongoDB a partir de su identificador único.
     * @param sesionId
     * @return
     * @throws Exception
     */
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id_sesion}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obtiene una sesion", description = "Esta operación obtiene un recurso sesion de la BBDD MongoDB a partir de su identificador único")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "sesion obtenida correctamente"),
            @ApiResponse(responseCode = "400", description = "Algún error debido a los parámetros al intentar obtener una sesion, ver el mensaje"),
            @ApiResponse(responseCode = "404", description = "Algún recurso no encontrado al intentar obtener una sesion, ver el mensaje"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public EntrenosDto get(@PathVariable(value="id_sesion") String sesionId) throws Exception {
    	EntrenosDto response = entrenosService.findById(sesionId);
        
        return response;
    }

    /**
     * Esta operación modifica un recurso sesion entero a partir de su identificador único..
     * @param sesionId Identificador unico de la sesion que vamos a actualizar
     * @param cart Objeto sesion que se guardara en la sesion con el identificador sesionId
     * @return sesion actualizada
     * @throws TpvResponseException excepción del tipo TpvResponseException
     */
    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id_sesion}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Actualiza una sesion", description = "Esta operación reemplaza un recurso de sesion por otro pasado por parámetro en la BBDD de Mongo DB. Por parámetro se recibe el identificador único de la sesion y el por el cuerpo el recurso sesion que se quiere almacenar en su lugar. Si la sesion no existe, se devolverá un error.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "sesion actualizada correctamente"),
            @ApiResponse(responseCode = "400", description = "Algún error debido a los parámetros al intentar actualizar una sesion, ver el mensaje"),
            @ApiResponse(responseCode = "404", description = "Algún recurso no encontrado al intentar actualizar una sesion, ver el mensaje"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Void> put(@PathVariable(value="id_sesion") String sesionId,
                        			@RequestBody @Valid EntrenosDto sesionDto) throws Exception {
    	entrenosService.update(sesionId, sesionDto);
    	
    	return ResponseEntity.noContent().build(); // 204
    }
    
    /**
     * Esta operación elimina un recurso sesion de la colección sesions de MongoDB. Por parámetro se
     * recibe el identificador único de la sesion. Si la sesion no existe, se devolverá un error.
     * @param sesionId Identificador unico de la sesion que vamos a actualizar
     * @param repositorio - Parámetro que si es distinto de null indicará que el repositorio no es el convencional al utilizado
     * en la Venta estandar:
     * 		 AMV - sesion
     * 		 Enjoy&GO sesion_enjoy
     * @throws TpvResponseException excepción del tipo TpvResponseException
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			       value = "/{id_sesion}")
    @Operation(summary = "Elimina una sesion", description = "Esta operación elimina un recurso sesion de la colección sesions de MongoDB. Por parámetro se recibe el identificador único de la sesion. Si la sesion no existe, se devolverá un error.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "sesion borrada correctamente"),
            @ApiResponse(responseCode = "400", description = "Algún error debido a los parámetros al intentar borrar una sesion, ver el mensaje"),
            @ApiResponse(responseCode = "404", description = "Algún recurso no encontrado al intentar borrar una sesion, ver el mensaje"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Void> delete(@PathVariable(value="id_sesion") String sesionId) throws Exception {
    	entrenosService.delete(sesionId);
        
    	return ResponseEntity.noContent().build(); // 204
    }

    
    /***
	 * Esta operación busca sesions de la BBDD MongoDB que cumplan los parámetros de entrada.
	 * @param filterParams Parámetros de búsqueda
	 * @return Listado de sesions que cumplen los parámetros de búsqueda
	 * @throws Exception
	 */
    @PostMapping( value = "/search" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obtiene un listado de sesions", description = "Esta operación busca sesions de la BBDD MongoDB que cumplan los parámetros de entrada.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busqueda de sesions obtenida correctamente"),
            @ApiResponse(responseCode = "400", description = "Algún error debido a los parámetros al intentar buscar las sesions, ver el mensaje"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<EntrenosDto> search(@RequestBody @Valid EntrenosSearchDto filterParams) throws Exception {
    	LOG.info("EntrenosController - search: Parámetros de búsqueda recibidos: {}", filterParams);
        List<EntrenosDto> response = entrenosService.search(filterParams);
        LOG.info("EntrenosController - search: Número de sesions encontradas: {}", response.size());
        
        return response;
    }
    
    
}