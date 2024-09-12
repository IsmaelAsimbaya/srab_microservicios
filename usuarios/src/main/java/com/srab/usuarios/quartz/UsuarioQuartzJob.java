package com.srab.usuarios.quartz;

import com.srab.usuarios.clients.HorarioRestClient;
import com.srab.usuarios.clients.MarcacionRestClient;
import com.srab.usuarios.db.Usuario;
import com.srab.usuarios.dtos.DiaHorarioDto;
import com.srab.usuarios.dtos.HorarioDto;
import com.srab.usuarios.dtos.MarcacionDto;
import com.srab.usuarios.repo.UsuarioRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioQuartzJob implements Job {

    @Inject
    UsuarioRepository rep;

    @Inject
    @RestClient
    HorarioRestClient horarioClient;

    @Inject
    @RestClient
    MarcacionRestClient marcacionClient;

    private static final Map<String, String> DIA_SEMANA_TRADUCCION = new HashMap<>();

    static {
        DIA_SEMANA_TRADUCCION.put("MONDAY", "Lunes");
        DIA_SEMANA_TRADUCCION.put("TUESDAY", "Martes");
        DIA_SEMANA_TRADUCCION.put("WEDNESDAY", "Miercoles");
        DIA_SEMANA_TRADUCCION.put("THURSDAY", "Jueves");
        DIA_SEMANA_TRADUCCION.put("FRIDAY", "Viernes");
        DIA_SEMANA_TRADUCCION.put("SATURDAY", "Sabado");
        DIA_SEMANA_TRADUCCION.put("SUNDAY", "Domingo");
    }

    @Override
    @Transactional
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LocalDate fecha = LocalDate.now();
        String diaSemana = fecha.getDayOfWeek().name();
        String diaSemanaEsp = DIA_SEMANA_TRADUCCION.getOrDefault(diaSemana, diaSemana);
        List<Usuario> usuarios = rep.findAll().list();
        for (Usuario usuario : usuarios) {
            System.out.println("Ejecutando UsuarioQuartzJob para usuario:" + usuario.getId_usuario());
            HorarioDto horarioDto = horarioClient.getById(usuario.getId_horario());
            DiaHorarioDto diaHorario = horarioDto.getDiasHorario().stream()
                    .filter(d -> d.getDiaSemana().equalsIgnoreCase(diaSemanaEsp))
                    .findFirst()
                    .orElse(null);
            if (diaHorario != null) {
                crearMarcacion(usuario, fecha, diaHorario.getHoraEntrada(), "Entrada", "Falta");
                // crearMarcacion(usuario, fecha, diaHorario.getHoraSalida(), "Salida", "Falta");
            }
        }
    }

    private void crearMarcacion(Usuario usuario, LocalDate fecha, LocalTime hora, String tipo, String estado) {
        MarcacionDto marcacion = new MarcacionDto();
        marcacion.setId_usuario(usuario.getId_usuario());
        marcacion.setFecha(fecha);
        marcacion.setHora(hora);
        marcacion.setTipo(tipo);
        marcacion.setEstado(estado);
        marcacion.setUbicacion("Ubicacion no especificada");
        marcacion.setImage_source(null);
        marcacion.setObservaciones("Sin observaciones");
        marcacion.setPred_distance("N/A");
        marcacionClient.create(marcacion);
    }
}
