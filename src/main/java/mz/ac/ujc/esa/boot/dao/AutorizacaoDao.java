package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Autorizacao;

public interface AutorizacaoDao {

	void save (Autorizacao autorizacao);
	void update (Autorizacao autorizacao);
	void delete (Long id);
	Autorizacao findById(Long id);
	List<Autorizacao> findAll();
}
