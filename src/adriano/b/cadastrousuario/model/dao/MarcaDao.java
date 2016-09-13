package adriano.b.cadastrousuario.model.dao;

import adriano.b.cadastrousuario.model.domain.Marca;
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
public class MarcaDao {

    private Connection conn;

    public MarcaDao() {
        try {
            this.conn = Conexao.getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean salvar(Marca obj) {
        Integer codigo = obj.getCodigo();
        String nome = obj.getNome();
     
        StringBuilder sql = new StringBuilder();
        if (codigo == null) {
            sql.append("insert into marca");
            sql.append(" (codigo, nome ");
            sql.append(" ) ");
            sql.append(" values ( ( select coalesce(max(x.codigo), ? )+1 as ID from marca x ) ,? ) ");
            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(2, nome);
                stm.setInt(1, 0);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            sql.append("update marca set");
            sql.append(" nome = ? ");
            sql.append(" where codigo = ?");

            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(1, nome);
                stm.setInt(2, codigo);
                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean excluir(Marca obj) {
        Integer codigo = obj.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from marca where codigo = ?");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            stm.setInt(1, codigo);
            stm.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public List<Marca> listar() {
        List<Marca> lst = new ArrayList<Marca>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from marca");
        try {
            PreparedStatement stm
                    = this.conn.prepareStatement(sql.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Marca m = new Marca();
                m.setCodigo(rs.getInt("codigo"));
                m.setNome(rs.getString("nome"));
                lst.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
}
