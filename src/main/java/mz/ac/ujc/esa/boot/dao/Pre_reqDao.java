package mz.ac.ujc.esa.boot.dao;

import java.util.List;

import mz.ac.ujc.esa.boot.domain.Pre_req;

public interface Pre_reqDao {

    void save(Pre_req pre_req);

    void update(Pre_req pre_req);

    void delete(Long id);

    Pre_req findbyId(Long id);

    List<Pre_req> findAll();
}
