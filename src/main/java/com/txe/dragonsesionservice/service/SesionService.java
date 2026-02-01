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
	 * Guarda una cesta. Si no tiene id se le asignara uno nuevo, si tiene id se sobreescribira.
	 *
	 * @param cart Objeto cesta que sera guardado.
	 * @param repositorio nombre del repositorio a utilizar, tiene que estar comtemplado previamente
	 * como Repository. Si es null utilizaremos el repositorio de cesta estándar de venta actual.
	 * @return cart created
	 */
	/**public SesionDto save(SesionDto cart, String repositorio) throws CartNotFoundException{
		Cart cartCreated = null;

		if(Optional.ofNullable(repositorio).orElse("").equals(RepositorioType.ENJOY.getRepositorio())) {
			cartCreated = cartEnjoyRepository.save((CartEnjoy)CartBuilder.buildCart(cart));
		}else if(Utils.esRepositorioEstandar(repositorio)) {
			cartCreated = this.cartRepository.save(CartBuilder.buildCart(cart));
		}else if (repositorio.equals(RepositorioType.SCANGO.getRepositorio()))	{
			cartCreated = cartScanGoRepository.save((CartScanGo)CartBuilder.buildCart(cart));		
		}else if (repositorio.equals(RepositorioType.CAFETERIA_MESA.getRepositorio()))	{
			cartCreated = cartCafeteriaCobroMesaRepository.save((CartCafeteriaMesa)CartBuilder.buildCart(cart));
		}else if (repositorio.equals(RepositorioType.AUXILIAR.getRepositorio()))	{
			CartAuxiliar cartAuxiliar = (CartAuxiliar)CartBuilder.buildCart(cart);
			cartAuxiliar.setExpireAt(LocalDateTime.now().plusDays(numeroDiasBackupCestaExtensibilidad));
			cartCreated = cartAuxiliarRepository.save(cartAuxiliar);
		}else if (repositorio.equals(RepositorioType.EXTENSIBILIDAD.getRepositorio())) {
			if (cart.getTipoCesta()==null) {
				cart.setTipoCesta(TipoCestaType.EXTENSIBILIDAD.getTipoCesta());
			}
			CartExtensibilidad cartExtensibilidad = (CartExtensibilidad)CartBuilder.buildCart(cart);
			cartExtensibilidad.setExpireAt(LocalDateTime.now().plusDays(numeroDiasBackupCestaAuxiliar));
			cartCreated = cartExtensibilidadRepository.save(cartExtensibilidad);
		}else {
			Log.error("ATENCION!!! La cesta no se ha podido grabar dado su desconocimiento, tipo: " +cart.getIdCesta() + " repositorio " + repositorio);
			throw new CartNotFoundException();
		}

		return CartBuilder.buildSesionDto(cartCreated);
	}*/

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
		response.setPrueba(dto.getPrueba()); 
		
		return response;
	}

	
}
