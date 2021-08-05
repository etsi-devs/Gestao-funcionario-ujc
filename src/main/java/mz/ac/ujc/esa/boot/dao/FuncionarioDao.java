package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Funcionario;

public interface FuncionarioDao {


	void save (Funcionario funcionario);
	void update (Funcionario funcionario);
	void delete (Long id);
	Funcionario findById(Long id);
	List<Funcionario> findAll();
}
