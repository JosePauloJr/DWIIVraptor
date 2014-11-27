/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.util;

import br.edu.unidavi.vraptor.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author José Paulo Jr
 */
@SessionScoped
@Named
public class UsuarioLogado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;

    public Usuario getUsuario() {
   	 return usuario;
    }

    public void setUsuario(Usuario usuario) {
   	 this.usuario = usuario;
    }
}
