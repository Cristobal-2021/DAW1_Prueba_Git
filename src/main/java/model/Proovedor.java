package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_proveedor")
public class Proovedor {
	
	@Id
	@Column(name = "idprovedor")
	private int id;
	@Column(name= "nombre_rs")
	private String nombre;
	@Column(name="telefono")
	private int telefono;
	@Column(name="email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return this.getNombre();
	}
	
	public Proovedor(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Proovedor() {
		super();
	}
	
}
