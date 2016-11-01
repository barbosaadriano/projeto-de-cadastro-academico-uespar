package adriano.b.cadastrousuario.model.dao;

import adriano.b.cadastrousuario.model.domain.ServicoDoSistema;
import adriano.b.cadastrousuario.services.Conexao;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ServicoDoSistemaDao {

    private Connection cnx;

    public ServicoDoSistemaDao() throws SQLException {
        this.cnx = (Connection) Conexao.getInstance();
    }

    public void salvar(ServicoDoSistema s) throws SQLException {
        Integer codigo = s.getCodigo();
        String nome = s.getNome();
        String descricao = s.getDescricao();
        String status = s.getStatus();
        StringBuilder sql = new StringBuilder();
        PreparedStatement ps;
        if (codigo != null) {
            sql.append("update sis_servicos ");
            sql.append(" set nome = ?, ");
            sql.append(" descricao = ?, ");
            sql.append(" `status` = ? ");
            sql.append(" where codigo = ? ");

            ps = this.cnx.prepareStatement(sql.toString());
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setString(3, status);
            ps.setInt(4, codigo);

        } else {
            sql.append("insert into sis_servicos ");
            sql.append("( codigo, nome, descricao, ");
            sql.append(" `status` ) values ( ");
            sql.append(" (select coalesce(max(x.codigo), ?)+1 "
                    + "from sis_servicos x), ");
            sql.append(" ?, ?, ? ) ");
            ps = this.cnx.prepareStatement(sql.toString());
            ps.setString(2, nome);
            ps.setString(3, descricao);
            ps.setString(4, status);
            ps.setInt(1, 0);
        }
        ps.execute();
    }

    public void remover(ServicoDoSistema s) throws SQLException {
        Integer codigo = s.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from sis_servicos where codigo = ?");
        PreparedStatement ps = this.cnx.prepareStatement(sql.toString());
        ps.setInt(1, codigo);
        ps.execute();
    }

    public List<ServicoDoSistema> listarTodos() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sis_servicos");
        PreparedStatement ps = this.cnx.prepareStatement(sql.toString());
        boolean execute = ps.execute();
        List<ServicoDoSistema> lista = new ArrayList<ServicoDoSistema>();
        if (execute) {
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                ServicoDoSistema s = new ServicoDoSistema();
                s.setCodigo(rs.getInt("codigo"));
                s.setDescricao(rs.getString("descricao"));
                s.setNome(rs.getString("nome"));
                s.setStatus(rs.getString("status"));
                lista.add(s);
            }
            return lista;
        } else {
            return lista;
        }
    }

    public List<ServicoDoSistema> listarPorNome(String p) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sis_servicos where nome like '"+p+"%' ");
        PreparedStatement ps = this.cnx.prepareStatement(sql.toString());
        boolean execute = ps.execute();
        List<ServicoDoSistema> lista = new ArrayList<ServicoDoSistema>();
        if (execute) {
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                ServicoDoSistema s = new ServicoDoSistema();
                s.setCodigo(rs.getInt("codigo"));
                s.setDescricao(rs.getString("descricao"));
                s.setNome(rs.getString("nome"));
                s.setStatus(rs.getString("status"));
                lista.add(s);
            }
            return lista;
        } else {
            return lista;
        }
    }
}
