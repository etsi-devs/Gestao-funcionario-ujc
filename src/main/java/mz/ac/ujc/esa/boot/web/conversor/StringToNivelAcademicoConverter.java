package mz.ac.ujc.esa.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import mz.ac.ujc.esa.boot.domain.NivelAcademico;
import mz.ac.ujc.esa.boot.service.NivelAcademicoService;
import org.springframework.stereotype.Component;

@Component
public class StringToNivelAcademicoConverter implements Converter<String, NivelAcademico> {

    @Autowired
    private NivelAcademicoService service;

    @Override
    public NivelAcademico convert(String source) {

        if (source.isEmpty()) {

            return null;
        }
        Long id = Long.valueOf(source);
        return service.buscarPorId(id);

    }

}
