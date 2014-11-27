/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AfterCall;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.edu.unidavi.vraptor.annotation.Public;
import br.edu.unidavi.vraptor.controller.LoginController;
import br.edu.unidavi.vraptor.util.UsuarioLogado;
import javax.inject.Inject;

/**
 *
 * @author José Paulo Jr
 */
@Intercepts
public class AutorizadorInterceptor {

    private final Result result;
    private final UsuarioLogado usuarioLogado;
    private ControllerMethod controllerMethod;

    @Inject
    public AutorizadorInterceptor(Result result,
            UsuarioLogado usuarioLogado, ControllerMethod controllerMethod) {
        this.result = result;
        this.usuarioLogado = usuarioLogado;
        this.controllerMethod = controllerMethod;
    }

    @Deprecated
    AutorizadorInterceptor() {
        this(null, null, null); // para uso do CDI
    }

    @Accepts
    public boolean accepts() {
        return !controllerMethod.containsAnnotation(Public.class);
    }

    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {

        if (usuarioLogado.getUsuario() == null) {
            result.redirectTo(LoginController.class).formulario();
            return;
        }
        stack.next();
    }

    @BeforeCall
    public void before() {
        System.out.println("Executou o @BeforeCall do Interceptor");
    }

    @AfterCall
    public void after() {
        System.out.println("Executou o @AfterCall do Interceptor");
    }

}
