package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.CargoDao;
import mz.ac.ujc.esa.boot.domain.Cargo;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired(required = false)
	private CargoDao dao;

	@Override
	public void registar(Cargo cargo) {
		dao.save(cargo);

	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);

	}

	@Override
	public void apagar(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo pesquisarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> pesquisarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {

		if (pesquisarPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}

}
