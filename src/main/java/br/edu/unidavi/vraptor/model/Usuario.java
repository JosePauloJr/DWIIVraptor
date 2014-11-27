/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author José Paulo Jr
 */
@Entity
public class Usuario {

    @Id @GeneratedValue
    private Long id;
    
    private String nome;
    private String senha;

    public Usuario() {
    }
    
    public Usuario(String nome, String senha) {
   	 this.nome = nome;
   	 this.senha = senha;
    }

    public String getNome() {
   	 return nome;
    }

    public void setNome(String nome) {
   	 this.nome = nome;
    }

    public String getSenha() {
   	 return senha;
    }

    public void setSenha(String senha) {
   	 this.senha = senha;
    }

    public Long getId() {
   	 return id;
    }

    public void setId(Long id) {
   	 this.id = id;
    }
    
}

