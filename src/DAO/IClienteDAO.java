package DAO;

import java.util.Collection;

import domain.Cliente;

public interface IClienteDAO {
	public Boolean cadastrar(Cliente cliente);
	public void excluir(Cliente cliente);
	public void alterar(Cliente cliente);
	public Cliente consultar(Long cpf);
	public Collection<Cliente> buscarTodos();
	
}
