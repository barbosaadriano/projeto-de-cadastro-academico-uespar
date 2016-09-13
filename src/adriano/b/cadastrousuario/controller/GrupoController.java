package adriano.b.cadastrousuario.controller;

import adriano.b.cadastrousuario.model.dao.GrupoDao;
import adriano.b.cadastrousuario.model.domain.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class GrupoController {

    private GrupoDao dao;
    private Grupo grupoManipulado;
    private List<Grupo> lista;

    public GrupoController() {
        this.dao = new GrupoDao();
        this.grupoManipulado = null;
        this.lista = new ArrayList<Grupo>();
    }

    public void pesquisar() {
        this.lista = dao.listar();
    }

    public void novo() {
        this.grupoManipulado = new Grupo();
    }

    public void excluir() {
        this.dao.excluir(this.grupoManipulado);
    }

    public void salvar() {
        this.dao.salvar(this.grupoManipulado);
    }

    public Grupo getGrupoManipulado() {
        return grupoManipulado;
    }

    public void setGrupoManipulado(Grupo grupoManipulado) {
        this.grupoManipulado = grupoManipulado;
    }

    public List<Grupo> getLista() {
        return lista;
    }

    public void setLista(List<Grupo> lista) {
        this.lista = lista;
    }

   

}
