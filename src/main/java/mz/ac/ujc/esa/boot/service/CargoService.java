package mz.ac.ujc.esa.boot.service;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Cargo;

public interface CargoService {

	void registar(Cargo cargo);

	void editar(Cargo cargo);

	void apagar(Long id);

	Cargo pesquisarPorId(Long id);

	List<Cargo> pesquisarTodos();

	boolean cargoTemFuncionarios(Long id);
}
