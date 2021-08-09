package mz.ac.ujc.esa.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.ac.ujc.esa.boot.domain.Cargo;
import mz.ac.ujc.esa.boot.domain.Departamento;
import mz.ac.ujc.esa.boot.domain.Funcionario;
import mz.ac.ujc.esa.boot.service.CargoService;
import mz.ac.ujc.esa.boot.service.DepartamentoService;
import mz.ac.ujc.esa.boot.service.FuncionarioService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping("cadastrar")
	public String cadastrar(Cargo cargo) {

		return "/admin/pages/cargos/add-cargo";
	}

	@GetMapping("listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.pesquisarTodos());
		return "/admin/pages/cargos/list-cargo";
	}

	/**
	 * Metodo de pre actualizacao de registo de cargos com recurso ao metodo
	 * actualizar que faz o redirecionamento
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("editar/{id}")
	public String preActualizar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.pesquisarPorId(id));

		return "/admin/pages/cargos/add-cargo";
	}

	@PostMapping("editar")
	public String actualizar(Cargo cargo, RedirectAttributes atrr) {
		cargoService.editar(cargo);
		atrr.addFlashAttribute("success", "Cargo actualizado com sucesso.");
		return "redirect:/cargos/listar";
	}

	/**
	 * Metodo que permite excluir um departamento com base no seu id e somente se
	 * ele nao tiver cargos vinculados a ele
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("apagar/{id}")
	public String apagar(@PathVariable("id") Long id, ModelMap model) {

		if (cargoService.cargoTemFuncionarios(id)) {
			model.addAttribute("fail", "Cargo nao pode ser removido. Possui Funcionario(s) Vinculado(s) a ele.");
		} else {
			cargoService.apagar(id);
			model.addAttribute("success", "Cargo removido com sucesso.");

		}

		return listar(model);
	}

	/**
	 * metodo para fazer o registo de cargos com recurso ao formulario de cadastro
	 * no redir
	 * 
	 * @param departamento
	 * @return
	 */
	@PostMapping("gravar")
	public String gravar(Cargo cargo, RedirectAttributes atrr) {
		cargoService.registar(cargo);
		atrr.addFlashAttribute("success", "Cargo cadastrado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}

	/**
	 * Metodo para listar todos os departamentos e mostrar na combobox presente no
	 * formulario
	 * 
	 * @return
	 */
	@ModelAttribute("departamentos")
	public List<Departamento> listaDepartamentos() {
		return departamentoService.pesquisarTodos();
	}

	/**
	 * Metodo para listar todos os funcionarios e mostrar na combobox presente no
	 * formulario
	 * 
	 * @return
	 */
	@ModelAttribute("funcionarios")
	public List<Funcionario> listaFuncionarios() {
		return funcionarioService.pesquisarTodos();
	}
}
