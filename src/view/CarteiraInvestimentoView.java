package view;

import dao.CarteiraInvestimentoDAO;
import impl.CarteiraInvestimentoDAOImpl;
import model.CarteiraInvestimentoModel;

public class CarteiraInvestimentoView {
	
	public static void main(String[] args) {
		try {
			
			CarteiraInvestimentoDAO dao = new CarteiraInvestimentoDAOImpl();
			CarteiraInvestimentoModel model = new CarteiraInvestimentoModel();
			
			//insert
			dao.insert(model);
			
			//findById
			model.setIdCarteiraInvestimento(1);
			model.setIdUsuario(1);
			dao.findById(model.getIdCarteiraInvestimento(), model.getIdUsuario());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
