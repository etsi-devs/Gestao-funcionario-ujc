package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.AutorizacaoDao;
import mz.ac.ujc.esa.boot.domain.Autorizacao;

@Service
@Transactional(readOnly = false)
public class AutorizacaoServiceImpl implements AutorizacaoService{
	
	@Autowired(required=false)
	private AutorizacaoDao dao;

	@Override
	public void registar(Autorizacao autorizacao) {
		dao.save(autorizacao);
		
	}

	@Override
	public void editar(Autorizacao autorizacao) {
		dao.update(autorizacao);		
	}

	@Override
	public void apagar(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Autorizacao pesquisarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Autorizacao> pesquisarTodos() {
		return dao.findAll();
	}

}
