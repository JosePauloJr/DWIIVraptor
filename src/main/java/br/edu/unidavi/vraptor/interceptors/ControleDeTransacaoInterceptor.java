/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.interceptors;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.edu.unidavi.vraptor.annotation.DatabaseBsn;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author José Paulo Jr
 */
@AcceptsWithAnnotations(DatabaseBsn.class)
@Intercepts(after={
    	AutorizadorInterceptor.class,
    	LogInterceptor.class
    })
public class ControleDeTransacaoInterceptor {

	@Inject private EntityManager em;
        @Inject private ControllerMethod controllerMethod;
        
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
            if(!controllerMethod.containsAnnotation(DatabaseBsn.class)){
                
            }
    	em.getTransaction().begin();
    	stack.next();
    	em.getTransaction().commit();
	}
}
