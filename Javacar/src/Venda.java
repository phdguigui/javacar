public class Venda {	
	private Veiculo Veiculo;
	private String Data;
	private float Valor;
	private String NomeCliente;
	private String NomeVendedor;
	
	public Veiculo getVeiculo() {
		return Veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		Veiculo = veiculo;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public float getValor() {
		return Valor;
	}
	public void setValor(float valor) {
		Valor = valor;
	}
	public String getNomeCliente() {
		return NomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}
	public String getNomeVendedor() {
		return NomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		NomeVendedor = nomeVendedor;
	}
}
