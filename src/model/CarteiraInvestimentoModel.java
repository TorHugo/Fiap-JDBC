package model;

public class CarteiraInvestimentoModel {
	public Integer idCarteiraInvestimento;
	public Integer idUsuario;
	
	public CarteiraInvestimentoModel(Integer idCarteiraInvestimento, Integer idUsuario) {
		super();
		this.idCarteiraInvestimento = idCarteiraInvestimento;
		this.idUsuario = idUsuario;
	}

	public CarteiraInvestimentoModel() {}
	
	public Integer getIdCarteiraInvestimento() {
		return idCarteiraInvestimento;
	}

	public void setIdCarteiraInvestimento(Integer idCarteiraInvestimento) {
		this.idCarteiraInvestimento = idCarteiraInvestimento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "CarteiraInvestimentoModel [idCarteiraInvestimento=" + idCarteiraInvestimento + ", idUsuario="
				+ idUsuario + "]";
	}
	
}
