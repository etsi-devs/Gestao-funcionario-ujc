package mz.ac.ujc.esa.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mz.ac.ujc.esa.boot.domain.ReqFerias;

public interface IReqFeriasRepository extends JpaRepository<ReqFerias, Long> {

    // @Modifying
    // @Query("update req_ferias rf set rf.estado = :estado where rf.id = :id")
    // public void aprovar(@Param(value = "id") long id, @Param(value = "estado")
    // String estado);
}
