package model;

public class CategoriaInvestimentoModel {
	
		private Integer idCategoriaInvestimento;
		private String dsInvestimento;
		private String nmInvestimento;
		private Integer idCarteira;
		
		public  CategoriaInvestimentoModel(Integer idCategoriaInvestimento, String dsInvestimento,String nmInvestimento, Integer idCarteira) {
			super();
			this.idCategoriaInvestimento = idCategoriaInvestimento;
			this.dsInvestimento = dsInvestimento;
			this.nmInvestimento = nmInvestimento;
			this.idCarteira = idCarteira;
		}
		
		public CategoriaInvestimentoModel() {}
		
		public Integer getidCategoriaInvestimento() {
			return idCategoriaInvestimento;
		}
		public void setidCategoriaInvestimento(Integer idCategoriaInvestimento) {
			this.idCategoriaInvestimento = idCategoriaInvestimento;
		}
		public String getdsInvestimento() {
			return dsInvestimento;
		}
		public void getdsInvestimento(String dsInvestimento) {
			this.dsInvestimento = dsInvestimento;
		}
		public String getnmInvestimento() {
			return nmInvestimento;
		}
		public void setnmInvestimento(String nmInvestimento) {
			this.nmInvestimento = nmInvestimento;
		}
		public Integer getidCarteira() {
			return idCarteira;
		}
		public void setidCarteira(Integer idCarteira) {
			this.idCarteira = idCarteira;
		}
		
		
		@Override
		public String toString() {
			return "Categoria:  "+ nmInvestimento + "["
					+ "\n\tNome da categoria investimento: " + dsInvestimento + "."
					+ "\n]";
		}

}
