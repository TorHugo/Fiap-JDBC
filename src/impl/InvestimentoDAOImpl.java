package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import connection.ConexaoDataBase;
import dao.InvestimentoDAO;
import model.InvestimentoModel;
import model.SaldoModel;
import model.UsuarioModel;

public class InvestimentoDAOImpl implements InvestimentoDAO {
	
	private Connection conexao;
	PreparedStatement statement = null;
	
	String insertInvestimento = "INSERT INTO T_INVESTIMENTO (ID_INVESTIMENTO, VL_INVESTIMENTO, DS_LOCAL_INVESTIMENTO, DT_INÍCIO, DT_TERMINO, VL_RENTABILIDADE, ID_CATEGORIA_INVESTIMENTO) VALUES (?, ?, ?, sysdate, sysdate, ?, ?);";
	
	String updateInvestimento = "UPDATE T_INVESTIMENTO SET VL_INVESTIDO = ?, DS_LOCAL_INVESTIMENTO = ?, DT_INICIO = ?, DT_TERMINO = ?, VL_RENTABILIDADE = ? WHERE ID_CATEGORIA_INVESTIMENTO = ?";
	
	String selectAll = "SELECT ID_INVESTIMENTO, VL_INVESTIMENTO, DS_LOCAL_INVESTIMENTO, DT_INÍCIO, DT_TERMINO, VL_RENTABILIDADE, ID_CATEGORIA_INVESTIMENTO FROM T_USUARIO";
	
	String selectInvestimento = "SELECT TCATEG.NM_INVESTIMENTO, TCATEG.DS_INVESTIMENTO, TINVEST.VL_INVESTIDO, TINVEST.DS_LOCAL_INVESTIMENTO, TINVEST.DT_INICIO, TINVEST.DT_TERMINO, TINVEST.VL_RENTABILIDADE FROM T_CARTEIRA_INVESTIMENTO TCART INNER JOIN T_CATEGORIA_INVESTIMENTO TCATEG ON (TCATEG.ID_CARTEIRA = TCART.ID_CARTEIRA) INNER JOIN T_INVESTIMENTO TINVEST ON (TINVEST.ID_CATEGORIA_INVESTIMENTO = TCATEG.ID_CATEGORIA_INVESTIMENTO) WHERE ID_USUARIO = ? AND ID_INVESTIMENTO = ?";

	String deleteInvestimento = "DELETE FROM T_INVESTIMENTO WHERE ID_INVESTIMENTO = ?";
	
	@Override
	public void insert(InvestimentoModel model) {
		
		try {
			
			System.out.println("DEBUG -> Iniciando método insert.");
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(insertInvestimento);

			statement.setInt(1, 1);
			statement.setFloat(2, 10.5f);
			statement.setString(3, "Local de Investimento");
			statement.setFloat(4, 0);
			statement.setInt(5, 1);
			
			statement.executeUpdate();
			
			System.out.println("FIM -> Termino do método. Usuário cadastro com sucesso.");
			
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
	public List<InvestimentoModel> findAll(Integer idInvestimento) {
		List<InvestimentoModel> investimentos = new ArrayList<InvestimentoModel>();
		ResultSet resultSet = null;
		
		try {
			System.out.println("DEBUG -> Iniciando método findAll.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectAll);
			statement.setInt(1, idInvestimento);
			resultSet = statement.executeQuery();
			
			System.out.println("1. Mapeando objetos.");
			System.out.println("2. Cria o objeto com as informações recebidas.");
			System.out.println("3. Adiciona o objeto a lista.");
			
			while(resultSet.next()) {
				
				InvestimentoModel investimentoModel = new InvestimentoModel(
						resultSet.getInt("ID_INVESTIMENTO"),
						resultSet.getFloat("VL_INVESTIMENTO"),
						resultSet.getString("DS_LOCAL_INVESTIMENTO"),
						resultSet.getDate("DT_INICIO"),
						resultSet.getDate("DT_TERMINO"),
						resultSet.getFloat("VL_RENTABILIDADE"),
						resultSet.getInt("ID_CATEGORIA_INVESTIMENTO"));
				investimentos.add(investimentoModel);
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
		return investimentos;		
	}

	@Override
	public InvestimentoModel findById(Integer idInvestimento) {
		
		InvestimentoModel investimento = null;
		ResultSet resultSet = null;
		
		try {
			System.out.println("DEBUG -> Iniciando método findById.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectInvestimento);
			statement.setInt(1, idInvestimento);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Integer invest = resultSet.getInt("ID_INVESTIMENTO");
				Float dsValor = resultSet.getFloat("VL_INVESTIMENTO");
				String dsLocalInvestido = resultSet.getString("DS_LOCAL_INVESTIMENTO");
				Date dtInicio = resultSet.getDate("DT_INICIO");
				Date dtTermino = resultSet.getDate("DT_TERMINO");
				Float dsRentabilidade = resultSet.getFloat("VL_RENTABILIDADE");
				Integer idCategoriaInvestimento = resultSet.getInt("ID_CATEGORIA_INVESTIMENTO");
			
				investimento = new InvestimentoModel(invest, dsValor, dsLocalInvestido, dtInicio, dtTermino, dsRentabilidade, idCategoriaInvestimento);
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
		
		System.out.println(investimento);
		System.out.println("FIM -> Termino do método.");
		return investimento;
		
	}

	@Override
	public void update(InvestimentoModel model) {
		
		try {
			System.out.println("DEBUG -> Iniciando método update.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(updateInvestimento);
			
			statement.setInt(1, model.getIdInvestimento());
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
	public void delete(Integer idInvestimento) {
		
		try {
			System.out.println("DEBUG -> Iniciando método delete.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(deleteInvestimento);
			
			statement.setInt(1, idInvestimento);
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
