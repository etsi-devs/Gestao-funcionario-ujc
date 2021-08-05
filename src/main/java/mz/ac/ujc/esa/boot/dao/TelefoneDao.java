package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Telefone;

public interface TelefoneDao {

	void save (Telefone telefone);
	void update (Telefone telefone);
	void delete (Long id);
	Telefone findById(Long id);
	List<Telefone> findAll();
}
