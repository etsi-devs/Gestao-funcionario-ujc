package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Departamento;

public interface DepartamentoDao {

	void save (Departamento departamento);
	void update (Departamento departamento);
	void delete (Long id);
	Departamento findById(Long id);
	List<Departamento> findAll();
}
