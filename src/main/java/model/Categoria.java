package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@Column(name = "idcategoria")
	private int idCategoria;
	@Column(name = "descripcion")
	private String descripcion;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return this.getDescripcion();
	}
	public Categoria(int idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}
	
	public Categoria() {
		super();
	}
	
	
}
