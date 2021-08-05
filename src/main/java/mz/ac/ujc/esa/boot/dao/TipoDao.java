package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Tipo;

public interface TipoDao {
	
	void save (Tipo tipo);
	void update (Tipo tipo);
	void delete (Long id);
	Tipo findById(Long id);
	List<Tipo> findAll();

}
