package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoDataBase;
import dao.UsuarioDAO;
import model.UsuarioModel;

public class UsuarioDAOImpl implements UsuarioDAO{

	private Connection conexao;
	PreparedStatement statement = null;
	
	String insertUsuario = "INSERT INTO T_USUARIO (ID_USUARIO, NM_USUARIO, NM_SENHA, DS_EMAIL, DT_INSCRICAO) VALUES (?, ?, ?, ?, sysdate)";
	
	String updateUsuario = "UPDATE T_USUARIO SET NM_USUARIO = ? WHERE ID_USUARIO = ?";
	
	String selectAll = "SELECT ID_USUARIO, NM_USUARIO, NM_SENHA, DS_EMAIL, DT_INSCRICAO FROM T_USUARIO";
	
	String selectUsuario = "SELECT ID_USUARIO, NM_USUARIO, NM_SENHA, DS_EMAIL, DT_INSCRICAO FROM T_USUARIO WHERE ID_USUARIO = ?";
	
	String deleteUsuario = "DELETE FROM T_USUARIO WHERE ID_USUARIO = ?";

	@Override
	public void insert(UsuarioModel model) {
		try {
			System.out.println("DEBUG -> Iniciando método insert.");
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(insertUsuario);
			
			statement.setInt(1, 3);
			statement.setString(2, "Victor");
			statement.setString(3, "1234");
			statement.setString(4, "teste@gmail.com");
			statement.executeUpdate();
			
			System.out.println("FIM -> Termino do método.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<UsuarioModel> findAll() {
		
		List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
		ResultSet resultSet = null;
		
		try {
			System.out.println("DEBUG -> Iniciando método findAll.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectAll);
			resultSet = statement.executeQuery();

			System.out.println("1. Mapeando objetos.");
			while(resultSet.next()) {
				
				System.out.println("2. Cria o objeto com as informações recebidas."); 
				UsuarioModel usuarioModel = new UsuarioModel(
							resultSet.getInt("ID_USUARIO"),
							resultSet.getString("NM_USUARIO"),
							resultSet.getString("NM_SENHA"),
							resultSet.getString("DS_EMAIL"));
				System.out.println("3. Adiciona o objeto a lista.");
				usuarios.add(usuarioModel);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("FIM -> Termino do método.");
		return usuarios;
	}

	@Override
	public UsuarioModel findById(Integer idUsuario) {
		UsuarioModel usuario = null;
		ResultSet resultSet = null;
		

		try {
			System.out.println("DEBUG -> Iniciando método findById.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectUsuario);
			statement.setInt(1, idUsuario);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Integer id = resultSet.getInt("ID_USUARIO");
				String	nmUsuario = resultSet.getString("NM_USUARIO");
				String dsSenha = resultSet.getString("NM_SENHA");
				String dsEmail = resultSet.getString("DS_EMAIL");
				
				usuario = new UsuarioModel(id, nmUsuario, dsSenha, dsEmail);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println(usuario);
		System.out.println("FIM -> Termino do método.");
		return usuario;
	}

	@Override
	public void update(UsuarioModel model) {
		
		try {
			System.out.println("DEBUG -> Iniciando método update.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(updateUsuario);
			
			statement.setString(1, model.getNmUsuario());
			statement.setInt(2, model.getIdUsuario());
			statement.executeUpdate();

			System.out.println("FIM -> Termino do método.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(Integer idUsuario) {
		
		try {
			System.out.println("DEBUG -> Iniciando método delete.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(deleteUsuario);
			
			statement.setInt(1, idUsuario);
			statement.executeUpdate();
			
			System.out.println("FIM -> Termino do método.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
