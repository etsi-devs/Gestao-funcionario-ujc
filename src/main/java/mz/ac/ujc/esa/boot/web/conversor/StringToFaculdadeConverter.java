package mz.ac.ujc.esa.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.ac.ujc.esa.boot.domain.Faculdade;
import mz.ac.ujc.esa.boot.service.FaculdadeService;

/**
 * Classe usada para converter textos em objectos do tipo Faculdade
 */
@Component
public class StringToFaculdadeConverter implements Converter<String, Faculdade> {

    @Autowired
    private FaculdadeService service;

    /**
     * Metodo para converter textos em objectos do tipo Faculdade e apenas seram
     * convertidos textos diferentes de null atraves do teste condicional
     * implementado
     */
    @Override
    public Faculdade convert(String source) {

        if (source.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(source);
        return service.buscarPorId(id);
    }

}
