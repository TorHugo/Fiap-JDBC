package impl;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoDataBase;

import dao.CategoriaInvestimentoDAO;
import model.CategoriaInvestimentoModel;

public class CategoriaInvestimentoDAOImpl implements CategoriaInvestimentoDAO {

	private Connection conexao;
	PreparedStatement statement = null;
	

	String insertCategoriaInvestimento = "INSERT INTO T_CATEGORIA_INVESTIMENTO (ID_CATEGORIA_INVESTIMENTO, DS_INVESTIMENTO, NM_INVESTIMENTO, ID_CARTEIRA) VALUES (?, ?, ?, ?)";

	String updateCategoriaInvestimento = "UPDATE T_CATEGORIA_INVESTIMENTO"
			+ " SET DS_INVESTIMENTO = ?, NM_INVESTIMENTO= ? WHERE ID_CATEGORIA_INVESTIMENTO = ? AND ID_CARTEIRA = ?";
	
	String selectAll = "SELECT DS_INVESTIMENTO, NM_INVESTIMENTO FROM T_CATEGORIA_INVESTIMENTO  WHERE ID_CARTEIRA = ?";
	
	String selectCategoriaInvestimento = "SELECT ID_CATEGORIA_INVESTIMENTO, ID_CARTEIRA, DS_INVESTIMENTO, NM_INVESTIMENTO FROM T_CATEGORIA_INVESTIMENTO WHERE ID_CATEGORIA_INVESTIMENTO= ? AND ID_CARTEIRA = ?";
	
	String deleteCategoriaInvestimento = "DELETE "
			+ "FROM T_CATEGORIA_INVESTIMENTO WHERE ID_CARTEIRA = ?";
	
	
	@Override
	public void insert(CategoriaInvestimentoModel model) {
		
		try {
			
			System.out.println("DEBUG -> Iniciando método insert.");
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(insertCategoriaInvestimento);
			
			statement.setInt(1, 1);
			statement.setString(2, "Blockchain");
			statement.setString(3, "Crypto.");
			statement.setInt(4, 1);
			statement.executeUpdate();
			
			System.out.println("FIM -> Termino do método. Categoria cadastro com sucesso.");
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
	
	public List<CategoriaInvestimentoModel> findAll(Integer idCarteira) {
		List<CategoriaInvestimentoModel> categoriasInvestimento = new ArrayList<CategoriaInvestimentoModel>();
		ResultSet resultSet = null;
		
		try {
			System.out.println("DEBUG -> Iniciando método findAll.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectAll);
			statement.setInt(1, idCarteira);
			resultSet = statement.executeQuery();

			System.out.println("1. Mapeando objetos.");
			System.out.println("2. Cria o objeto com as informações recebidas.");
			System.out.println("3. Adiciona o objeto a lista.");
			
			while(resultSet.next()) {
				
				CategoriaInvestimentoModel catInvestModel = new CategoriaInvestimentoModel(
							resultSet.getInt("ID_CATEGORIA_INVESTIMENTO"),
							resultSet.getString("DS_INVESTIMENTO"),
							resultSet.getString("NM_INVESTIMENTO"),
							resultSet.getInt("ID_CARTEIRA"));
				categoriasInvestimento.add(catInvestModel);
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
		return categoriasInvestimento;
	}
	
	
	public CategoriaInvestimentoModel findById(Integer idCategoriaInvestimento, Integer idCarteira) {
		
		CategoriaInvestimentoModel categoriaInvestimento = null;
		ResultSet resultSet = null;

		try {
			System.out.println("DEBUG -> Iniciando método findById.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectCategoriaInvestimento);
			statement.setInt(1, idCategoriaInvestimento);
			statement.setInt(2, idCarteira);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Integer idCategoria = resultSet.getInt("ID_CATEGORIA_INVESTIMENTO");
				String dsInvestimento = resultSet.getString("DS_INVESTIMENTO");
				String nmInvestimento = resultSet.getString("NM_INVESTIMENTO");
				Integer idCarteiraInvest = resultSet.getInt("ID_CARTEIRA");
				
				
				categoriaInvestimento = new CategoriaInvestimentoModel(idCategoria, dsInvestimento, nmInvestimento, idCarteiraInvest);
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

		System.out.println(categoriaInvestimento.toString());
		System.out.println("FIM -> Termino do método.");
		return categoriaInvestimento;
	}
	

	public void update(CategoriaInvestimentoModel model) {

		try {
			System.out.println("DEBUG -> Iniciando método update.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(updateCategoriaInvestimento);
			
			statement.setString(1, model.getdsInvestimento());
			statement.setString(2, model.getnmInvestimento());
			statement.setInt(3, model.getidCategoriaInvestimento());
			statement.setInt(4, model.getidCarteira());
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

	public void delete(Integer idCategoriaInvestimento) {
		
		
		try {
			System.out.println("DEBUG -> Iniciando método delete.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(deleteCategoriaInvestimento);
			
			statement.setInt(1, idCategoriaInvestimento);
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
