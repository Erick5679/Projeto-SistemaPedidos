package com.br.sistemaPedidosAtividade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, length = 80)
	private String nome;

	@NotNull
	@Min(value = 0, message = "O preço do produto deve ser positivo.")
	private Double preco;

	@NotBlank
	@Column(columnDefinition = "text")
	private String descricao;
	
	@NotBlank
	@Column(name = "vendedor_id")
	private Long vendedorId;

	public Produto() {
	}

	public Produto(Long id, String nome, Double preco, String descricao, Long vendedorId) {
		super();
		this.id = id;
		this.nome = nome; 
		this.preco = preco;
		this.descricao = descricao;
		this.vendedorId = vendedorId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getVendedorId() {
		return vendedorId;
	}
	
	public void setVendedorId(Long vendedorId) {
		this.vendedorId = vendedorId;
	}

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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
