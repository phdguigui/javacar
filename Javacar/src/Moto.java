public class Moto extends Veiculo {
	private int cilindrada;
	private boolean PartidaEletrica;
	
	public void exibirInformacoes() {
		// To do
	}
	public void setPartidaEletrica(boolean partida) {
		this.PartidaEletrica = partida;
	}
	public boolean getPartidaEletrica() {
		return this.PartidaEletrica;
	}
	public int getCilindrada(){
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
}
