import java.util.ArrayList;

public class Cliente {
	private String Nome;
	private String Endereco;
	private String Cidade;
	private String Estado;
	private ArrayList<Venda> ListaCompra = new ArrayList<>();
	
	public boolean inserirCompra(Venda venda) {
		ListaCompra.add(venda);
		return true;
	}
}
