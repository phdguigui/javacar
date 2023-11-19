import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Loja {
	protected static ArrayList<Veiculo> ListaVeiculos = new ArrayList<>();
	protected static ArrayList<Cliente> ListaClientes = new ArrayList<>();
	protected static ArrayList<Vendedor> ListaVendedores = new ArrayList<>();
	protected static ArrayList<Venda> ListaVendas = new ArrayList<>();
	
	public static boolean CadastroVeiculo() {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setNome(JOptionPane.showInputDialog("Digite o modelo do carro a ser cadastrado"));
		veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca do carro a ser cadastrado"));
		veiculo.setCor(JOptionPane.showInputDialog("Digite a cor do carro a ser cadastrado"));
		veiculo.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro a ser cadastrado")));
		veiculo.setKm(Integer.parseInt(JOptionPane.showInputDialog("Digite a quilometragem do carro a ser cadastrado")));
		veiculo.setValor(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do carro a ser cadastrado")));
		if(!veiculo.setPlaca(JOptionPane.showInputDialog("Digite a placa do carro a ser cadastrado"))) {
			return false;
		}
		
		ListaVeiculos.add(veiculo);
		
		return true;
	}
	
	public static boolean ExcluiVeiculo(String placa) {
		int count = 0;
		for(var veiculo : ListaVeiculos){
			if(veiculo.getPlaca().trim().toLowerCase() == placa.trim().toLowerCase()) {
				ListaVeiculos.remove(count);
				return true;
			}
			count++;
		}
		JOptionPane.showMessageDialog(null, "Placa não encontrada");
		return false;
	}
	
	public static boolean AlterarDadoVeiculo(String placa) {
		// To do
		return true;
	}
	
	public static boolean CadastroVenda() {
		Venda venda = new Venda();
		
		// Set Data
		venda.setData(JOptionPane.showInputDialog("Digite a data da venda"));
		
		// Set Cliente
		String[] opcoes = {"Sim", "Não"};
		int escolha = JOptionPane.showOptionDialog(null, "Cliente já foi cadastrado?", "Cadastro de Cliente",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == JOptionPane.YES_OPTION) {
        	boolean clienteEncontrado = false;
            String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente");
            for(Cliente cliente : ListaClientes) {
            	if(cliente.getCPF().trim() == cpf.trim()) {
            		venda.setCliente(cliente);
            		clienteEncontrado = true;
            		break;
            	}
            }
            if(!clienteEncontrado) {
            	JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            	return false;
            }
        } 
        
        else if (escolha == JOptionPane.NO_OPTION) {
          venda.setCliente(CadastroCliente());
        }
        
        // Set Veículo
        String placa = JOptionPane.showInputDialog("Digite a placa do veículo vendido");
        boolean veiculoEncontrado = false;
        for(Veiculo veiculo : ListaVeiculos) {
        	if(veiculo.getPlaca() == placa) {
        		venda.setVeiculo(veiculo);
        		veiculoEncontrado = true;
        		break;
        	}
        }
        if(!veiculoEncontrado) {
        	JOptionPane.showMessageDialog(null, "Veículo não encontrado");
        	return false;
        }
        
        // Set Valor
		venda.setValor(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor da venda")));
		
		// Set Vendedor
		String nomeVendedor = JOptionPane.showInputDialog("Digite o nome do vendedor");
		for(Vendedor vendedor : ListaVendedores) {
			if(vendedor.getNome().trim().toLowerCase() == nomeVendedor.trim().toLowerCase()) {
				venda.setVendedor(vendedor);
				break;
			}
		}
		
		ListaVendas.add(venda);
		ExcluiVeiculo(venda.getVeiculo().getPlaca());
		
		return true;
	}
	
	public static Cliente CadastroCliente() {
		Cliente cliente = new Cliente();
		
		// Set Nome
		cliente.setNome(JOptionPane.showInputDialog("Digite o nome do cliente"));
		// Set Endereço
		cliente.setEndereco(JOptionPane.showInputDialog("Digite o endereço do cliente"));
		// Set Cidade
		cliente.setCidade(JOptionPane.showInputDialog("Digite a cidade do cliente"));
		// Set Estado
		cliente.setEstado(JOptionPane.showInputDialog("Digite o estado do cliente"));
		
		// Set CPF
		String  cpf = JOptionPane.showInputDialog("Digite o CPF do cliente");
		
		for(Cliente cliente2 : ListaClientes) {
			if(cliente.getCPF() == cpf) {
				JOptionPane.showInputDialog("Cliente já cadastrado");
				return cliente2;
			}
		}
		
		ListaClientes.add(cliente);
		return cliente;
	}
	
	public static boolean CadastroVendedor() {
		Vendedor vendedor = new Vendedor();
		
		// Set Nome
		vendedor.setNome(JOptionPane.showInputDialog("Digite o nome do vendedor"));
		// Set Endereço
		vendedor.setEndereco(JOptionPane.showInputDialog("Digite o endereço do vendedor"));
		// Set Cidade
		vendedor.setCidade(JOptionPane.showInputDialog("Digite a cidade do vendedor"));
		// Set Estado
		vendedor.setEstado(JOptionPane.showInputDialog("Digite o estado do vendedor"));
		
		ListaVendedores.add(vendedor);
		
		return true;
	}
	
	public static void ListarVeiculos() {
		// To do
	}
	
	public static void ListarClientes() {
		// To do
	}
	
	public static void ListarVendedores() {
		// To do
	}
	
	public static void ListarVendas() {
		// To do
	}
}
