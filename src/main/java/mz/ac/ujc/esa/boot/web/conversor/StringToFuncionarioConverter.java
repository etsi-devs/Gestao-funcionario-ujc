package mz.ac.ujc.esa.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.ac.ujc.esa.boot.domain.Funcionario;
import mz.ac.ujc.esa.boot.service.FuncionarioService;

@Component
public class StringToFuncionarioConverter implements Converter<String, Funcionario> {

    @Autowired
    private FuncionarioService service;

    @Override
    public Funcionario convert(String source) {

        if (source.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(source);
        return service.pesquisarPorId(id);
    }

}
