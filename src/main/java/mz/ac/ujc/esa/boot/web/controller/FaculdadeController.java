package mz.ac.ujc.esa.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.ac.ujc.esa.boot.domain.Faculdade;
import mz.ac.ujc.esa.boot.service.FaculdadeService;

@Controller
@RequestMapping("/faculdades")
public class FaculdadeController {

    @Autowired
    private FaculdadeService faculdadeService;

    @GetMapping("cadastrar")
    public String cadastrar(Faculdade faculdade) {

        return "/admin/pages/faculdades/add-faculdade";
    }

    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("faculdades", faculdadeService.buscarTodos());
        return "/admin/pages/faculdades/list-faculdade";
    }

    /**
     * Metodo de pre actualizacao de registo de Faculdades com recurso ao metodo
     * actualizar que faz o redirecionamento
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editar/{id}")
    public String preActualizar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("faculdade", faculdadeService.buscarPorId(id));

        return "/admin/pages/faculdades/add-faculdade";
    }

    @PostMapping("editar")
    public String actualizar(Faculdade faculdade, RedirectAttributes atrr) {
        faculdadeService.editar(faculdade);
        atrr.addFlashAttribute("success", "Faculdade actualizada com sucesso.");
        return "redirect:/faculdades/listar";
    }

    @GetMapping("apagar")
    public String apagar(@PathVariable("id") Long id, ModelMap model) {

        // if (faculdadeService.faculdadeTemDepartamentos(id)) {
        // model.addAttribute("fail",
        // "Faculdade nao pode ser removido. Possui Departamentos(s) ou Cargo(s)
        // Vinculado(s) a ele.");
        // } else {
        faculdadeService.excluir(id);
        model.addAttribute("success", "Funcionario removido com sucesso.");
        return "redirect:/faculdades/list-faculdade";
        // }

        // return listar(model);

    }

    /**
     * metodo para fazer o registo de faculdades com recurso ao formulario de
     * cadastro no redir
     * 
     * @param departamento
     * @return
     */
    @PostMapping("gravar")
    public String gravar(Faculdade faculdade, RedirectAttributes atrr) {
        faculdadeService.salvar(faculdade);
        atrr.addFlashAttribute("success", "Faculdade cadastrada com sucesso.");
        return "redirect:/faculdades/cadastrar";
    }
}
