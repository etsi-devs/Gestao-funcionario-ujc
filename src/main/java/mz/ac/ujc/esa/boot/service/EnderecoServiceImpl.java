package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.EnderecoDao;
import mz.ac.ujc.esa.boot.domain.Endereco;

@Service
@Transactional(readOnly = false)
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired(required=false)
	private EnderecoDao dao;
	
	@Override
	public void salvar(Endereco endereco) {
		dao.save(endereco);
	}

	@Override
	public void editar(Endereco endereco) {
		dao.update(endereco);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Endereco buscarPorId(Long id) {
		return dao.findbyId(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Endereco> buscarTodos() {
		return dao.findAll();
	}

}
