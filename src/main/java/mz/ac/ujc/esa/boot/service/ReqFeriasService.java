package mz.ac.ujc.esa.boot.service;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.ReqFerias;

public interface ReqFeriasService {

	void salvar(ReqFerias reqFerias);
	void editar (ReqFerias reqFerias);
	void excluir (Long id);
	ReqFerias buscarPorId(Long id);
	List<ReqFerias>buscarTodos();
}
