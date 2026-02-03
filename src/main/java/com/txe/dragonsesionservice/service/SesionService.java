package com.txe.dragonsesionservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.txe.dragonsesionservice.dto.CartSearchDto;
import com.txe.dragonsesionservice.dto.SesionDto;
import com.txe.dragonsesionservice.dto.SesionPostDto;
import com.txe.dragonsesionservice.model.SesionModel;
import com.txe.dragonsesionservice.repository.SesionRepository;

import jakarta.annotation.PostConstruct;

@Service
public class SesionService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SesionService.class);

	@Autowired
	private SesionRepository sesionRepository;

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
	public Boolean create(SesionPostDto request) throws Exception {
		Boolean response = Boolean.FALSE;
		
		SesionModel model = buildSesionPostDtoToModel(request);
		sesionRepository.save(model);
		
		return response;
	}
	
	
	/**
	 * Esta operación obtiene un recurso sesion de la BBDD MongoDB a partir de su identificador único.
	 *
	 * @param id Identificador único de la sesión
	 * @return SesionDto Objeto sesión obtenido de la BBDD MongoDB
	 * @throws Exception en caso de error
	 */
	public SesionDto findById(String id) throws Exception {	
	    SesionDto response = null;
		
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
	public SesionDto update(String sesionId, SesionDto sesion) throws Exception {
		SesionDto response = null;
		
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
	public List<SesionDto> search(CartSearchDto parameters) throws Exception {
		List<SesionDto> response = null;
		
		return response;
	}
	
	private SesionModel buildSesionPostDtoToModel(SesionPostDto dto) {
		SesionModel response = new SesionModel();
		
		response.setFecha_hora(dto.getFecha_hora());
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
		response.setDistancia_Parcial4(dto.getDistancia_Parcial4());
		response.setTiempo_parcial4(dto.getTiempo_parcial4());
		response.setTiempo_total(dto.getTiempo_total());
		
		return response;
	}

	
}
