package dao;

import model.CarteiraInvestimentoModel;

public interface CarteiraInvestimentoDAO {
	
	void insert(CarteiraInvestimentoModel model);

	CarteiraInvestimentoModel findById(Integer idCarteira, Integer idUsuario);
}
