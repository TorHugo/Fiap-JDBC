package view;

import java.util.List;

import dao.InvestimentoDAO;
import impl.InvestimentoDAOImpl;
import model.InvestimentoModel;

public class InvestimentoView {

	public static void main(String[] args) {
		
		try {
			
			InvestimentoDAO dao = new InvestimentoDAOImpl();
			InvestimentoModel model = new InvestimentoModel();
			
			// insert
			dao.insert(model);
			
			// findAll
			model.setIdInvestimento(1);
			List<InvestimentoModel> investimentos = dao.findAll(model.getIdInvestimento());
			for(InvestimentoModel investimento : investimentos) {
				System.out.println(investimento.toString());
			}
			
			// findById
			model.setIdInvestimento(1);
			dao.findById(model.getIdInvestimento());
			
			// update
			model.setIdInvestimento(1);
			model.setDsValor(185.77f);
			model.setDsLocalInvestido("Renda Fixa");
			model.setDsRentabilidade(12.15f);
			model.setIdCategoriaInvestimento(1);
			
			// delete
			model.setIdInvestimento(1);
			dao.delete(model.getIdInvestimento());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
