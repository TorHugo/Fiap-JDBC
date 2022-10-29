package model;

public class SaldoModel {

	private Integer idSaldo;
	private Float dsValor;
	private String nmValor;
	private Integer tpEntrada;
	private Integer tpSaida;
	private Integer idUsuario;
	
	public SaldoModel(Integer idSaldo, Float dsValor, String nmValor, Integer tpEntrada, Integer tpSaida,
			Integer idUsuario) {
		super();
		this.idSaldo = idSaldo;
		this.dsValor = dsValor;
		this.nmValor = nmValor;
		this.tpEntrada = tpEntrada;
		this.tpSaida = tpSaida;
		this.idUsuario = idUsuario;
	}
	
	public SaldoModel(Integer idUsuario, Float dsValor, String nmValor) {
		super();
		this.idUsuario = idUsuario;
		this.dsValor = dsValor;
		this.nmValor = nmValor;
	}
	
	public SaldoModel(Integer usuarioModel, Float dsValor, String nmValor, Integer tpEntrada, Integer tpSaida) {
		super();
		this.dsValor = dsValor;
		this.nmValor = nmValor;
		this.tpEntrada = tpEntrada;
		this.tpSaida = tpSaida;
		this.idUsuario = usuarioModel;
	}
	
	public SaldoModel() {}
	
	public Integer getIdSaldo() {
		return idSaldo;
	}
	public void setIdSaldo(Integer idSaldo) {
		this.idSaldo = idSaldo;
	}
	public Float getDsValor() {
		return dsValor;
	}
	public void setDsValor(Float dsValor) {
		this.dsValor = dsValor;
	}
	public String getNmValor() {
		return nmValor;
	}
	public void setNmValor(String nmValor) {
		this.nmValor = nmValor;
	}
	public Integer getTpEntrada() {
		return tpEntrada;
	}
	public void setTpEntrada(Integer tpEntrada) {
		this.tpEntrada = tpEntrada;
	}
	public Integer getTpSaida() {
		return tpSaida;
	}
	public void setTpSaida(Integer tpSaida) {
		this.tpSaida = tpSaida;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Override
	public String toString() {
		return "SaldoModel ["
				+ "\n\tId do usuario: " + idUsuario + "."
				+ "\n\tValor: " + dsValor + "."
				+ "\n\tDescrição: " + nmValor + "."
				+ "\n\tEntrada: " + tpEntrada + "."
				+ "\n\tSaida: " + tpSaida + "." 
				+ "\n]";
	}
	
}
