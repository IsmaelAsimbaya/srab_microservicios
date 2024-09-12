package com.srab.usuarios.quartz;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.quartz.*;

@ApplicationScoped
public class UsuarioJobScheduler {

    @Inject
    Scheduler quartzScheduler;

    public void onStart(@Observes StartupEvent ev) throws SchedulerException {
        try {
            if (quartzScheduler == null) {
                System.out.println("Scheduler no está inyectado correctamente");
                System.out.println("Iniciando Quartz Scheduler...");
                quartzScheduler.start();  // Forzar la inicialización
            }
            System.out.println("Scheduler inyectado correctamente, iniciando...");

            var jobKey = new JobKey("usuarioJob");
            var jobDetail = quartzScheduler.getJobDetail(jobKey);

            if (jobDetail == null) {
                System.out.println("Programando y ejecutando job en Quartz...");
                jobDetail = JobBuilder.newJob(UsuarioQuartzJob.class)
                        .withIdentity("usuarioJob")
                        .build();

                var trigger = TriggerBuilder.newTrigger()
                        .withIdentity("usuarioTrigger")
                        .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
                        .build();

                quartzScheduler.scheduleJob(jobDetail, trigger);
            } else {
                System.out.println("El trabajo ya está programado.");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
