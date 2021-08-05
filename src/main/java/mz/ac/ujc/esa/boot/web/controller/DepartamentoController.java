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

import mz.ac.ujc.esa.boot.domain.Departamento;
import mz.ac.ujc.esa.boot.domain.Faculdade;
import mz.ac.ujc.esa.boot.service.DepartamentoService;
import mz.ac.ujc.esa.boot.service.FaculdadeService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private FaculdadeService faculdadeService;

    @GetMapping("cadastrar")
    public String cadastrar(Departamento departamento) {

        return "/admin/pages/departamentos/add-departamento";
    }

    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("departamentos", departamentoService.pesquisarTodos());
        return "/admin/pages/departamentos/list-departamento";
    }

    /**
     * Metodo de pre actualizacao de registo de departamentos com recurso ao metodo
     * actualizar que faz o redirecionamento
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editar/{id}")
    public String preActualizar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("departamento", departamentoService.pesquisarPorId(id));

        return "/admin/pages/departamentos/add-departamento";
    }

    @PostMapping("editar")
    public String actualizar(Departamento departamento, RedirectAttributes atrr) {
        departamentoService.editar(departamento);
        atrr.addFlashAttribute("success", "Departamento actualizado com sucesso.");
        return "redirect:/departamentos/cadastrar";
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

        if (departamentoService.departamentoTemCargos(id)) {
            model.addAttribute("fail", "Departamento nao pode ser removido. Possui Cargo(s) Vinculado(s) a ele.");
        } else {
            departamentoService.apagar(id);
            model.addAttribute("success", "Departamento removido com sucesso.");

        }

        return listar(model);
    }

    /**
     * metodo para fazer o registo de departamentos com recurso ao formulario de
     * cadastro mo redir
     * 
     * @param departamento
     * @return
     */
    @PostMapping("gravar")
    public String gravar(Departamento departamento, RedirectAttributes atrr) {
        departamentoService.registar(departamento);
        atrr.addFlashAttribute("success", "Departamento cadastrado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    /**
     * Metodo para listar todos os departamentos e mostrar na combobox presente no
     * formulario
     * 
     * @return
     */
    @ModelAttribute("faculdades")
    public List<Faculdade> listaFaculdades() {
        return faculdadeService.buscarTodos();
    }
}
