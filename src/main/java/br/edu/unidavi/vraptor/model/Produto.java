/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author José Paulo Jr
 */
@Entity
public class Produto {

    @GeneratedValue @Id
    private Long id;

    @NotNull
    @NotEmpty(message="O nome do produto não pode ser vazio")
    @Size(min=3, message="O nome do produto deve ter pelo menos 3 digitos.")
    private String nome;
    
    @NotNull
//    @NotEmpty(message="O valor não pode ser vazio.")
    private Double valor;
    
    @NotNull
    @Min(value=0, message="{produto.quantidade.negativa}")
    private Integer quantidade;

    public Produto() {
    }
    
    public Produto(String nome, Double valor, Integer quantidade) {
   	 this.nome = nome;
   	 this.valor = valor;
   	 this.quantidade = quantidade;
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

    public Double getValor() {
   	 return valor;
    }

    public void setValor(Double valor) {
   	 this.valor = valor;
    }

    public Integer getQuantidade() {
   	 return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
   	 this.quantidade = quantidade;
    }

}
