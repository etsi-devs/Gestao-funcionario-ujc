package mz.ac.ujc.esa.boot.dao;

import org.springframework.stereotype.Repository;

import mz.ac.ujc.esa.boot.domain.Endereco;

@Repository
public class EnderecoDaoImpl extends AbstractDao<Endereco, Long> implements EnderecoDao {

    @Override
    public Endereco findbyId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
