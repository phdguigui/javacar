import java.util.ArrayList;

public class Vendedor {
	private String Nome;
	private String Endereco;
	private String Cidade;
	private String Estado;
	private ArrayList<Venda> ListaVenda = new ArrayList<>();
	
	public boolean inserirVenda(Venda venda) {
		ListaVenda.add(venda);
		return true;
	}
}
