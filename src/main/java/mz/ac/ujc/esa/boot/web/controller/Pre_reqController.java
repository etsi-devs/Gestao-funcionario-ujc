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
import mz.ac.ujc.esa.boot.domain.ReqFerias;
import mz.ac.ujc.esa.boot.repository.IpreReqRepository;
import mz.ac.ujc.esa.boot.service.Pre_reqService;
import mz.ac.ujc.esa.boot.service.ReqFeriasService;

@Controller
@RequestMapping("/requisitantes")
public class Pre_reqController {

    @Autowired
    private Pre_reqService pre_reqService;

    @Autowired
    private IpreReqRepository preReqRepository;

    @Autowired
    ReqFeriasService reqFeriasService;

    /**
     * SECCAO PARA CADASTRO DO requisicoes do funcionario
     */

    @GetMapping("cadastrar")
    public String cadastrar(Pre_req pre_req) {

        return "/admin/pages/funcionarios/add-requi";
    }

    @GetMapping("listar-requisicoes/{codigo}")
    public String requisicoes(@PathVariable("codigo") Long codigo, ModelMap model) {
        model.addAttribute("minhas", preReqRepository.getRequisicaoByPerson(codigo));
        return "/admin/pages/funcionarios/list-requi";
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
        model.addAttribute("pre_req", pre_reqService.buscarPorId(id));

        return "/admin/pages/funcionarios/add-requi";
    }

    @PostMapping("editar")
    public String actualizar(Pre_req pre_req, RedirectAttributes atrr) {
        pre_reqService.editar(pre_req);
        atrr.addFlashAttribute("success", "Requisicao actualizada com sucesso.");
        return "redirect:/requisitantes/listar-requisicoes/{codigo}";
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

    /**
     * SECCAO PARA LISTAGEM E EDICAO REQUISICOES DO FUNCIONARIO
     */

    /**
     * SECCAO PARA GESTOR IMEDIATO
     */
    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("requisitadass", pre_reqService.buscarTodos());
        return "/admin/pages/req-ferias/requi-gestor";
    }

    /**
     * METODO PARA FAZER UPDATE NO ESTADO DA REQUISICAO DO FUNIONARIO
     * 
     * @return
     */
    @GetMapping("aprovar/{id}")
    public String aprovar(@PathVariable("id") Long id, ModelMap model, RedirectAttributes atrr) {

        // busca a pre requisicao na bd e faz um update
        Pre_req requisicao = preReqRepository.getRequisicaoById(id);

        requisicao.setEstado("Aprovado");
        pre_reqService.editar(requisicao);

        // passa a requisicao para os rh
        Pre_req temp = preReqRepository.getRequisicaoById(id);
        ReqFerias requi = new ReqFerias();

        requi.setData_fim(temp.getData_fim());
        requi.setData_inicio(temp.getData_inicio());
        requi.setEstado(temp.getEstado());
        requi.setFuncionario(temp.getFuncionario());

        reqFeriasService.salvar(requi);

        model.addAttribute("requisitadass", pre_reqService.buscarTodos());
        atrr.addFlashAttribute("success", "Estado alterado com sucesso!.");

        return "/admin/pages/req-ferias/requi-gestor";

    }

    @GetMapping("reprovar/{id}")
    public String reprovar(@PathVariable("id") Long id, ModelMap model, RedirectAttributes atrr) {

        Pre_req requisicao = preReqRepository.getRequisicaoById(id);

        requisicao.setEstado("Reprovado");
        pre_reqService.editar(requisicao);
        model.addAttribute("requisitadass", pre_reqService.buscarTodos());
        atrr.addFlashAttribute("success", "Estado alterado com sucesso!.");
        return "/admin/pages/req-ferias/requi-gestor";
    }
}
