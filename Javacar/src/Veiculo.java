import javax.swing.JOptionPane;

public class Veiculo extends Loja{
	private String Nome;
	private String Marca;
	private String Cor;
	private int Ano;
	private int Km;
	private float Valor;
	private String Placa;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getCor() {
		return Cor;
	}
	public void setCor(String cor) {
		Cor = cor;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		Ano = ano;
	}
	public int getKm() {
		return Km;
	}
	public void setKm(int km) {
		Km = km;
	}
	public float getValor() {
		return Valor;
	}
	public void setValor(float valor) {
		Valor = valor;
	}
	public String getPlaca() {
		return Placa;
	}
	public boolean setPlaca(String placa) {
		for(var veiculo : ListaVeiculos){
			if(veiculo.getPlaca().trim().toLowerCase() == placa.trim().toLowerCase()) {
				JOptionPane.showMessageDialog(null, "Placa já cadastrada");
				return false;
			}
		}
		Placa = placa;
		return true;
	}
}
