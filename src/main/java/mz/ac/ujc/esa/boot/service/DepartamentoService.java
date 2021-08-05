package mz.ac.ujc.esa.boot.service;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Departamento;

public interface DepartamentoService {

	void registar(Departamento departamento);
	void editar (Departamento departamento);
	void apagar (Long id);
	Departamento pesquisarPorId(Long id);
	List<Departamento>pesquisarTodos();
    boolean departamentoTemCargos(Long id);
}
