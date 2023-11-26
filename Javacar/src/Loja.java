import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Loja {
	protected ArrayList<Veiculo> ListaVeiculos = new ArrayList<>();
	protected ArrayList<Cliente> ListaClientes = new ArrayList<>();
	protected ArrayList<Vendedor> ListaVendedores = new ArrayList<>();
	protected ArrayList<Venda> ListaVendas = new ArrayList<>();
	
	public void addVeiculoTeste(Veiculo veiculo) {
		this.ListaVeiculos.add(veiculo);
	}
	
	public void addClienteTeste(Cliente cliente) {
		this.ListaClientes.add(cliente);
	}
	
	public void addVendedoresTeste(Vendedor vendedor) {
		this.ListaVendedores.add(vendedor);
	}
	
	public void CadastroVeiculo() {
		int tipo = 0;
		
		while(tipo!=1 && tipo != 2) {
			tipo = Integer.parseInt(JOptionPane.showInputDialog("Insira o tipo do veículo a ser cadastrado:\n"
					+ "1 - Carro\n"
					+ "2 - Moto"));
		}
		if(tipo == 1) {
			Carro carro = new Carro();
			carro.setNome(JOptionPane.showInputDialog("Digite o modelo do carro a ser cadastrado"));
			carro.setMarca(JOptionPane.showInputDialog("Digite a marca do carro a ser cadastrado"));
			carro.setCor(JOptionPane.showInputDialog("Digite a cor do carro a ser cadastrado"));
			carro.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro a ser cadastrado")));
			carro.setKm(Integer.parseInt(JOptionPane.showInputDialog("Digite a quilometragem do carro a ser cadastrado")));
			carro.setValor(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do carro a ser cadastrado")));
			carro.setLitragem(Integer.parseInt(JOptionPane.showInputDialog("Insira a litragem do carro")));
			carro.setPortas(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de portas")));
			if(setPlaca(JOptionPane.showInputDialog("Digite a placa do carro a ser cadastrado"),carro)) {
				ListaVeiculos.add(carro);
			}
		}else {
			Moto moto = new Moto();
			moto.setNome(JOptionPane.showInputDialog("Digite o modelo da moto a ser cadastrada"));
			moto.setMarca(JOptionPane.showInputDialog("Digite a marca da moto a ser cadastrada"));
			moto.setCor(JOptionPane.showInputDialog("Digite a cor da moto a ser cadastrada"));
			moto.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano da moto a ser cadastrada")));
			moto.setKm(Integer.parseInt(JOptionPane.showInputDialog("Digite a quilometragem da moto a ser cadastrada")));
			moto.setValor(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor da moto a ser cadastrada")));
			moto.setPartidaEletrica(JOptionPane.showConfirmDialog(null,"A moto possui partida elétrica?") == 0 ? true : false);
			moto.setCilindrada(Integer.parseInt(JOptionPane.showInputDialog("Insira as cilindradas da moto")));
			if(setPlaca(JOptionPane.showInputDialog("Digite a placa da moto a ser cadastrada"),moto)) {
				ListaVeiculos.add(moto);
			}
		}		
	}
	
	public boolean ExcluiVeiculo(String placa) {
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
	
	public boolean AlterarDadoVeiculo(String placa) {
		boolean veiculoEncontrado = false;
		
		for(Veiculo veiculo : ListaVeiculos) {
        	if(veiculo.getPlaca().equals(placa)) {
        		int opcao = 0;
        		while(opcao!=4) {
        			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n"
        					+ "1 - Alterar cor do veículo\n"
        					+ "2 - Alterar quilometragem do veículo\n"
        					+ "3 - Alterar valor do veículo\n"
        					+ "4 - Sair\n"));
        			switch(opcao) {
        			case 1://Altera cor veículo
        				veiculo.setCor(JOptionPane.showInputDialog("Insira a nova cor do veículo:"));
        				break;
        			case 2://Altera quilometragem veículo
        				veiculo.setKm(Integer.parseInt(JOptionPane.showInputDialog("Insira a quilometragem atualizada do veículo:")));
        				break;
        			case 3://Altera valor do veículo
        				veiculo.setValor(Float.parseFloat(JOptionPane.showInputDialog("Insira o novo valor do veículo:")));
        				break;
        			default:
        				break;
        			}
        		}
        		veiculoEncontrado = true;
        		break;
        	}
        }
        if(!veiculoEncontrado) {
        	JOptionPane.showMessageDialog(null, "Veículo não encontrado");
        	return false;
        }
		return true;
	}
	
	public boolean CadastroVenda() {
		Venda venda = new Venda();
		Cliente clienteComprador;
		Vendedor vendedorQueVendeu;
		
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
            	if(cliente.getCPF().trim().equals(cpf.trim())) {
            		venda.setCliente(cliente);
            		cliente.addCompra(venda);
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
        	if(veiculo.getPlaca().trim().toLowerCase().equals(placa.trim().toLowerCase())) {
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
			if(vendedor.getNome().trim().toLowerCase().equals(nomeVendedor.trim().toLowerCase())) {
				venda.setVendedor(vendedor);
				vendedor.addVenda(venda);
				break;
			}
		}
		
		ListaVendas.add(venda);
		ExcluiVeiculo(venda.getVeiculo().getPlaca());
		
		return true;
	}
	
	public Cliente CadastroCliente() {
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
		
		cliente.setCPF(cpf);	
		ListaClientes.add(cliente);
		return cliente;
	}
	
	public boolean CadastroVendedor() {
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
	
	public void ListarVeiculos() {
		if(ListaVeiculos.size()==0) {
			JOptionPane.showMessageDialog(null, "Não há veículos a serem listados");
		}else {
			for(Veiculo veiculo : ListaVeiculos) {
				String detalhes="Detalhes do Veículo\n";
				detalhes+="Veículo: " + veiculo.getNome()+ "\n";
				detalhes+="Marca: "+ veiculo.getMarca() + "\n";
				detalhes+="Ano: " + veiculo.getAno()+ "\n";
				detalhes+="Quilometragem: " + veiculo.getKm()+ "\n";
				detalhes+="Cor: " + veiculo.getCor() + "\n";
				detalhes+="Placa: " + veiculo.getPlaca()+ "\n";
				detalhes+="Valor: " + veiculo.getValor() + "\n";
				
				// Verifica se o veículo é do tipo Carro
				if (veiculo instanceof Carro) {
					Carro carro = (Carro) veiculo;
					detalhes += "Quantidade de Portas: " + carro.getPortas() + "\n";
					detalhes += "Litragem do Motor: " + carro.getLitragem() + "\n";
				}
				
				// Verifica se o veículo é do tipo Moto
				if (veiculo instanceof Moto) {
					Moto moto = (Moto) veiculo;
					detalhes += "Cilindrada: " + moto.getCilindrada() + "\n";
					detalhes += "Partida Elétrica: " + (moto.getPartidaEletrica() ? "Sim" : "Não") + "\n";
				}

	            JOptionPane.showMessageDialog(null, detalhes);
			}
		}
	}
	
	public void ListarClientes() {
		if(ListaClientes.size()==0) {
			JOptionPane.showMessageDialog(null, "Não há clientes a serem listados");
		}else {
			for(Cliente cliente : ListaClientes) {
				String detalhes="Informações do cliente\n";
				detalhes+="Nome: " + cliente.getNome()+ "\n";
				detalhes+="Endereço: "+ cliente.getEndereco() + "\n";
				detalhes+="Cidade: "+ cliente.getCidade() + "\n";
				detalhes+="Estado: " + cliente.getEstado()+ "\n";
				detalhes+="CPF: " + cliente.getCPF()+ "\n";
				JOptionPane.showMessageDialog(null, detalhes);
			}
		}
	}
	
	public void ListarVendedores() {
		if(ListaVendedores.size()==0) {
			JOptionPane.showMessageDialog(null, "Não há vendedores a serem listados");
		}else {
			for(Vendedor vendedor : ListaVendedores) {
				String detalhes="Informações do vendedor\n";
				detalhes+="Nome: " + vendedor.getNome()+ "\n";
				detalhes+="Endereço: "+ vendedor.getEndereco() + "\n";
				detalhes+="Cidade: "+ vendedor.getCidade() + "\n";
				detalhes+="Estado: " + vendedor.getEstado()+ "\n";
				JOptionPane.showMessageDialog(null, detalhes);
			}
		}
	}
	
	public void ListarVendas() {
		if(ListaVendas.size()==0) {
			JOptionPane.showMessageDialog(null, "Não há vendas a serem listados");
		}else {
			for(Venda venda : ListaVendas) {
				String detalhes="Relatório de venda\n";
				detalhes+="Nome do cliente: " + venda.getCliente().getNome()+ "\n";
				detalhes+="Nome do vendedor: "+ venda.getVendedor().getNome() + "\n";
				detalhes+="Data da venda: "+ venda.getData() + "\n";
				detalhes+="Veículo: " + venda.getVeiculo().getNome()+ "\n";
				detalhes+="Placa do Veículo: " + venda.getVeiculo().getPlaca()+ "\n";
				detalhes+="Valor: " + venda.getValor()+ "\n";
				JOptionPane.showMessageDialog(null, detalhes);
			}
		}
	}
	
	public Cliente buscaCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente");
        for(Cliente cliente : ListaClientes) {
        	if(cliente.getCPF().trim().equals(cpf.trim())) {
        		return cliente;
        	}
        }
    	JOptionPane.showMessageDialog(null, "Cliente não encontrado");
    	return null;

	}
	
	public Veiculo buscaVeiculo() {
        String placa = JOptionPane.showInputDialog("Digite a placa do veículo vendido");
        for(Veiculo veiculo : ListaVeiculos) {
        	if(veiculo.getPlaca().equals(placa.trim().toLowerCase())) {
        		return veiculo;
        	}
        }
    	JOptionPane.showMessageDialog(null, "Veículo não encontrado");
    	return null;

	}
	
	public Vendedor buscaVendedor() {
		String nomeVendedor = JOptionPane.showInputDialog("Digite o nome do vendedor");
		for(Vendedor vendedor : ListaVendedores) {
			if(vendedor.getNome().trim().toLowerCase().equals(nomeVendedor.trim().toLowerCase())) {
				return vendedor;
			}
		}
		JOptionPane.showMessageDialog(null,"Vendedor não encontrado");
		return null;
	}
	
	public boolean setPlaca(String placa, Veiculo veiculo) {
		for(var veiculos : ListaVeiculos){
			if(veiculos.getPlaca().trim().toLowerCase().equals(placa.trim().toLowerCase())) {
				JOptionPane.showMessageDialog(null, "Placa já cadastrada");
				return false;
			}
		}
		veiculo.setPlaca(placa);
		return true;
	}
	
	public void exibeInformacaoCLiente(Cliente cliente) {
		if(cliente !=null) {
			String detalhes="Informações do cliente\n";
			detalhes+="Nome: " + cliente.getNome()+ "\n";
			detalhes+="Endereço: "+ cliente.getEndereco() + "\n";
			detalhes+="Cidade: "+ cliente.getCidade() + "\n";
			detalhes+="Estado: " + cliente.getEstado()+ "\n";
			detalhes+="CPF: " + cliente.getCPF()+ "\n";
			JOptionPane.showMessageDialog(null, detalhes);
		}
	}

	public void exibeInformacaoVendedor(Vendedor vendedor) {
		if(vendedor != null) {
			String detalhes="Informações do vendedor\n";
			detalhes+="Nome: " + vendedor.getNome()+ "\n";
			detalhes+="Endereço: "+ vendedor.getEndereco() + "\n";
			detalhes+="Cidade: "+ vendedor.getCidade() + "\n";
			detalhes+="Estado: " + vendedor.getEstado()+ "\n";
			JOptionPane.showMessageDialog(null, detalhes);			
		}
	}
	
	public void exibeInformacaoVeiculo(Veiculo veiculo) {
		if(veiculo != null) {			
			String detalhes="Detalhes do Veículo\n";
			detalhes+="Veículo: " + veiculo.getNome()+ "\n";
			detalhes+="Marca: "+ veiculo.getMarca() + "\n";
			detalhes+="Ano: " + veiculo.getAno()+ "\n";
			detalhes+="Quilometragem: " + veiculo.getKm()+ "\n";
			detalhes+="Cor: " + veiculo.getCor() + "\n";
			detalhes+="Placa: " + veiculo.getPlaca()+ "\n";
			detalhes+="Valor: " + veiculo.getValor() + "\n";
			
			// Verifica se o veículo é do tipo Carro
			if (veiculo instanceof Carro) {
				Carro carro = (Carro) veiculo;
				detalhes += "Quantidade de Portas: " + carro.getPortas() + "\n";
				detalhes += "Litragem do Motor: " + carro.getLitragem() + "\n";
			}
			
			// Verifica se o veículo é do tipo Moto
			if (veiculo instanceof Moto) {
				Moto moto = (Moto) veiculo;
				detalhes += "Cilindrada: " + moto.getCilindrada() + "\n";
				detalhes += "Partida Elétrica: " + (moto.getPartidaEletrica() ? "Sim" : "Não") + "\n";
			}
			
			JOptionPane.showMessageDialog(null, detalhes);
		}
	}
	
}
