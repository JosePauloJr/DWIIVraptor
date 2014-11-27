/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.edu.unidavi.vraptor.annotation.Log;
import br.edu.unidavi.vraptor.dao.ProdutoDao;
import br.edu.unidavi.vraptor.model.Produto;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author José Paulo Jr
 */
@Controller
public class ProdutoController {

    private final Result result;
    private final ProdutoDao dao;
    private Validator validator;
    private Mailer mailer;

    @Inject
    public ProdutoController(Result result, ProdutoDao dao, Validator validator, Mailer mailer) {
   	 this.result = result;
   	 this.dao = dao;
   	 this.validator = validator;
   	 this.mailer = mailer;
    }

    @Deprecated
    public ProdutoController() {
   	 this(null, null, null, null); // para uso do CDI
    }

    @Path("/")
    public void inicio() {

    }

    @Path("/produto/lista")
    public List<Produto> lista() {
   	 // codigo besta
   	 // imagina ter que fazer isso aqui em todos os métodos do projeto
   	 // if (usuarioLogado.getUsuario() != null) {
   	 // result.include("produtoList", dao.lista());
   	 // return;
   	 // }

   	 return dao.lista();
    }

    @Get
    @Log
    public void listaXML() {
   	 result.use(Results.xml()).from(dao.lista()).exclude("quantidade")
   			 .serialize();
    }

    @Get
    public void listaJSON() {
   	 result.use(Results.json()).from(dao.lista()).serialize();
    }

    @Path("/produto/formulario")
    @Get
    public void formulario() {

    }
    
    @Path("/produto/formularioUpdate/{idProduto}")
    @Get
    public Produto formularioUpdate(Long idProduto) {
   	 Produto produtoBusca = new Produto();
   	 produtoBusca.setId(idProduto);
   	 return dao.busca(produtoBusca);
    }
    
    @Post("/produto/alterar")
    public void alterar(@Valid Produto produto) {
   	 // caso exista algum erro o Validator irá redirecionar para o formulário
   	 validator.onErrorUsePageOf(this).formulario();

   	 dao.atualiza(produto);

   	 // alterando o fluxo padrão do VRaptor
   	 result.include("mensagem", "Produto alterado com sucesso!");
   	 result.forwardTo(this).lista();
    }
    
    @Post("/produto/adiciona")
    public void adiciona(@Valid Produto produto) {

   	 // caso exista algum erro o Validator irá redirecionar para o formulário
   	 validator.onErrorUsePageOf(this).formulario();

   	 dao.adiciona(produto);

   	 // alterando o fluxo padrão do VRaptor
   	 result.include("mensagem", "Produto adicionado com sucesso!");
   	 result.forwardTo(this).lista();
    }

    @Path("/produto/remove")
    public void remove(Produto produto) {
   	 dao.remove(produto);

   	 // alterando o fluxo padrão do VRaptor
   	 result.include("mensagem", "Produto excluído com sucesso!");
   	 result.forwardTo(this).lista();
    }

    @Get
    public void enviaPedidoDeNovosItens(Produto produto) throws EmailException {
   	 SimpleEmail email = new SimpleEmail();
   	 email.setSubject("[vraptor-produtos] Precisamos de mais estoque");
   	 email.addTo("marcondesmacaneiro@gmail.com");
   	 email.setMsg("Precisamos de mais itens do produto" + produto.getNome());
   	 mailer.send(email);
    	result.redirectTo(this).lista();
    }

}

