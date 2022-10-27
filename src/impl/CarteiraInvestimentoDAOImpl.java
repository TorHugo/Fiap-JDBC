package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConexaoDataBase;
import dao.CarteiraInvestimentoDAO;
import model.CarteiraInvestimentoModel;

public class CarteiraInvestimentoDAOImpl implements CarteiraInvestimentoDAO{

		private Connection conexao;
		PreparedStatement statement = null;
		
		String insertCarteira = "INSERT INTO T_CARTEIRA_INVESTIMENTO (ID_USUARIO, ID_CARTEIRA) VALUES (?, ?)";

		String selectCarteira = "SELECT ID_USUARIO, ID_CARTEIRA FROM T_CARTEIRA_INVESTIMENTO WHERE ID_CARTEIRA = ? AND ID_USUARIO = ?";

		@Override
		public void insert(CarteiraInvestimentoModel model) {
			
			try {
				
				System.out.println("DEBUG -> Iniciando método insert.");
				conexao = ConexaoDataBase.conectar();
				statement = conexao.prepareStatement(insertCarteira);
				
				statement.setInt(1, 1);
				statement.setInt(2, 1);
				
				statement.executeUpdate();
				
				System.out.println("FIM -> Termino do método. Carteira de Investimento cadastrada com sucesso.");
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
		public CarteiraInvestimentoModel findById(Integer idCarteira, Integer idUsuario) {
			
			CarteiraInvestimentoModel model = null;
			ResultSet resultSet = null;

			try {
				System.out.println("DEBUG -> Iniciando método findById.");
				
				conexao = ConexaoDataBase.conectar();
				statement = conexao.prepareStatement(selectCarteira);
				statement.setInt(1, idCarteira);
				statement.setInt(2, idUsuario);
				resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					Integer carteira = resultSet.getInt("ID_CARTEIRA");
					Integer usuario = resultSet.getInt("ID_USUARIO");
					
					
					model = new CarteiraInvestimentoModel(carteira, usuario);
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

			System.out.println(model.toString());
			System.out.println("FIM -> Termino do método.");
			return model;
		}
		
}
