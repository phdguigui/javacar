import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {
		Loja loja = new Loja();
		int menu = 0;
		
		//pre cadastro de veículos, carros e vendedores
		Carro veiculo1 = new Carro();
		Carro veiculo2 = new Carro();
		Moto veiculo3 = new Moto();
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Vendedor vendedor1 =  new Vendedor();
		Vendedor vendedor2 = new Vendedor();
		
		//carros
		veiculo1.setNome("Gol");
		veiculo1.setMarca("Volkswagen");
		veiculo1.setCor("Prata");
		veiculo1.setAno(2008);
		veiculo1.setKm(65000);
		veiculo1.setLitragem(1);
		veiculo1.setPortas(4);
		veiculo1.setValor(20000);
		veiculo1.setPlaca("mls9542");
		
        veiculo2.setNome("Fiesta");
        veiculo2.setMarca("Ford");
        veiculo2.setCor("Azul");
        veiculo2.setAno(2010);
        veiculo2.setKm(55000);
        veiculo2.setLitragem(1.6);
        veiculo2.setPortas(2);
        veiculo2.setValor(18000);
        veiculo2.setPlaca("xyz1234");
        
        veiculo3.setNome("CG 125");
        veiculo3.setMarca("Honda");
        veiculo3.setCor("Preto");
        veiculo3.setAno(2015);
        veiculo3.setKm(20000);
        veiculo3.setPartidaEletrica(true);
        veiculo3.setCilindrada(125);
        veiculo3.setValor(8000);
        veiculo3.setPlaca("abc1234");
        
        //clientes
        cliente1.setNome("André Schmitz");
        cliente1.setEndereco("Rua das ruas, 111");
        cliente1.setCidade("Joinville");
        cliente1.setEstado("SC");
        cliente1.setCPF("333.333.333-33");
		
        cliente2.setNome("Guilherme Siedschlag");
        cliente2.setEndereco("Rua das vielas, 222");
        cliente2.setCidade("Joinville");
        cliente2.setEstado("SC");
        cliente2.setCPF("999.999.999-99");
        
        //vendedores
        vendedor1.setNome("Guilherme");
        vendedor1.setCidade("Joinville");
        vendedor1.setEstado("SC");
        vendedor1.setEndereco("Rua dos rios, 333");

        vendedor2.setNome("Gabriel");
        vendedor2.setCidade("Joinville");
        vendedor2.setEstado("SC");
        vendedor2.setEndereco("Rua das avenidas, 444");
        
        loja.addVeiculoTeste(veiculo1);
        loja.addVeiculoTeste(veiculo2);
        loja.addVeiculoTeste(veiculo3);
        loja.addClienteTeste(cliente1);
        loja.addClienteTeste(cliente2);
        loja.addVendedoresTeste(vendedor1);
        loja.addVendedoresTeste(vendedor2);
		
		while(menu!=7) {
			menu = 0;
			menu  = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao Javacar! Digite oque você deseja:\n"
				+ "1 - Realizar um cadastro\n"
				+ "2 - Realizar uma venda\n"
				+ "3 - Listagens\n"
				+ "4 - Relatório de vendas\n"
				+ "5 - Buscar\n"
				+ "6 - Alterar informação de veículo\n"
				+ "7 - Sair"));
			
			switch(menu) {
			
				case 1:
					int menu2 = 0;
					while(menu2 < 1 || menu2 > 3) {
						menu2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar um veículo\n"
								+ "2 - Cadastrar um cliente\n"
								+ "3 - Cadastrar um vendedor"));
						switch(menu2) {
						case 1:
							loja.CadastroVeiculo();
							break;
						case 2:
							loja.CadastroCliente();
							break;
						case 3:
							loja.CadastroVendedor();
							break;
						default:
							break;
						}
					}
					break;
				
				case 2:
					loja.CadastroVenda();
					break;
				case 3:
					int menu3 = 0;
					menu3 = Integer.parseInt(JOptionPane.showInputDialog("1 - Listar veículos\n"
							+ "2 - Listar clientes\n"
							+ "3 - Listar vendedores\n"
							+ "4 - Listar vendas"));
					switch(menu3) {
						case 1:
							loja.ListarVeiculos();
							break;
						case 2:
							loja.ListarClientes();
							break;
						case 3:
							loja.ListarVendedores();
							break;
						case 4:
							loja.ListarVendas();
							break;
						default:
							break;
						
					}
					break;
				case 4:
					String[] opcoes = {"Por Cliente", "Por Vendedor"};
					int escolha = JOptionPane.showOptionDialog(null, "Que tipo de listagem você deseja?", "Cadastro de Cliente",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
					if(escolha == 0) {
						try {
							loja.buscaCliente().listarCompras();							
						}catch(RuntimeException e) {
							JOptionPane.showMessageDialog(null,"Verifique a lista de clientes e tente novamente");
						}
					}
					if(escolha == 1) {
						try {
							loja.buscaVendedor().listarVendas();							
						}catch(RuntimeException e){
							JOptionPane.showMessageDialog(null, "Verifique a lista de vendedores e teste novamente");
						}
						
					}
					break;
				case 5:
					int menu4 = 0;
					menu4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Buscar veículo\n"
							+ "2 - Buscar cliente\n"
							+ "3 - Buscar vendedor\n"));
					switch(menu4) {
						case 1:
							loja.exibeInformacaoVeiculo(loja.buscaVeiculo());
							break;
						case 2:
							loja.exibeInformacaoCLiente(loja.buscaCliente());
							break;
						case 3:
							loja.exibeInformacaoVendedor(loja.buscaVendedor());
							break;
						default:
							break;
					}
					
					break;
				case 6:
					loja.AlterarDadoVeiculo(JOptionPane.showInputDialog("Insira a placa do veículo que deseja alterar os dados"));
					break;
				default:
					break;
					
			}
		}
		
		

	}

}
