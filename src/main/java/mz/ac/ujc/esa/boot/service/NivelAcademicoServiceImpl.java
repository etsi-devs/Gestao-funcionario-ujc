package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.NivelAcademicoDao;
import mz.ac.ujc.esa.boot.domain.NivelAcademico;

@Service
@Transactional(readOnly = false)
public class NivelAcademicoServiceImpl implements NivelAcademicoService{

	@Autowired(required=false)
	private NivelAcademicoDao dao;
	
	@Override
	public void salvar(NivelAcademico nivelAcademico) {
		// TODO Auto-generated method stub
		dao.save(nivelAcademico);
		
	}

	@Override
	public void editar(NivelAcademico nivelAcademico) {
		// TODO Auto-generated method stub
		dao.update(nivelAcademico);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public NivelAcademico buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<NivelAcademico> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
