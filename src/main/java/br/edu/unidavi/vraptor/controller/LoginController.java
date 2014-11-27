/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.unidavi.vraptor.annotation.Public;
import br.edu.unidavi.vraptor.dao.UsuarioDao;
import br.edu.unidavi.vraptor.model.Usuario;
import br.edu.unidavi.vraptor.util.UsuarioLogado;
import javax.inject.Inject;

/**
 *
 * @author José Paulo Jr
 */
@Controller
public class LoginController {

    private final UsuarioDao dao;
    private final Result result;
    private final Validator validator;
    private final UsuarioLogado usuarioLogado;

    @Inject
    public LoginController(UsuarioDao dao, Result result, Validator validator, UsuarioLogado usuarioLogado) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        this.usuarioLogado = usuarioLogado;
    }

    @Deprecated
    LoginController() {
        this(null, null, null, null); // para uso do CDI
    }

    @Public
    @Get
    public void formulario() {
    }

    @Public
    @Post("/login/autentica")
    public void autentica(Usuario usuario) {
        if (!dao.existe(usuario)) {
            validator.add(new I18nMessage("login", "login.invalido"));
            validator.onErrorUsePageOf(this).formulario();
        }
        usuarioLogado.setUsuario(usuario);
        result.redirectTo(ProdutoController.class).lista();
    }

}
