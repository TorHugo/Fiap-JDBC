package dao;

import java.util.List;

import model.InvestimentoModel;

public interface InvestimentoDAO {
	
	void insert(InvestimentoModel model);
	
	List<InvestimentoModel> findAll(Integer idInvestimento);
	
	InvestimentoModel findById(Integer idInvestimento);
	
	void update(InvestimentoModel model);
	
	void delete(Integer idInvestimento);

}
