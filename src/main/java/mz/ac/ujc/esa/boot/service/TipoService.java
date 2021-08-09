package mz.ac.ujc.esa.boot.service;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Tipo;

public interface TipoService {

	void salvar(Tipo tipo);
	void editar (Tipo tipo);
	void excluir (Long id);
	Tipo buscarPorId(Long id);
	List<Tipo>buscarTodos();
}
