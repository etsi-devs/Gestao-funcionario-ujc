package mz.ac.ujc.esa.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import mz.ac.ujc.esa.boot.domain.Tipo;
import mz.ac.ujc.esa.boot.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class StringToTipoConverter implements Converter<String, Tipo> {

    @Autowired
    private TipoService service;

    @Override
    public Tipo convert(String source) {
        if (source.isEmpty()) {

            return null;
        }
        Long id = Long.valueOf(source);
        return service.buscarPorId(id);
    }

}
