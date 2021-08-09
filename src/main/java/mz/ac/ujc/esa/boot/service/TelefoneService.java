package mz.ac.ujc.esa.boot.service;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Telefone;

public interface TelefoneService {

	void salvar(Telefone telefone);
	void editar (Telefone telefone);
	void excluir (Long id);
	Telefone buscarPorId(Long id);
	List<Telefone>buscarTodos();
}
