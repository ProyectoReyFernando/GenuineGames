package com.genuinegames.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "valorar")
public class Valorar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "puntuacion")
	private int puntuacion;
	@ManyToOne(cascade = CascadeType.MERGE)
	private User punU;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Game punG;
	public Valorar( User punU, int puntuacion,Game punG) {
		super();
		this.puntuacion = puntuacion;
		this.punU = punU;
		this.punG = punG;
	}
	public Valorar() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public User getPunU() {
		return punU;
	}
	public void setPunU(User punU) {
		this.punU = punU;
	}
	public Game getPunG() {
		return punG;
	}
	public void setPunG(Game punG) {
		this.punG = punG;
	}
	

}
