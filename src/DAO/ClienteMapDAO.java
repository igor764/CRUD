package DAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.Cliente;

public class ClienteMapDAO implements IClienteDAO{
	private Map<Long, Cliente> map;
	
	public ClienteMapDAO() {
		this.map = new HashMap<>();
	}
	@Override
	public Boolean cadastrar(Cliente cliente) {
		if(this.map.containsKey(cliente.getCpf())) {
		return false;
		}
		
		map.put(cliente.getCpf(), cliente);
		return true;
	}

	@Override
	public void excluir(Cliente cliente) {
		Cliente clienteCadastrado = this.map.remove(cliente.getCpf());
		 if (clienteCadastrado != null) {
		        System.out.println("Cliente excluído com sucesso");
		    } else {
		        System.out.println("Cliente não encontrado");
		    }
		}
		
	

	@Override
	public void alterar(Cliente cliente) {
		Cliente clienteCadastrado = this.map.get(cliente.getCpf());
		if(clienteCadastrado != null) {
			clienteCadastrado.setNome(cliente.getNome());
			clienteCadastrado.setCpf(cliente.getCpf());
			clienteCadastrado.setTelefone(cliente.getTelefone());
			clienteCadastrado.setEndereco(cliente.getEndereco());
			clienteCadastrado.setNumero(cliente.getNumero());
			clienteCadastrado.setCidade(cliente.getCidade());
			clienteCadastrado.setEstado(cliente.getEstado());
		
		}
		
	}

	@Override
	public Cliente consultar(Long cpf) {
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		
		return this.map.values();
	}

}
