package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.ReqFerias;

public interface ReqFeriasDao {

	void save (ReqFerias reqFerias);
	void update (ReqFerias reqFerias);
	void delete (Long id);
	ReqFerias findbyId(Long id);
	List<ReqFerias> findAll();
}
