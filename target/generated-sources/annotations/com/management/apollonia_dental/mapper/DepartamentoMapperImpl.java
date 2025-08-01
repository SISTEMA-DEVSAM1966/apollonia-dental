package com.management.apollonia_dental.mapper;

import com.management.apollonia_dental.dataholders.DepartamentoDh;
import com.management.apollonia_dental.dtos.DepartamentoDto;
import com.management.apollonia_dental.entities.DepartamentoEntity;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-31T21:24:38-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DepartamentoMapperImpl implements DepartamentoMapper {

    private final DatatypeFactory datatypeFactory;

    public DepartamentoMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public DepartamentoDto asDto(DepartamentoEntity departamento) {
        if ( departamento == null ) {
            return null;
        }

        DepartamentoDto departamentoDto = new DepartamentoDto();

        departamentoDto.setIdDepartamento( departamento.getIdDepartamento() );
        departamentoDto.setNombre( departamento.getNombre() );
        departamentoDto.setDescripcion( departamento.getDescripcion() );
        departamentoDto.setIdCreate( departamento.getIdCreate() );
        departamentoDto.setIdUpdate( departamento.getIdUpdate() );
        departamentoDto.setEstado( departamento.getEstado() );
        departamentoDto.setFechaCreacion( xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( departamento.getFechaCreacion() ) ) );
        departamentoDto.setFechaModificacion( xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( departamento.getFechaModificacion() ) ) );

        return departamentoDto;
    }

    @Override
    public DepartamentoEntity asEntity(DepartamentoDh departamentoDh) {
        if ( departamentoDh == null ) {
            return null;
        }

        DepartamentoEntity departamentoEntity = new DepartamentoEntity();

        departamentoEntity.setIdDepartamento( departamentoDh.getIdDepartamento() );
        departamentoEntity.setNombre( departamentoDh.getNombre() );
        departamentoEntity.setDescripcion( departamentoDh.getDescripcion() );
        departamentoEntity.setIdCreate( departamentoDh.getIdCreate() );
        departamentoEntity.setIdUpdate( departamentoDh.getIdUpdate() );
        departamentoEntity.setEstado( departamentoDh.getEstado() );

        return departamentoEntity;
    }

    @Override
    public List<DepartamentoEntity> asEntityList(List<DepartamentoDh> departamentoDhList) {
        if ( departamentoDhList == null ) {
            return null;
        }

        List<DepartamentoEntity> list = new ArrayList<DepartamentoEntity>( departamentoDhList.size() );
        for ( DepartamentoDh departamentoDh : departamentoDhList ) {
            list.add( asEntity( departamentoDh ) );
        }

        return list;
    }

    @Override
    public List<DepartamentoDto> asDtoList(List<DepartamentoEntity> departamento) {
        if ( departamento == null ) {
            return null;
        }

        List<DepartamentoDto> list = new ArrayList<DepartamentoDto>( departamento.size() );
        for ( DepartamentoEntity departamentoEntity : departamento ) {
            list.add( asDto( departamentoEntity ) );
        }

        return list;
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }
}
