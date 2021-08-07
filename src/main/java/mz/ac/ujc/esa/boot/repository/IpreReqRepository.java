package mz.ac.ujc.esa.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mz.ac.ujc.esa.boot.domain.Pre_req;

public interface IpreReqRepository extends JpaRepository<Pre_req, Long> {

    @Query(value = "SELECT * FROM pre_req WHERE id=:Id", nativeQuery = true)
    public Pre_req getRequisicaoById(@Param("Id") Long Id);

    @Query(value = "SELECT * FROM pre_req WHERE funcionario_id_fk=:codigo", nativeQuery = true)
    public Pre_req getRequisicaoByPerson(@Param("codigo") Long codigo);
}
