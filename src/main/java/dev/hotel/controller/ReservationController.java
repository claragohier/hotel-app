package dev.hotel.controller;

import org.springframework.web.bind.annotation.*;

import dev.hotel.entite.Reservation;
import dev.hotel.repository.ReservationRepository;

@RestController
public class ReservationController {

	private ReservationRepository reservationRepository;
	
	public ReservationController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	@PostMapping("/reservations")
	Reservation addReservation(@RequestBody Reservation reservation) {
		
		return reservationRepository.save(reservation);
	}
}
