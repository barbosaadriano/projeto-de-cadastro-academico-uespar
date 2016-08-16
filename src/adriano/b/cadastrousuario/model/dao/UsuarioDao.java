package adriano.b.cadastrousuario.model.dao;

import adriano.b.cadastrousuario.model.domain.Usuario;
import adriano.b.cadastrousuario.services.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class UsuarioDao {

    private Connection conn;

    public UsuarioDao() {
        try {
            this.conn = Conexao.getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //podemos mudar de void para boolean e passar a tratar na tela
    public boolean salvar(Usuario obj) {
        Integer codigo = obj.getCodigo();
        String nome = obj.getNome();
        String login = obj.getLogin();
        String senha = obj.getSenha();
        int status = obj.getStatus();
        int tipo = obj.getTipo();
        StringBuilder sql = new StringBuilder();
        if (codigo == null) {
            sql.append("insert into usuario");
            sql.append(" (codigo, nome, login, senha, ");
            sql.append(" tipo, `status`) ");
            sql.append(" values ( ( select coalesce(max(x.codigo), ? )+1 as ID from usuario x ) ,?,?,?,?,?) ");
            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(2, nome);
                stm.setInt(1, 0);
                stm.setString(3, login);
                stm.setString(4, senha);
                stm.setInt(5, status);
                stm.setInt(6, tipo);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            sql.append("update usuario set");
            sql.append(" nome = ?, login = ?, senha = ?, `status` = ?, ");
            sql.append(" tipo = ? ");
            sql.append(" where codigo = ?");

            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(0, nome);
                stm.setInt(5, codigo);
                stm.setString(1, login);
                stm.setString(2, senha);
                stm.setInt(3, status);
                stm.setInt(4, tipo);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean excluir(Usuario obj) {
        Integer codigo = obj.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from usuario where codigo = ?");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            stm.setInt(0, codigo);
            stm.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //podemos adicionar um parametro usuário e filtrar conforme os parametros

    public List<Usuario> listar() {
        List<Usuario> lst = new ArrayList<Usuario>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from usuario");
        try {
            PreparedStatement stm
                    = this.conn.prepareStatement(sql.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCodigo(rs.getInt("codigo"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setStatus(rs.getInt("status"));
                u.setTipo(rs.getInt("tipo"));
                lst.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
}
