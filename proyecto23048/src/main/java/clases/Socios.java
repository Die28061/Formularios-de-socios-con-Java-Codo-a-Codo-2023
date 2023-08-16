package clases;

import java.time.LocalDate;
import java.util.Date;

public class Socios 
{
	private int id_socio;
	private String nombre;
	private String apellido;
	private int dni;
	private String mail;
	private boolean estado;
	private LocalDate fecha_alta;
		
	/*
	public Socios(int id,String nombre,String apellido,int dni,String mail,boolean estado,Date fecha_alta)
	{
		this.setId_socio(id);
		this.setNombre(nombre);
		//this.nombre=nombre;
	}
	*/
	
	public Socios(int id_socio, String nombre, String apellido, int dni, String mail, boolean estado, LocalDate fecha_alta) 
	{
		//super();
		this.id_socio = id_socio;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.estado = estado;
		this.fecha_alta = fecha_alta;
	}
	
	
	
	//Getters y Setters
	public int getId_socio() {
		return id_socio;
	}
	
	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public LocalDate getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	
	
	
	
	
}



