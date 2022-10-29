package dao;

import java.util.List;

import model.SaldoModel;

public interface SaldoDAO {

	void insert(SaldoModel model);
	
	List<SaldoModel> findAll(Integer idUsuario);
	
	SaldoModel findById(Integer idSaldo, Integer idUsuario);
	
	List<SaldoModel> findAllTpEntrada(Integer idUsuario);
	
	List<SaldoModel> findAllTpSaida(Integer idUsuario);
	
	void update(SaldoModel model);
	
	void delete(Integer idSaldo);
}
