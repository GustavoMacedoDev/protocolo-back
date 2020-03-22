package br.com.macedo.sistemas.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "origem")
public class Origem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_origem")
	private String nomeOrigem;
	
	public Origem() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
