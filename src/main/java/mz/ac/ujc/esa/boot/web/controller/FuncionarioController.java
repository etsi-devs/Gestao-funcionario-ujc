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
import mz.ac.ujc.esa.boot.domain.NivelAcademico;
import mz.ac.ujc.esa.boot.domain.Tipo;
import mz.ac.ujc.esa.boot.repository.IFuncionarioRepository;
import mz.ac.ujc.esa.boot.service.CargoService;
import mz.ac.ujc.esa.boot.service.DepartamentoService;
import mz.ac.ujc.esa.boot.service.FuncionarioService;
import mz.ac.ujc.esa.boot.service.NivelAcademicoService;
import mz.ac.ujc.esa.boot.service.TipoService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private TipoService tipoService;

    @Autowired
    private NivelAcademicoService nivelAcademicoService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    IFuncionarioRepository iFuncionarioRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Funcionario funcionario) {

        return "/admin/pages/funcionarios/add-func";
    }

    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.pesquisarTodos());
        return "/admin/pages/funcionarios/list-func";
    }

    /**
     * Metodo de pre actualizacao de registo de funcionarios com recurso ao metodo
     * actualizar que faz o redirecionamento
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editar/{id}")
    public String preActualizar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.pesquisarPorId(id));

        return "/admin/pages/funcionarios/add-func";
    }

    @PostMapping("editar")
    public String actualizar(Funcionario funcionario, RedirectAttributes atrr) {
        funcionarioService.editar(funcionario);
        atrr.addFlashAttribute("success", "Funcionario actualizado com sucesso.");
        return "redirect:/funcionarios/listar";
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
            model.addAttribute("fail", "Funcionario nao pode ser removido. Possui Cargos(s) Vinculado(s) a ele.");
        } else {
            cargoService.apagar(id);
            model.addAttribute("success", "Funcionario removido com sucesso.");

        }

        return listar(model);
    }

    @GetMapping("/pesquisar/{nome}")
    public List<Funcionario> pesquisarNome(@PathVariable String nome) {
        return iFuncionarioRepository.buscarPorNome(nome);
    }

    /**
     * SECCAO PARA CADASTRO DE REQUISICOES DO FUNCIONARIO
     */
    @GetMapping("minhas")
    public String requisicoesFunc() {

        return "/admin/pages/funcionarios/list-requi";
    }

    @GetMapping("requisitar")
    public String requisitar() {

        return "/admin/pages/funcionarios/add-requi";
    }

    /**
     * SECCAO PARA CADASTRO DE REQUISICOES DO FUNCIONARIO
     */

    /**
     * metodo para fazer o registo de cargos com recurso ao formulario de cadastro
     * no redir
     * 
     * @param departamento
     * @return
     */
    @PostMapping("gravar")
    public String gravar(Funcionario funcionario, RedirectAttributes atrr) {
        funcionarioService.registar(funcionario);
        atrr.addFlashAttribute("success", "Funcionario cadastrado com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    /**
     * Metodo para listar todos os Cargos e mostrar na combobox presente no
     * formulario
     * 
     * @return
     */
    @ModelAttribute("cargos")
    public List<Cargo> listaCargos() {
        return cargoService.pesquisarTodos();
    }

    /**
     * Metodo para listar todos os Tipos e mostrar na combobox presente no
     * formulario
     * 
     * @return
     */
    @ModelAttribute("tipos")
    public List<Tipo> listaFuncionarios() {
        return tipoService.buscarTodos();
    }

    /**
     * Metodo para listar todos os niveis academicos e mostrar na combobox presente
     * no formulario
     * 
     * @return
     */
    @ModelAttribute("niveis")
    public List<NivelAcademico> listaNiveis() {
        return nivelAcademicoService.buscarTodos();
    }

    /**
     * Metodo para listar todos os niveis academicos e mostrar na combobox presente
     * no formulario
     * 
     * @return
     */
    @ModelAttribute("departamentos")
    public List<Departamento> listaDepartamentos() {
        return departamentoService.pesquisarTodos();
    }
}
