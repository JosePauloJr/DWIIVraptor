/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.observers;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.edu.unidavi.vraptor.dao.ProdutoDao;
import br.edu.unidavi.vraptor.dao.UsuarioDao;
import br.edu.unidavi.vraptor.util.JPAUtil;
import br.edu.unidavi.vraptor.model.Produto;
import br.edu.unidavi.vraptor.model.Usuario;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

/**
 *
 * @author José Paulo Jr
 */
public class InitialDataObserver {

    EntityManager em = JPAUtil.criaEntityManager();

    public void insert(@Observes VRaptorInitialized event) {

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.salva(
                new Usuario("vraptor", "vraptor"));

        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.adiciona(
                new Produto("DVD/Blu-ray Justin Bieber", 120.8, 2));
        produtoDao.adiciona(
                new Produto("Carro de F1", 1.99, 5));
        produtoDao.adiciona(
                new Produto("Livro da Casa do Código", 29.9, 10));


    }

}
