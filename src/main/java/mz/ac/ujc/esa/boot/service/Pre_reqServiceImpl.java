package mz.ac.ujc.esa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.ac.ujc.esa.boot.dao.Pre_reqDao;
import mz.ac.ujc.esa.boot.domain.Pre_req;

@Service
@Transactional(readOnly = false)
public class Pre_reqServiceImpl implements Pre_reqService {

    @Autowired
    private Pre_reqDao dao;

    @Override
    public void salvar(Pre_req pre_req) {
        dao.save(pre_req);
    }

    @Override
    public void editar(Pre_req pre_req) {

        dao.update(pre_req);
    }

    @Override
    public void excluir(Long id) {

        dao.delete(id);
    }

    @Override
    public Pre_req buscarPorId(Long id) {

        return dao.findbyId(id);
    }

    @Override
    public List<Pre_req> buscarTodos() {

        return dao.findAll();
    }

}
