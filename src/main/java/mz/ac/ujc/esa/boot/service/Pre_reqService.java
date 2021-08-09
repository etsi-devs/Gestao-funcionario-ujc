package mz.ac.ujc.esa.boot.service;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Pre_req;

public interface Pre_reqService {

    void salvar(Pre_req pre_req);

    void editar(Pre_req pre_req);

    void excluir(Long id);

    Pre_req buscarPorId(Long id);

    List<Pre_req> buscarTodos();
}
