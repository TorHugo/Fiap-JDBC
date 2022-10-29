package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoDataBase;
import dao.SaldoDAO;
import model.SaldoModel;

public class SaldoDAOImpl implements SaldoDAO{

	private Connection conexao;
	PreparedStatement statement = null;
	
	String insertSaldo = "INSERT INTO T_SALDO (ID_SALDO, DS_VALOR, NM_VALOR, TP_ENTRADA, TP_SAIDA, DT_INSERSAO, ID_USUARIO) VALUES (?, ?, ?, ?, ?, sysdate, ?)";

	String updateSaldo = "UPDATE T_SALDO SET DS_VALOR = ?, NM_VALOR = ? WHERE ID_SALDO = ? AND ID_USUARIO = ?";
	
	String selectAll = "SELECT TS.ID_USUARIO, TS.DS_VALOR, TS.NM_VALOR, TS.TP_ENTRADA, TS.TP_SAIDA FROM T_SALDO TS WHERE ID_USUARIO = ?";

	String selectAllTpEntrada = "SELECT ID_USUARIO, DS_VALOR, NM_VALOR FROM T_SALDO WHERE ID_USUARIO = ? AND TP_ENTRADA = 1";
	
	String selectAllTpSaida = "SELECT ID_USUARIO, DS_VALOR, NM_VALOR FROM T_SALDO WHERE ID_USUARIO = ? AND TP_SAIDA = 1";
	
	String selectSaldo = "SELECT ID_USUARIO, DS_VALOR, NM_VALOR, TP_ENTRADA, TP_SAIDA FROM T_SALDO WHERE ID_SALDO = ? AND ID_USUARIO = ?";
	
	String deleteSaldo = "DELETE FROM T_SALDO WHERE ID_SALDO = ?";
	
	@Override
	public void insert(SaldoModel model) {
		
		try {
			
			System.out.println("DEBUG -> Iniciando método insert.");
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(insertSaldo);
			
			statement.setInt(1, 7);
			statement.setFloat(2, 3390.59f);
			statement.setString(3, "Pagamento.");
			statement.setInt(4, 0);
			statement.setInt(5, 1);
			statement.setInt(6, 1);
			
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
	public List<SaldoModel> findAll(Integer idUsuario) {
		List<SaldoModel> saldos = new ArrayList<SaldoModel>();
		ResultSet resultSet = null;
		
		try {
			System.out.println("DEBUG -> Iniciando método findAll.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectAll);
			statement.setInt(1, idUsuario);
			resultSet = statement.executeQuery();

			System.out.println("1. Mapeando objetos.");
			System.out.println("2. Cria o objeto com as informações recebidas.");
			System.out.println("3. Adiciona o objeto a lista.");
			
			while(resultSet.next()) {
				
				SaldoModel saldoModel = new SaldoModel(
							resultSet.getInt("ID_USUARIO"),
							resultSet.getFloat("DS_VALOR"),
							resultSet.getString("NM_VALOR"),
							resultSet.getInt("TP_ENTRADA"),
							resultSet.getInt("TP_SAIDA"));
				saldos.add(saldoModel);
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
		return saldos;
	}
	
	@Override
	public SaldoModel findById(Integer idSaldo, Integer idUsuario) {
		
		SaldoModel saldo = null;
		ResultSet resultSet = null;

		try {
			System.out.println("DEBUG -> Iniciando método findById.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectSaldo);
			statement.setInt(1, idSaldo);
			statement.setInt(2, idUsuario);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Integer usuario = resultSet.getInt("ID_USUARIO");
				Float dsValor = resultSet.getFloat("DS_VALOR");
				String nmValor = resultSet.getString("NM_VALOR");
				Integer tpEntrada = resultSet.getInt("TP_ENTRADA");
				Integer tpSaida = resultSet.getInt("TP_SAIDA");
				
				saldo = new SaldoModel(usuario, dsValor, nmValor, tpEntrada, tpSaida);
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

		System.out.println(saldo.toString());
		System.out.println("FIM -> Termino do método.");
		return saldo;
	}
	
	@Override
	public void update(SaldoModel model) {

		try {
			System.out.println("DEBUG -> Iniciando método update.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(updateSaldo);
			
			statement.setFloat(1, model.getDsValor());
			statement.setString(2, model.getNmValor());
			statement.setInt(3, model.getIdSaldo());
			statement.setInt(4, model.getIdUsuario());
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
	public void delete(Integer idSaldo) {
		
		try {
			System.out.println("DEBUG -> Iniciando método delete.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(deleteSaldo);
			
			statement.setInt(1, idSaldo);
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
	public List<SaldoModel> findAllTpEntrada(Integer idUsuario) {
		List<SaldoModel> saldos = new ArrayList<SaldoModel>();
		ResultSet resultSet = null;
		
		try {
			System.out.println("DEBUG -> Iniciando método findAllTpEntrada.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectAllTpEntrada);
			statement.setInt(1, idUsuario);
			resultSet = statement.executeQuery();

			System.out.println("1. Mapeando objetos.");
			System.out.println("2. Cria o objeto com as informações recebidas.");
			System.out.println("3. Adiciona o objeto a lista.");
			
			while(resultSet.next()) {
				
				SaldoModel saldoModel = new SaldoModel(
							resultSet.getInt("ID_USUARIO"),
							resultSet.getFloat("DS_VALOR"),
							resultSet.getString("NM_VALOR"));
				saldos.add(saldoModel);
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
		return saldos;
	}

	@Override
	public List<SaldoModel> findAllTpSaida(Integer idUsuario) {
		List<SaldoModel> saldos = new ArrayList<SaldoModel>();
		ResultSet resultSet = null;
		
		try {
			System.out.println("DEBUG -> Iniciando método findAllTpVariada.");
			
			conexao = ConexaoDataBase.conectar();
			statement = conexao.prepareStatement(selectAllTpSaida);
			statement.setInt(1, idUsuario);
			resultSet = statement.executeQuery();

			System.out.println("1. Mapeando objetos.");
			System.out.println("2. Cria o objeto com as informações recebidas.");
			System.out.println("3. Adiciona o objeto a lista.");
			
			while(resultSet.next()) {
				
				SaldoModel saldoModel = new SaldoModel(
						resultSet.getInt("ID_USUARIO"),
						resultSet.getFloat("DS_VALOR"),
						resultSet.getString("NM_VALOR"));
				saldos.add(saldoModel);
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
		return saldos;
	}
	
}
