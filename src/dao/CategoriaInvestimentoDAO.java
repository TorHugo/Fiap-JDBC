package dao;

import java.util.List;

import model.CategoriaInvestimentoModel;

public interface CategoriaInvestimentoDAO {
	
	void insert(CategoriaInvestimentoModel model);
	
	List<CategoriaInvestimentoModel> findAll(Integer idCarteiraInvestimento);
	
	CategoriaInvestimentoModel findById(Integer idCarteiraInvestimento, Integer idCategoria);
	
	void update(CategoriaInvestimentoModel model);
	
	void delete(Integer idCarteiraInvestimento);
}
