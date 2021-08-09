package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.ReqFeriasDao;
import mz.ac.ujc.esa.boot.domain.ReqFerias;

@Service
@Transactional(readOnly = false)
public class ReqFeriasServiceImpl implements ReqFeriasService{

	@Autowired(required=false)
	private ReqFeriasDao dao;
	
	@Override
	public void salvar(ReqFerias reqFerias) {
		// TODO Auto-generated method stub
		dao.save(reqFerias);
	}

	@Override
	public void editar(ReqFerias reqFerias) {
		// TODO Auto-generated method stub
		dao.update(reqFerias);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public ReqFerias buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findbyId(id);
	}

	@Override @Transactional(readOnly = true)
	public List<ReqFerias> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
