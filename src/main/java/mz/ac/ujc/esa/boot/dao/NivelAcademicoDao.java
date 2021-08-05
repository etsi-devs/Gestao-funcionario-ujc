package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.NivelAcademico;

public interface NivelAcademicoDao {

	void save (NivelAcademico nivelAcademico);
	void update (NivelAcademico nivelAcademico);
	void delete (Long id);
	NivelAcademico findById(Long id);
	List<NivelAcademico> findAll();
}
