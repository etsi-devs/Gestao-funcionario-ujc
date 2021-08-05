package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Faculdade;

public interface FaculdadeDao {

	
	void save (Faculdade faculdade);
	void updade (Faculdade faculdade);
	void delete (Long id);
	Faculdade findById(Long id);
	List<Faculdade> findAll();
	
}
