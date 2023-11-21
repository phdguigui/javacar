import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cliente {
	private String Nome;
	private String Endereco;
	private String Cidade;
	private String Estado;
	private String CPF;
	private ArrayList<Venda> compras = new ArrayList<>();
	
	Cliente(){
		this.compras = new ArrayList<Venda>();
	}
	
	//lista todas as compras realizadas pelo cliente
	public void listarCompras() {
		if(compras.size()==0) {
			JOptionPane.showMessageDialog(null, "Este cliente ainda não realizou nenhuma compra");
		}else {
			for(int i = 0; i < compras.size(); i++) {
				String detalhes="Compras do cliente\n";
				detalhes+="Veículo: " +compras.get(i).getVeiculo().getNome()+"\n";
				detalhes+="Cor: " +compras.get(i).getVeiculo().getCor()+"\n";
				detalhes+="Ano: " +compras.get(i).getVeiculo().getAno()+"\n";
				detalhes+="Placa: " +compras.get(i).getVeiculo().getPlaca()+"\n";
				detalhes+="Data da compra: "+compras.get(i).getData()+"\n";
				detalhes+="Valor da compra: "+compras.get(i).getValor()+"\n";
				detalhes+="Vendedor: "+compras.get(i).getVendedor().getNome()+"\n";
				JOptionPane.showMessageDialog(null, detalhes);
			}
		}
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
}
