package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.FaculdadeDao;
import mz.ac.ujc.esa.boot.domain.Faculdade;

@Service
@Transactional(readOnly = false)
public class FaculdadeServiceImpl implements FaculdadeService{

	@Autowired(required=false)
	private FaculdadeDao dao;
	
	@Override
	public void salvar(Faculdade faculdade) {
		dao.save(faculdade);
	}

	@Override
	public void editar(Faculdade faculdade) {
		dao.updade(faculdade);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Faculdade buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Faculdade> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
