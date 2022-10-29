package view;

import java.util.List;

import dao.SaldoDAO;
import impl.SaldoDAOImpl;
import model.SaldoModel;

public class SaldoUsuarioView {
	public static void main(String[] args) {
		try {
			
			SaldoDAO dao = new SaldoDAOImpl();
			SaldoModel model = new SaldoModel();
			
			//insert
			dao.insert(model);
			
			//findAll
			model.setIdUsuario(1);
			List<SaldoModel> saldos = dao.findAll(model.getIdUsuario());
			for(SaldoModel saldo : saldos) {
				System.out.println(saldo.toString());
			}
			
			//Busca todas as entradas.
			model.setIdUsuario(1);
			List<SaldoModel> entradas = dao.findAllTpEntrada(model.getIdUsuario());
			for(SaldoModel saldo : entradas) {
				System.out.println(saldo.toString());
			}

			//Busca todas as saidas.
			model.setIdUsuario(1);
			List<SaldoModel> saidas = dao.findAllTpSaida(model.getIdUsuario());
			for(SaldoModel saldo : saidas) {
				System.out.println(saldo.toString());
			}
			
			//findById
			model.setIdSaldo(1);
			model.setIdUsuario(1);
			dao.findById(model.getIdSaldo(), model.getIdUsuario());
			
			//update 
			model.setIdSaldo(1);
			model.setIdUsuario(1);
			model.setDsValor(789.55f);
			model.setNmValor("TESTE UPDATE");
			dao.update(model);
			
			//delete
			model.setIdSaldo(1);
			dao.delete(model.getIdSaldo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
