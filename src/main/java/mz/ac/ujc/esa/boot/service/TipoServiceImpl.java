package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.TipoDao;
import mz.ac.ujc.esa.boot.domain.Tipo;

@Service
@Transactional(readOnly = false)
public class TipoServiceImpl implements TipoService{

	@Autowired (required=false)
	private TipoDao dao;
	
	@Override
	public void salvar(Tipo tipo) {
		// TODO Auto-generated method stub
		dao.save(tipo);
	}

	@Override
	public void editar(Tipo tipo) {
		// TODO Auto-generated method stub
		dao.update(tipo);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Tipo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Tipo> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
