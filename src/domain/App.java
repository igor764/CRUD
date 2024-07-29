package domain;

import javax.swing.JOptionPane;

import DAO.ClienteMapDAO;
import DAO.IClienteDAO;

public class App {
	private static IClienteDAO iClienteDAO;
	
	public static void main(String[] args) {
		iClienteDAO = new ClienteMapDAO();
		
		String opçao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar,"
				+ "3 para exclusão, 4 para alteração ou 5 para sair", "Grenn Dinner", JOptionPane.INFORMATION_MESSAGE);
				
	
	
	while(!isOpçaoValida(opçao)) {
		if("".equals(opçao)) {
			 sair();
		}
		
		opçao = JOptionPane.showInputDialog(null, " Opção inválida digite 1 para cadastro, 2 para consultar,"
				+ "3 para exclusão, 4 para alteração ou 5 para sair",
				"Grenn Dinner", JOptionPane.INFORMATION_MESSAGE);}
	
	
	while(isOpçaoValida(opçao)) {
		if(isOpçaoSair(opçao)) {
			sair();
		} else if(isCadastro(opçao)) {
			String dados = JOptionPane.showInputDialog(null, " Digite os dados do cliente separados por vírgula, conforme exemplo"
					+ "nome,cpf,telefone,endereço,numero,cidade,estado",
					"Cadastro", JOptionPane.INFORMATION_MESSAGE);
			
			cadastrar(dados);}
		  else if(isConsultar(opçao)) {
			  String dados = JOptionPane.showInputDialog(null, " Digite o cpf", "Consultar", JOptionPane.INFORMATION_MESSAGE);
			  consultar(dados);
		} else if(isExcluir(opçao)) {
			String dados = JOptionPane.showInputDialog(null, " Digite o cpf", "Consultar", JOptionPane.INFORMATION_MESSAGE);
			  excluir(dados);
		} else if(isAlterar(opçao)) {
			String dados = JOptionPane.showInputDialog(null, " Digite o cpf do cliente que quer alterar", "Alterar", JOptionPane.INFORMATION_MESSAGE);
			alterar(dados);
		}
		
		 opçao = JOptionPane.showInputDialog(null,
                 "Digite 1 para cadastro, 2 para consulta, 3 para exclusao , 4 para alteração ou 5 para sair",
                 "Green dinner", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	}
		
	private static void alterar(String dados) {
		Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
		if(cliente != null) {
			String novosDados = JOptionPane.showInputDialog(null, "Digite os novos dados do cliente separados por vírgula, conforme exemplo: "
                    + "nome,cpf,telefone,endereço,numero,cidade,estado",
                    "Alterar", JOptionPane.INFORMATION_MESSAGE);
			String[] dadosSeparados = novosDados.split(",");
			String nome = dadosSeparados[0];
		    Long cpf = Long.parseLong(dadosSeparados[1].trim());
		    Long telefone = Long.parseLong(dadosSeparados[2].trim());
		    String endereco = dadosSeparados[3];
		    Integer numero = Integer.parseInt(dadosSeparados[4].trim());
		    String cidade = dadosSeparados[5];
		    String estado = dadosSeparados[6];
			Cliente clienteAtualizado = new Cliente(nome,cpf,telefone,endereco,numero,cidade,estado);
			iClienteDAO.alterar(clienteAtualizado);
			JOptionPane.showMessageDialog(null, "Cliente alterado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "cliente não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);

		}
		
	}

	private static boolean isAlterar(String opçao) {
		if("4".equals(opçao)) {
			return true;
		}
		return false;
	}

	private static boolean isExcluir(String opçao) {
		if("3".equals(opçao)) {
			return true;
		}
		return false;
	}

	private static void excluir(String dados) {
		Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
		if(cliente !=null) {
		 iClienteDAO.excluir(cliente);
			JOptionPane.showMessageDialog(null, "cliente excluido", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "cliente não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	

	private static void consultar(String dados) {
		Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
		if(cliente!= null) {
			JOptionPane.showMessageDialog(null, "Cliente encontrado" + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado" + cliente.toString(), "Erro", JOptionPane.INFORMATION_MESSAGE);
		}
	}



	private static void cadastrar(String dados) {
		String [] dadosSeparados = dados.split(",");
		String nome = dadosSeparados[0];
	    Long cpf = Long.parseLong(dadosSeparados[1].trim());
	    Long telefone = Long.parseLong(dadosSeparados[2].trim());
	    String endereco = dadosSeparados[3];
	    Integer numero = Integer.parseInt(dadosSeparados[4].trim());
	    String cidade = dadosSeparados[5];
	    String estado = dadosSeparados[6];
		
		Cliente cliente = new Cliente(nome,cpf,telefone,endereco,numero,cidade,estado);
		Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
		if(isCadastrado) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE );
		} else {
			JOptionPane.showMessageDialog(null, "Cliente já cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE );
		}
	}



	private static boolean isConsultar(String opçao) {
		if("2".equals(opçao)) {
			return true;
		}
		return false;
	}



	private static boolean isCadastro(String opçao) {
		if("1".equals(opçao)) {
			return true;
		}
		return false;
	}



	private static boolean isOpçaoSair(String opçao) {
		if("5".equals(opçao)) {
			return true;
		}
		return false;
	}



	private static void sair() {
		JOptionPane.showMessageDialog(null, "Até logo: ", "Sair", JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
	}



	private static boolean isOpçaoValida(String opçao) {
		if("1".equals(opçao)|| "2".equals(opçao)|| "3".equals(opçao)|| "4".equals(opçao)|| "5".equals(opçao)) {
			return true;
		}
		return false;
		
	}

}
