public class Venda {	
	private Veiculo Veiculo;
	private String Data;
	private float Valor;
	private Cliente Cliente;
	private Vendedor Vendedor;
	
	Venda(){
		
	}
	
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
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	public Vendedor getVendedor() {
		return Vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		Vendedor = vendedor;
	}
}
