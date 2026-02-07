package com.txe.dragonentrenoservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.txe.dragonentrenoservice.dto.EntrenosDto;
import com.txe.dragonentrenoservice.dto.EntrenosSearchDto;
import com.txe.dragonentrenoservice.model.EntrenosModel;
import com.txe.dragonentrenoservice.repository.EntrenosRepository;

import jakarta.annotation.PostConstruct;

@Service
public class EntrenosService {
	
	private static final Logger LOG = LoggerFactory.getLogger(EntrenosService.class);

	@Autowired
	private EntrenosRepository entrenosRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Value("${spring.application.name}")
	String serviceName;
		
    @PostConstruct
	public void init() {
		
    }
	

	/**
	 * Esta operación crea un recurso sesión dentro de la BBDD MongoDB.
	 *
	 * @param request Objeto sesión que se va a crear en la BBDD MongoDB
	 * @return
	 * @throws Exception en caso de error
	 */
	public Boolean create(EntrenosDto request) throws Exception {
		LOG.info("EntrenosService - create: Creando sesión con datos: {}", request);
		Boolean response = Boolean.FALSE;
		
		EntrenosModel model = buildSesionDtoToModel(request);
		entrenosRepository.save(model);
		
		return response;
	}
	
	
	/**
	 * Esta operación obtiene un recurso sesion de la BBDD MongoDB a partir de su identificador único.
	 *
	 * @param id Identificador único de la sesión
	 * @return SesionDto Objeto sesión obtenido de la BBDD MongoDB
	 * @throws Exception en caso de error
	 */
	public EntrenosDto findById(String id) throws Exception {	
	    EntrenosDto response = null;
		
		return response;
	}

	/**
	 * Actualiza una cesta
	 *
	 * @param cartId     Identificador unico de cesta
	 * @param cartUpdate Objeto cesta que sera guardado
	 * @return Cart cart with all the info
	 * @throws CartNotFoundException lanza una excepción en el caso de que no encuentre la cesta
	 */
	public EntrenosDto update(String sesionId, EntrenosDto sesion) throws Exception {
		EntrenosDto response = null;
		
		return response;
	}

	/**
	 * Elimina una cesta
	 *
	 * @param cartId Identificador unico de cesta
	 * @return Boolean true si se ha eliminado correctamente, false en caso contrario
	 * @throws Exception en caso de error
	 */
	public Boolean delete(String sesionId) throws Exception {
		Boolean response = Boolean.FALSE;
		

		return response;
	}

	

	/**
	 * Busca sesiones en base a unos parámetros de búsqueda.
	 *
	 * @param parameters Parámetros de búsqueda
	 * @return Lista de SesionDto que cumplen los parámetros de búsqueda
	 * @throws Exception en caso de error
	 */
	public List<EntrenosDto> search(EntrenosSearchDto parameters) throws Exception {
		LOG.info("EntrenosService - search: Parámetros de búsqueda recibidos: {}", parameters);
		List<EntrenosDto> response = new java.util.ArrayList<>();
		List<EntrenosModel> modelResponse = null;
		
		if (parameters.getAlias() != null) {
			modelResponse = entrenosRepository.findTop100ByDistanciaAndAliasOrderByFechaHoraDesc(parameters.getDistancia(), parameters.getAlias());
		}  else {
			modelResponse = entrenosRepository.findTop100ByDistanciaOrderByFechaHoraDesc(parameters.getDistancia());
		}
		
		int contador = 0;
		for (EntrenosModel model : modelResponse) {
			// Devolvemos los 100 registros más recientes que cumplan los parámetros de búsqueda
			if (contador >= 100) {
				break;
			}
			response.add(buildSesionModelToDto(model));
		}
		
		
		return response;
	}
	
	private EntrenosModel buildSesionDtoToModel(EntrenosDto dto) {
		EntrenosModel response = new EntrenosModel();
		
		response.setFechaHora(dto.getFecha_hora());
		response.setBarco(dto.getBarco());
		response.setDistancia(dto.getDistancia());
		response.setRitmo(dto.getRitmo());	
		response.setDistancia_salida(dto.getDistancia_salida());
		response.setTiempo_salida(dto.getTiempo_salida());
		response.setDistancia_parcial1(dto.getDistancia_parcial1());
		response.setTiempo_parcial1(dto.getTiempo_parcial1());
		response.setDistancia_parcial2(dto.getDistancia_parcial2());
		response.setTiempo_parcial2(dto.getTiempo_parcial2());
		response.setDistancia_parcial3(dto.getDistancia_parcial3());
		response.setTiempo_parcial3(dto.getTiempo_parcial3());
		response.setDistancia_parcial4(dto.getDistancia_parcial4());
		response.setTiempo_parcial4(dto.getTiempo_parcial4());
		response.setTiempo_total(dto.getTiempo_total());
		response.setAlias(dto.getAlias());
		response.setNum_participantes(dto.getNum_participantes());
		
		return response;
	}
	
	private EntrenosDto buildSesionModelToDto(EntrenosModel model) {
		EntrenosDto response = new EntrenosDto();
		
		response.setFecha_hora(model.getFechaHora());
		response.setBarco(model.getBarco());
		response.setDistancia(model.getDistancia());
		response.setRitmo(model.getRitmo());	
		response.setDistancia_salida(model.getDistancia_salida());
		response.setTiempo_salida(model.getTiempo_salida());
		response.setDistancia_parcial1(model.getDistancia_parcial1());
		response.setTiempo_parcial1(model.getTiempo_parcial1());
		response.setDistancia_parcial2(model.getDistancia_parcial2());
		response.setTiempo_parcial2(model.getTiempo_parcial2());
		response.setDistancia_parcial3(model.getDistancia_parcial3());
		response.setTiempo_parcial3(model.getTiempo_parcial3());
		response.setDistancia_parcial4(model.getDistancia_parcial4());
		response.setTiempo_parcial4(model.getTiempo_parcial4());
		response.setTiempo_total(model.getTiempo_total());
		response.setAlias(model.getAlias());
		response.setNum_participantes(model.getNum_participantes());
		
		return response;
	}

	
}
