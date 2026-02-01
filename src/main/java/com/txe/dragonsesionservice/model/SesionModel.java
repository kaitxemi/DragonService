package com.txe.dragonsesionservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "sesiones")
public class SesionModel {
	
	@Id
	private String id;
	
	private String prueba;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrueba() {
		return prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}
	

}
