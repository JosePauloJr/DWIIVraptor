/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.produces;

import br.edu.unidavi.vraptor.util.JPAUtil;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

/**
 *
 * @author José Paulo Jr
 */
public class EntityManagerProducer {
    
    @Produces
    @RequestScoped
    public EntityManager criaEntityManager() {
   	 return JPAUtil.criaEntityManager();
    }
    
}

