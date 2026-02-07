package com.txe.dragonentrenoservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "entrenos")
public class EntrenosModel {
	
	@Id
	private String id;
	
	/** Fecha y hora de la sesión "yyyy/MM/dd HH:mm" */
	@Field("fecha_hora")
	private String fechaHora;
	
	private String barco;
	
	private Integer distancia;
	
	private Integer ritmo;
	
	private Integer distancia_salida;
	
	private String tiempo_salida;
	
	private Integer distancia_parcial1;
	
	private String tiempo_parcial1;
	
	private Integer distancia_parcial2;
	
	private String tiempo_parcial2;
	
	private Integer distancia_parcial3;
	
	private String tiempo_parcial3;
	
	private Integer distancia_parcial4;
	
	private String tiempo_parcial4;
	
	private String tiempo_total;
	
	private String alias;
	
	private Integer num_participantes;
	
	

	public Integer getNum_participantes() {
		return num_participantes;
	}

	public void setNum_participantes(Integer num_participantes) {
		this.num_participantes = num_participantes;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getBarco() {
		return barco;
	}

	public void setBarco(String barco) {
		this.barco = barco;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Integer getRitmo() {
		return ritmo;
	}

	public void setRitmo(Integer ritmo) {
		this.ritmo = ritmo;
	}

	public Integer getDistancia_salida() {
		return distancia_salida;
	}

	public void setDistancia_salida(Integer distancia_salida) {
		this.distancia_salida = distancia_salida;
	}

	public String getTiempo_salida() {
		return tiempo_salida;
	}

	public void setTiempo_salida(String tiempo_salida) {
		this.tiempo_salida = tiempo_salida;
	}

	public Integer getDistancia_parcial1() {
		return distancia_parcial1;
	}

	public void setDistancia_parcial1(Integer distancia_parcial1) {
		this.distancia_parcial1 = distancia_parcial1;
	}

	public String getTiempo_parcial1() {
		return tiempo_parcial1;
	}

	public void setTiempo_parcial1(String tiempo_parcial1) {
		this.tiempo_parcial1 = tiempo_parcial1;
	}

	public Integer getDistancia_parcial2() {
		return distancia_parcial2;
	}

	public void setDistancia_parcial2(Integer distancia_parcial2) {
		this.distancia_parcial2 = distancia_parcial2;
	}

	public String getTiempo_parcial2() {
		return tiempo_parcial2;
	}

	public void setTiempo_parcial2(String tiempo_parcial2) {
		this.tiempo_parcial2 = tiempo_parcial2;
	}

	public Integer getDistancia_parcial3() {
		return distancia_parcial3;
	}

	public void setDistancia_parcial3(Integer distancia_parcial3) {
		this.distancia_parcial3 = distancia_parcial3;
	}

	public String getTiempo_parcial3() {
		return tiempo_parcial3;
	}

	public void setTiempo_parcial3(String tiempo_parcial3) {
		this.tiempo_parcial3 = tiempo_parcial3;
	}

	public Integer getDistancia_parcial4() {
		return distancia_parcial4;
	}

	public void setDistancia_parcial4(Integer distancia_parcial4) {
		this.distancia_parcial4 = distancia_parcial4;
	}

	public String getTiempo_parcial4() {
		return tiempo_parcial4;
	}

	public void setTiempo_parcial4(String tiempo_parcial4) {
		this.tiempo_parcial4 = tiempo_parcial4;
	}

	public String getTiempo_total() {
		return tiempo_total;
	}

	public void setTiempo_total(String tiempo_total) {
		this.tiempo_total = tiempo_total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

}
