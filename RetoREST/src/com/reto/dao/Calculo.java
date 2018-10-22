package com.reto.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.reto.vo.RetoOperation;

@Entity
@Table(name = "Calculos")
public class Calculo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
	
	public String data;
	public int alto;
	public int ancho;
	@Enumerated
    @Column(columnDefinition = "smallint")
	public RetoOperation operacion;
	public String result;

}
