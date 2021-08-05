package mz.ac.ujc.esa.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.ac.ujc.esa.boot.domain.Pre_req;
import mz.ac.ujc.esa.boot.service.Pre_reqService;

@Controller
@RequestMapping("/requisitantes")
public class Pre_reqController {

    @Autowired
    private Pre_reqService pre_reqService;

    /**
     * SECCAO PARA CADASTRO DO requisicoes do funcionario
     */

    @GetMapping("cadastrar")
    public String cadastrar(Pre_req pre_req) {

        return "/admin/pages/funcionarios/add-requi";
    }

    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("requisitadass", pre_reqService.buscarTodos());
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
        model.addAttribute("requisitadas", pre_reqService.buscarPorId(id));

        return "/admin/pages/funcionarios/add-requi";
    }

    @PostMapping("editar")
    public String actualizar(Pre_req pre_req, RedirectAttributes atrr) {
        pre_reqService.editar(pre_req);
        atrr.addFlashAttribute("success", "Requisicao actualizada com sucesso.");
        return "redirect:/requisitantes/listar";
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

        pre_reqService.excluir(id);

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
    public String gravar(Pre_req pre_req, RedirectAttributes atrr) {
        pre_reqService.salvar(pre_req);
        atrr.addFlashAttribute("success", "Requisicao cadastrado com sucesso.");
        return "redirect:/requisitantes/cadastrar";
    }
}
