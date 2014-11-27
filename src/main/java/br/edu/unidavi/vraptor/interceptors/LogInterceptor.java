/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.interceptors;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.edu.unidavi.vraptor.annotation.Log;
import javax.inject.Inject;

/**
 *
 * @author José Paulo Jr
 */
@AcceptsWithAnnotations(Log.class)
@Intercepts
public class LogInterceptor {

	private final ControllerMethod controllerMethod;

	@Inject
	public LogInterceptor(ControllerMethod controllerMethod) {
    	this.controllerMethod = controllerMethod;
	}

//	@Accepts
//	public boolean accepts() {
//    	return controllerMethod.containsAnnotation(Log.class);
//	}

	public LogInterceptor() {
    	this(null); // para uso do CDI
	}

	@BeforeCall
	public void before() {
    	String nomeDoMetodo = controllerMethod.getMethod().getName();
    	System.out.println("Executando o método: " + nomeDoMetodo);
	}
}

