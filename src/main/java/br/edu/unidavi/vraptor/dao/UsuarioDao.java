/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.dao;

import br.edu.unidavi.vraptor.model.Usuario;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author José Paulo Jr
 */
public class UsuarioDao {

    //private final EntityManager em;
    @Inject private EntityManager em;
    
    @Inject
    public UsuarioDao(EntityManager em) {
   	 this.em = em;
    }
    
    @Deprecated
    public UsuarioDao() {
   	 this(null); // para uso do CDI
    }  
    
    public boolean existe(Usuario usuario) {
   	 return !em.createQuery("select u from Usuario u where u.nome = "
   		 + ":nome and u.senha = :senha", Usuario.class)
   		 .setParameter("nome", usuario.getNome())
   		 .setParameter("senha", usuario.getSenha())
   		 .getResultList().isEmpty();
    }

    public void salva(Usuario usuario) {
   	 em.persist(usuario);
    }

}
