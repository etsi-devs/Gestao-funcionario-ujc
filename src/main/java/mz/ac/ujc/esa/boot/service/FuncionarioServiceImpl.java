package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.FuncionarioDao;
import mz.ac.ujc.esa.boot.domain.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired(required = false)
	private FuncionarioDao dao;

	@Autowired(required = false)
	private CargoService cargoService;

	@Override
	public void registar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Override
	public void apagar(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario pesquisarPorId(Long id) {

		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> pesquisarTodos() {

		return dao.findAll();
	}

	@Override
	public boolean funcionariosTemCargo(Long id) {
		if (cargoService.cargoTemFuncionarios(id)) {
			return false;
		}
		return true;
	}

}
