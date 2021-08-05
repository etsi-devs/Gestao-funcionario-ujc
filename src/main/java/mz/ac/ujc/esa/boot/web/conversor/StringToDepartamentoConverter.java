package mz.ac.ujc.esa.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.ac.ujc.esa.boot.domain.Departamento;
import mz.ac.ujc.esa.boot.service.DepartamentoService;

/**
 * Classe usada para converter textos em objectos do tipo deparatemnto
 */
@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService service;

    /**
     * Metodo para converter textos em objectos do tipo deparatemnto e apenas seram
     * convertidos textos diferentes de null atraves do teste condicional
     * implementado
     */
    @Override
    public Departamento convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(source); // conversao do conteudo da string em long para consulta pelo departamento
        return service.pesquisarPorId(id);
    }

}
