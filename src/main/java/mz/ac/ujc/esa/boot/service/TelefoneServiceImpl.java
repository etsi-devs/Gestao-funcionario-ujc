package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.TelefoneDao;
import mz.ac.ujc.esa.boot.domain.Telefone;

@Service
@Transactional(readOnly = false)
public class TelefoneServiceImpl implements TelefoneService{

	@Autowired(required=false)
	private TelefoneDao dao;
	
	@Override
	public void salvar(Telefone telefone) {
		// TODO Auto-generated method stub
		dao.save(telefone);
	}

	@Override
	public void editar(Telefone telefone) {
		// TODO Auto-generated method stub
		dao.update(telefone);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Telefone buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Telefone> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
