package com.management.apollonia_dental.mapper;

import com.management.apollonia_dental.dataholders.EmpleadoDh;
import com.management.apollonia_dental.dtos.EmpleadoDto;
import com.management.apollonia_dental.entities.EmpleadoEntity;
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
    date = "2025-07-31T21:24:39-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EmpleadoMapperImpl implements EmpleadoMapper {

    private final DatatypeFactory datatypeFactory;

    public EmpleadoMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public EmpleadoDto asDto(EmpleadoEntity empleadoEntity) {
        if ( empleadoEntity == null ) {
            return null;
        }

        Long idEmpleado = null;
        String nombre = null;
        String apellido = null;
        String fechaIngreso = null;
        String correo = null;
        String telefono = null;
        LocalDateTime fechaCreacion = null;
        Long idCreate = null;
        LocalDateTime fechaModificacion = null;
        Long idUpdate = null;
        Boolean estado = null;

        idEmpleado = empleadoEntity.getIdEmpleado();
        nombre = empleadoEntity.getNombre();
        apellido = empleadoEntity.getApellido();
        fechaIngreso = empleadoEntity.getFechaIngreso();
        correo = empleadoEntity.getCorreo();
        telefono = empleadoEntity.getTelefono();
        fechaCreacion = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( empleadoEntity.getFechaCreacion() ) );
        idCreate = empleadoEntity.getIdCreate();
        fechaModificacion = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( empleadoEntity.getFechaModificacion() ) );
        idUpdate = empleadoEntity.getIdUpdate();
        estado = empleadoEntity.getEstado();

        EmpleadoDto empleadoDto = new EmpleadoDto( idEmpleado, nombre, apellido, fechaIngreso, correo, telefono, fechaCreacion, idCreate, fechaModificacion, idUpdate, estado );

        return empleadoDto;
    }

    @Override
    public EmpleadoEntity asEntity(EmpleadoDh empleadoDh) {
        if ( empleadoDh == null ) {
            return null;
        }

        EmpleadoEntity empleadoEntity = new EmpleadoEntity();

        empleadoEntity.setNombre( empleadoDh.nombre() );
        empleadoEntity.setApellido( empleadoDh.apellido() );
        empleadoEntity.setFechaIngreso( empleadoDh.fechaIngreso() );
        empleadoEntity.setCorreo( empleadoDh.correo() );
        empleadoEntity.setTelefono( empleadoDh.telefono() );

        return empleadoEntity;
    }

    @Override
    public List<EmpleadoEntity> asEntityList(List<EmpleadoDh> empleadosDhs) {
        if ( empleadosDhs == null ) {
            return null;
        }

        List<EmpleadoEntity> list = new ArrayList<EmpleadoEntity>( empleadosDhs.size() );
        for ( EmpleadoDh empleadoDh : empleadosDhs ) {
            list.add( asEntity( empleadoDh ) );
        }

        return list;
    }

    @Override
    public List<EmpleadoDto> asDtoList(List<EmpleadoEntity> empleadosEntities) {
        if ( empleadosEntities == null ) {
            return null;
        }

        List<EmpleadoDto> list = new ArrayList<EmpleadoDto>( empleadosEntities.size() );
        for ( EmpleadoEntity empleadoEntity : empleadosEntities ) {
            list.add( asDto( empleadoEntity ) );
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
