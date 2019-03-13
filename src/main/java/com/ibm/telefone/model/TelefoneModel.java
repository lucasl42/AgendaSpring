package com.ibm.telefone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ibm.contato.model.ContatoModel;

@Entity
public class TelefoneModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	short ddd;
	EnumTipoTelefone tipoTelefone;
	String numero;
	
	@ManyToOne
	ContatoModel contato;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelefoneModel other = (TelefoneModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public short getDdd() {
		return ddd;
	}
	public void setDdd(short ddd) {
		this.ddd = ddd;
	}
	public EnumTipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(EnumTipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public ContatoModel getContato() {
		return contato;
	}
	public void setContato(ContatoModel contato) {
		this.contato = contato;
	}
	
}
