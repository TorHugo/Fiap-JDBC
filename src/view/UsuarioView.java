package view;

import java.util.List;

import dao.UsuarioDAO;
import impl.UsuarioDAOImpl;
import model.UsuarioModel;

public class UsuarioView {
    
	
	
	public static void main(String[] args) {
		try {
			
			UsuarioDAO dao = new UsuarioDAOImpl();
			UsuarioModel model = new UsuarioModel();
			
			//insert
			dao.insert(model);
			
			//update
			model.setIdUsuario(1);
			model.setNmUsuario("Victor Hugo Arruda");
			dao.update(model);

			//findAll
			List<UsuarioModel> usuarios = dao.findAll();
			for(UsuarioModel usuario : usuarios) {
				System.out.println(usuario.toString());
			}

			//findById
			model.setIdUsuario(7);
			dao.findById(model.getIdUsuario());
			
			//delete
			model.setIdUsuario(1);
			dao.delete(model.getIdUsuario());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
