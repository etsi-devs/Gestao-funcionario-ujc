package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.DepartamentoDao;
import mz.ac.ujc.esa.boot.domain.Departamento;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired(required=false)
	private DepartamentoDao dao;
	
	@Override
	public void registar(Departamento departamento) {
		dao.save(departamento);
		
	}

	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);		
	}

	@Override
	public void apagar(Long id) {
dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Departamento pesquisarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Departamento> pesquisarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		if (pesquisarPorId(id).getCargos().isEmpty()){
			return false;
		}
		return true;
	}

}
