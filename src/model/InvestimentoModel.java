package model;

import java.util.Date;

public class InvestimentoModel {
	
	private Integer idInvestimento;
	private Float dsValor;
	private String dsLocalInvestido;
	private Float dsRentabilidade;
	private Integer idCategoriaInvestimento;	
	
	public InvestimentoModel(Integer idInvestimento, Float dsValor, String dsLocalInvestido, Date dtInicio, 
			Date dtTermino, Float dsRentabilidade, Integer idCategoriaInvestimento) {
		super();
		this.idInvestimento = idInvestimento;
		this.dsValor = dsValor;
		this.dsLocalInvestido = dsLocalInvestido;
		this.dsRentabilidade = dsRentabilidade;
		this.idCategoriaInvestimento = idCategoriaInvestimento;		
	}
	
	public InvestimentoModel() {}

	public Integer getIdInvestimento() {
		return idInvestimento;
	}

	public void setIdInvestimento(Integer idInvestimento) {
		this.idInvestimento = idInvestimento;
	}

	public Float getDsValor() {
		return dsValor;
	}

	public void setDsValor(Float dsValor) {
		this.dsValor = dsValor;
	}

	public String getDsLocalInvestido() {
		return dsLocalInvestido;
	}

	public void setDsLocalInvestido(String dsLocalInvestido) {
		this.dsLocalInvestido = dsLocalInvestido;
	}

	public Float getDsRentabilidade() {
		return dsRentabilidade;
	}

	public void setDsRentabilidade(Float dsRentabilidade) {
		this.dsRentabilidade = dsRentabilidade;
	}

	public Integer getIdCategoriaInvestimento() {
		return idCategoriaInvestimento;
	}

	public void setIdCategoriaInvestimento(Integer idCategoriaInvestimento) {
		this.idCategoriaInvestimento = idCategoriaInvestimento;
	}
	
	@Override
	public String toString() {
		return "InvestimentoModel ["
				+ "\n\tId do investimento: " + idInvestimento + "."
				+ "\n\tValor: " + dsValor + "."
				+ "\n\tLocal de investimento: " + dsLocalInvestido + "."
				+ "\n\tRentabilidade: " + dsRentabilidade + "."
				+ "\n]";		
	}

}
