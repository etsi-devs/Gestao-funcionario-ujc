package mz.ac.ujc.esa.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mz.ac.ujc.esa.boot.domain.Funcionario;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // @Query(value = "SELECT f.nome. f.data_nasc, from funcionarios f where f.id =
    // :Id", nativeQuery = true)
    // // public List<Funcionario> listaFuncionarios(@Param("Id") Long Id);
    // public List<Funcionario> listaFuncionarios(Long Id);

    // List<Funcionario> buscarPorNome(String nome);
}