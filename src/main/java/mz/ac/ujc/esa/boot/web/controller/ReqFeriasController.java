package mz.ac.ujc.esa.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.ac.ujc.esa.boot.domain.ReqFerias;
import mz.ac.ujc.esa.boot.repository.IReqFeriasRepository;
import mz.ac.ujc.esa.boot.service.ReqFeriasService;

@Controller
@RequestMapping("/requisicoes")
public class ReqFeriasController {

    @Autowired
    ReqFeriasService reqFeriasService;

    @Autowired
    IReqFeriasRepository iReqFeriasRepository;

    ReqFerias requisicao = new ReqFerias();

    public ReqFerias getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(ReqFerias requisicao) {
        this.requisicao = requisicao;
    }

    /** SECCAO DO ADMIN */

    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("requisicoesAdmin", reqFeriasService.buscarTodos());
        return "/admin/pages/req-ferias/requisicoes";
    }

    /**
     * METODO PARA FAZER UPDATE NO ESTADO DA REQUISICAO DO FUNIONARIO
     * 
     * @return
     */
    @GetMapping("aprovar/{id}")
    public String autorizar(@PathVariable("id") Long id) {
        System.out.println("id certo" + id);

        requisicao = reqFeriasService.buscarPorId(id);
        if (requisicao == null) {
            System.out.println("Vazio");
        } else {
            String estado = "Aprovado";
            System.out.println(requisicao.getEstado());
            requisicao.setEstado(estado);
            reqFeriasService.salvar(requisicao);
            // iReqFeriasRepository.aprovar(requisicao.getId(), estado);
        }

        return "/admin/pages/req-ferias/requisicoes";

    }

    // @GetMapping("editar/{id}")
    // public String preActualizar(@PathVariable("id") Long id, ModelMap model) {
    // model.addAttribute("faculdade", faculdadeService.buscarPorId(id));

    // return "/admin/pages/faculdades/add-faculdade";
    // }

    @GetMapping("reprovar")
    public String reprovar() {

        return "/admin/pages/req-ferias/requisicoes";
    }

    /** SECCAO DO FUNCIONARIO */
    @GetMapping("actualizar")
    public String actualizar() {

        return "/admin/pages/departamentos/edit-departamento";
    }
}
