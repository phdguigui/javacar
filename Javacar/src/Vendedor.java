import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Vendedor {
	private String Nome;
	private String Endereco;
	private String Cidade;
	private String Estado;
	private ArrayList<Venda> vendas = new ArrayList<>();
	
	Vendedor(){
		this.vendas = new ArrayList<Venda>();
	}
	
	//lista todas as vendas realizadas pelo vendedor
	public void listarCompras() {
		if(vendas.size()==0) {
			JOptionPane.showMessageDialog(null, "Este vendedor ainda não realizou nenhuma venda");
		}else {
			for(int i = 0; i < vendas.size(); i++) {
				String detalhes="Compras do cliente\n";
				detalhes+="Veículo: " +vendas.get(i).getVeiculo().getNome()+"\n";
				detalhes+="Cor: " +vendas.get(i).getVeiculo().getCor()+"\n";
				detalhes+="Ano: " +vendas.get(i).getVeiculo().getAno()+"\n";
				detalhes+="Placa: " +vendas.get(i).getVeiculo().getPlaca()+"\n";
				detalhes+="Data da compra: "+vendas.get(i).getData()+"\n";
				detalhes+="Valor da compra: "+vendas.get(i).getValor()+"\n";
				detalhes+="Cliente: "+vendas.get(i).getCliente().getNome()+"\n";
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
}
