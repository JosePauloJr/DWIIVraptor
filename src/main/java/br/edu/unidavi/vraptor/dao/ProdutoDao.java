/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.dao;

import br.edu.unidavi.vraptor.model.Produto;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author José Paulo Jr
 */
@RequestScoped
public class ProdutoDao {

    //private final EntityManager em;
    @Inject private EntityManager em;

    //@Inject
    //public ProdutoDao(EntityManager em) {
   //	 this.em = em;
    //}
    
   // @Deprecated
	//ProdutoDao() {
    	//(null); // para uso do CDI
	//}
    
    public void adiciona(Produto produto) {
   	 em.persist(produto);
    }

    public void remove(Produto produto) {
   	 em.remove(busca(produto));
    }

    public Produto busca(Produto produto) {
   	 return em.find(Produto.class, produto.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Produto> lista() {
   	 return em.createQuery("select p from Produto p").getResultList();
    }

    public void atualiza(Produto produto) {
   	 em.merge(produto);
    }
}
