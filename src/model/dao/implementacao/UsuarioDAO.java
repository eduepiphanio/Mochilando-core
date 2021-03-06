
package model.dao.implementacao;


import java.util.List;
import model.dao.interfaces.InterfaceUsuarioDAO;
import model.domain.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Cidade;
import model.excecao.ExcecaoPersistencia;
import util.db.ConnectionFactory;
import util.db.ConnectionManager;
import model.dao.implementacao.CidadeDAO;
import model.dao.interfaces.InterfaceCidadeDAO;



public class UsuarioDAO implements InterfaceUsuarioDAO {

    
    @Override
    public Long inserir(Usuario usuario) throws ExcecaoPersistencia {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO usuario (cod_usuario,nom_usuario,sbrenome_usuario,txt_email,txt_senha,img_perfil,sexo,dat_nascimento,cod_cidade) VALUES(?,?,?,?,md5(?),?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setLong(1, usuario.getCodUsuario());
            pstmt.setString(2, usuario.getNomUsuario());
            pstmt.setString(3, usuario.getSobrenomeUsuario());
            pstmt.setString(4, usuario.getTxtEmail());
            pstmt.setString(5, usuario.getTxtSenha());
            pstmt.setByte(7,usuario.getImgPerfil());
            pstmt.setString(8, usuario.getDatNascimento());
             pstmt.setLong(9, usuario.getCidade().getCodCidade());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("cod_usuario"));
                usuario.setCodUsuario(id);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcecaoPersistencia(e.getMessage(), e);
        }
    }

    @Override
    public boolean alterar(Usuario usuario) throws ExcecaoPersistencia {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE usuario "
                    + "   SET cod_nome = ?, "
                    + "       nom_usuario = ?, "
                    + "       sobrenome_usuario = ?, "
                    + "       txt_senha = md5(?), "
                    + "       img_perfil = ?,"
                    + "       sexo = ?, "
                    + "       dat_nascimento = ?,"
                    + "       cod_cidade = ?"
                    + " WHERE cod_nome = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            Long codUsuario = usuario.getCodUsuario();
            pstmt.setLong(1, usuario.getCodUsuario());
            pstmt.setString(2, usuario.getNomUsuario());
            pstmt.setString(3, usuario.getSobrenomeUsuario());
            pstmt.setString(4, usuario.getTxtEmail());
            pstmt.setString(5, usuario.getTxtSenha());
            pstmt.setByte(7,usuario.getImgPerfil());
            pstmt.setString(8, usuario.getDatNascimento());
            pstmt.setLong(9, usuario.getCidade().getCodCidade());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcecaoPersistencia(e.getMessage(), e);
        }
    }

    @Override
    public boolean excluir(Usuario usuario) throws ExcecaoPersistencia {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM usuario WHERE cod_usuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, usuario.getCodUsuario());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcecaoPersistencia(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Usuario> listarTudo() throws ExcecaoPersistencia {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM usuario ORDER BY nome_usuario";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            ArrayList<Usuario> listAll = null;
            InterfaceCidadeDAO cidadeDAO = new CidadeDAO();
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Usuario usuario = new Usuario();
                    usuario.setCodUsuario(rs.getLong("cod_usuario"));
                    usuario.setNomUsuario(rs.getString("nome_usuario"));
                    usuario.setSobrenomeUsuario(rs.getString("sobrenome_usuario"));
                    usuario.setTxtEmail(rs.getString("txt_email"));
                    usuario.setTxtSenha(rs.getString("txt_senha"));
                    usuario.setImgPerfil(rs.getByte("img_perfil"));
                    usuario.setSexo(rs.getString("sexo"));
                    usuario.setDatNascimento(rs.getString("dat_nascimento"));
                    Cidade cidade = cidadeDAO.consultarCidadePorId(rs.getLong("cod_cidade"));
                    usuario.setCidade(cidade);
                    listAll.add(usuario);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcecaoPersistencia(e.getMessage(), e);
        }
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) throws ExcecaoPersistencia {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM usuario WHERE cod_usuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Usuario usuario = null;
             InterfaceCidadeDAO cidadeDAO = new CidadeDAO();
            if (rs.next()) {
                usuario = new Usuario();
                 usuario.setCodUsuario(rs.getLong("cod_usuario"));
                    usuario.setNomUsuario(rs.getString("nome_usuario"));
                    usuario.setSobrenomeUsuario(rs.getString("sobrenome_usuario"));
                    usuario.setTxtEmail(rs.getString("txt_email"));
                    usuario.setTxtSenha(rs.getString("txt_senha"));
                    usuario.setImgPerfil(rs.getByte("img_perfil"));
                    usuario.setSexo(rs.getString("sexo"));
                    usuario.setDatNascimento(rs.getString("dat_nascimento"));
                    Cidade cidade = cidadeDAO.consultarCidadePorId(rs.getLong("cod_cidade"));
                    usuario.setCidade(cidade);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcecaoPersistencia(e.getMessage(), e);
        }
    }

    

    @Override
    public Usuario consultarUsuarioPorEmail(String txtEmail) throws ExcecaoPersistencia {
         try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM usuario WHERE txt_email = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, txtEmail);
            ResultSet rs = pstmt.executeQuery();

            Usuario usuario = null;
             InterfaceCidadeDAO cidadeDAO = new CidadeDAO();
            if (rs.next()) {
                usuario = new Usuario();
                  usuario.setCodUsuario(rs.getLong("cod_usuario"));
                    usuario.setNomUsuario(rs.getString("nome_usuario"));
                    usuario.setSobrenomeUsuario(rs.getString("sobrenome_usuario"));
                    usuario.setTxtEmail(rs.getString("txt_email"));
                    usuario.setTxtSenha(rs.getString("txt_senha"));
                    usuario.setImgPerfil(rs.getByte("img_perfil"));
                    usuario.setSexo(rs.getString("sexo"));
                    usuario.setDatNascimento(rs.getString("dat_nascimento"));
                    Cidade cidade = cidadeDAO.consultarCidadePorId(rs.getLong("cod_cidade"));
                    usuario.setCidade(cidade);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return usuario;
        }  catch (Exception e) {
            e.printStackTrace();
            throw new ExcecaoPersistencia(e.getMessage(), e);
        }
    }


}
