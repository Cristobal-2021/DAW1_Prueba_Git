package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_productos")
public class Productos {
	@Id
	@Column(name="id_prod")
	private String id;
	@Column(name="des_prod")
	private String descripcion;
	@Column(name="stk_prod")
	private int stk;
	@Column(name="pre_prod")
	private double precio;
	@Column(name="idcategoria")
	private int id_categoria;
	@Column(name="est_prod")
	private int estado;
	@Column(name="idprovedor")
	private int id_proveedor;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStk() {
		return stk;
	}
	public void setStk(int stk) {
		this.stk = stk;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	
	
}
