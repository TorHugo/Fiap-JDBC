package view;
import java.util.List;

import dao.CategoriaInvestimentoDAO;
import impl.CategoriaInvestimentoDAOImpl;
import model.CategoriaInvestimentoModel;


public class CategoriaInvestimentoView {
	public static void main(String[] args) {
		try {
			
			CategoriaInvestimentoDAO dao =  new CategoriaInvestimentoDAOImpl();
			CategoriaInvestimentoModel model = new CategoriaInvestimentoModel();
			
			//insert
			dao.insert(model);
			
			//findAll
			model.setidCarteira(1);
			List<CategoriaInvestimentoModel> categoriasInvestimento = dao.findAll(model.getidCarteira());
			for(CategoriaInvestimentoModel categoriaInvestimento : categoriasInvestimento) {
				System.out.println(categoriaInvestimento.toString());
			}
			
			//findById
			 model.setidCategoriaInvestimento(1);
		     model.setidCarteira(1);
		     dao.findById(model.getidCategoriaInvestimento(), model.getidCarteira());
	 		
			//update 
			model.setidCategoriaInvestimento(1);
			model.setidCarteira(1);
			model.setnmInvestimento("teste decrição");
			model.setnmInvestimento("TESTE nome");
			dao.update(model);
			
			//delete
			model.setidCategoriaInvestimento(1);
			dao.delete(model.getidCategoriaInvestimento());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
