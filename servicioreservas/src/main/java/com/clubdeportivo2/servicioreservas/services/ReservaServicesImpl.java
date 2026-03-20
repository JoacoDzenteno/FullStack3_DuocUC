package com.clubdeportivo2.servicioreservas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.servicioreservas.client.CanchaClient;
import com.clubdeportivo2.servicioreservas.model.Reserva;

import com.clubdeportivo2.servicioreservas.repository.ReservaRepository;
import java.util.List;

@Service
public class ReservaServicesImpl implements ReservaServices {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private CanchaClient canchaClient;
    
    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

  
    @Override
    public Reserva crearReserva(Reserva reserva) {
        try {
            // Feign ahora recibirá el 404 o el 200
            canchaClient.buscarPorCancha(reserva.getCanchaId());
            
            // Si la línea de arriba no lanzó excepción, la cancha existe
            return reservaRepository.save(reserva);

        } catch (feign.FeignException.NotFound e) {
            // ESTO SE EJECUTARÁ AHORA (porque Canchas envía un 404)
            throw new RuntimeException("La cancha con ID " + reserva.getCanchaId() + " no existe.");
        } catch (Exception e) {
            throw new RuntimeException("Error de conexión: " + e.getMessage());
        }
    }
    // @Override
    // public Reserva crearReserva(Reserva reserva) {
    //     return reservaRepository.save(reserva);
    // }

   
    @Override
    public List<Reserva> buscarReservasPorCancha(Long canchaId) {
        return reservaRepository.findByCanchaId(canchaId);
    }

    

}
