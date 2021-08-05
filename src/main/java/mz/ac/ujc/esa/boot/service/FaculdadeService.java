package mz.ac.ujc.esa.boot.service;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Faculdade;

public interface FaculdadeService {

	void salvar(Faculdade faculdade);
	void editar (Faculdade faculdade);
	void excluir (Long id);
	Faculdade buscarPorId(Long id);
	List<Faculdade>buscarTodos();
}
