package com.wo.edu.web.util;/*
package com.wo.education.web.util;

import com.wo.bibapi.persistence.entity.Estudiante;
import com.wo.bibapi.persistence.entity.Prestamo;
import com.wo.bibapi.persistence.entity.Docente;
import com.wo.bibapi.persistence.entity.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

*/
/**
 * Reglas de Negocio de la Biblioteca BR = Business Rules
 * Lo implementamos como un singleton por si algún día queremos leer las
 * constantes desde un fichero de configuración, lo podemos hacer desde el
 * constructor del singleton
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 *
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 * <p>
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 * <p>
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 * <p>
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 * <p>
 * Devuelve los días de penalización de un préstamo retrasado
 * <p>
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 *//*

public class BibliotecaBR {
    private int numDiasPrestamoEstudiante = 7;
    private int numDiasPrestamoDocente = 30;
    private int cupoOperacionesEstudiante = 5;
    private int cupoOperacionesDocente = 8;

    private static Log log = LogFactory.getLog(BibliotecaBR.class);
    private static BibliotecaBR me = new BibliotecaBR();

    private BibliotecaBR() {
        log.debug("Creada instancia de " + this.getClass().getSimpleName());
    }

    public static BibliotecaBR getInstance() {
        return me;
    }

    */
/**
 * Devuelve el número de días de plazo que tienen un usuario para
 * devolver un préstamo (Estudiante = 7, Docente = 30)
 *
 * @param usuario objeto Usuario
 * @return número de días del préstamo en función de la clase de
 * Usuario, Estudiante o Docente
 * @throws BibliotecaException el usuario no es de la clase Estudiante ni Docente
 *//*

    public int calculaNumDiasPrestamo(Usuario usuario) throws BibliotecaException {
        if (usuario instanceof Estudiante) {
            return numDiasPrestamoEstudiante;
        } else if (usuario instanceof Docente) {
            return numDiasPrestamoDocente;
        } else {
            String msg = "Solo los estudiantes y docentes pueden tener libros prestados";
            log.error(msg);
            throw new BibliotecaException(msg);
        }
    }

    */
/**
 * Valida que el número de días que se ha tardado en devolver
 * un libro es inferior o igual que el plazo máximo
 *
 * @param usuario objeto Usuario
 * @param numDias número de días sin devolver
 * @throws BibliotecaException fuera de plazo
 * @throws BibliotecaException el tipo del usuario no es el esperado
 *//*


    public void compruebaNumDiasPrestamo(Usuario usuario, int numDias) throws BibliotecaException {
        String msg;
        if (!(usuario instanceof Estudiante) && !(usuario instanceof Docente)) {
            msg = "Solo los estudiantes y docentes pueden tener libros prestados";
            log.error(msg);
            throw new BibliotecaException(msg);
        }
        if ((usuario instanceof Estudiante && numDias > numDiasPrestamoEstudiante) || (usuario instanceof Docente && numDias > numDiasPrestamoDocente)) {
            msg = "Devolución fuera de plazo";
            log.error(msg);
            throw new BibliotecaException(msg);
        }
    }

    */
/**
 * Devuelve el número máximo de préstamos que
 * puede realizar un determinado tipo de usuario
 *
 * @param usuario objeto UsuarioDomain
 * @return número máximo de operaciones del tipo de usuario
 * @throws BibliotecaException el tipo del usuario no es el esperado
 *//*

    public int cupoOperaciones(Usuario usuario) throws BibliotecaException {
        if (usuario instanceof Estudiante)
            return cupoOperacionesEstudiante;
        else if (usuario instanceof Docente)
            return cupoOperacionesDocente;
        else {
            String msg = "Solo los estudiantes y docentes pueden tener libros prestados";
            log.error(msg);
            throw new BibliotecaException(msg);
        }
    }

    */
/**
 * Valida que el número de préstamos realizadas por un determinado
 * tipo de usuario se inferior o igual al cupo definido
 *
 * @param usuario objeto Usuario
 * @param numOp   número de operación que ya tiene realizadas
 * @throws BibliotecaException el cupo de operación está lleno
 * @throws BibliotecaException el tipo del usuario no es el esperado
 *//*

    public void compruebaCupoOperaciones(Usuario usuario, int numOp) throws BibliotecaException {
        String msg;
        if (!(usuario instanceof Estudiante) && !(usuario instanceof Docente)) {
            msg = "Solo los estudiantes y docentes pueden tener libros prestados";
            log.error(msg);
            throw new BibliotecaException(msg);
        }
        if ((usuario instanceof Estudiante && numOp > cupoOperacionesEstudiante) || (usuario instanceof Docente && numOp > cupoOperacionesDocente)) {
            msg = "El cupo de operaciones posibles esta lleno";
            log.error(msg);
            throw new BibliotecaException(msg);
        } else {
            msg = "Operación exitosa";
            log.error(msg);
        }
    }

    */
/**
 * Devuelve una fecInicio de devolución de un préstamo,
 * sumando a la fecInicio del parámetro el número de días de préstamo
 * del tipo de usuario
 *//*

    public Date fechaDevolucionPrestamo(Usuario usuario, Date fechaActual) {
        return Util.sumaDias(fechaActual, this.calculaNumDiasPrestamo(usuario));
    }

    */
/**
 * Devuelve los días de penalización de un préstamo retrasado
 *//*

    public long diasPenalizacion(Prestamo prestamo) {
        return Util.diferenciaDias(prestamo.getFechaDevolucion(), prestamo.getFechaDevuelta());
    }

    */
/**
 * Comprobación de si un préstamo es moroso (está pendiente de devolver y ya ha
 * pasado la fecInicio de devolución)
 *//*

    public boolean esPrestamoActivo(Prestamo prestamo) {
        return prestamo.getFechaDevuelta() == null;
    }

    public boolean esPrestamoRetrasado(Prestamo prestamo, Date fechaActual) {
        return prestamo.getFechaDevolucion().before(fechaActual);
    }

    public boolean esPrestamoMoroso(Prestamo prestamo, Date fechaActual) {
        return this.esPrestamoActivo(prestamo) && this.esPrestamoRetrasado(prestamo, fechaActual);
    }

    // Generador de fecha actual

    @Getter
    @Setter
    CurrentDateGenerator currentDateGenerator = new ActualCurrentDateGenerator();

}
*/
