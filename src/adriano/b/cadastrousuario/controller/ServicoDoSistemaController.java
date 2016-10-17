/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adriano.b.cadastrousuario.controller;

import adriano.b.cadastrousuario.model.dao.ServicoDoSistemaDao;
import adriano.b.cadastrousuario.model.domain.ServicoDoSistema;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ServicoDoSistemaController {

    private ServicoDoSistemaDao dao;

    public ServicoDoSistemaController() throws Exception {
        try {
            this.dao = new ServicoDoSistemaDao();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<ServicoDoSistema> pesquisar(String nome) throws Exception {
        try {
            if (nome.equalsIgnoreCase("")) {
                return this.dao.listarTodos();
            } else {
                return this.dao.listarPorNome(nome);
            }
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void excluir(ServicoDoSistema s) throws Exception {
        try {
            this.dao.remover(s);
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void salvar(ServicoDoSistema s) throws Exception {
        try {
            this.dao.salvar(s);
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public void salvarTodos(List<ServicoDoSistema> todos) throws Exception {
        for (Iterator<ServicoDoSistema> servicos = todos.iterator(); servicos.hasNext();) {
            ServicoDoSistema servico = servicos.next();
            this.salvar(servico);
        }
    }
    
}
