package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Reservation;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.ReservationRepository;

@RestController
public class ReservationController {

	private ReservationRepository reservationRepository;
	private ClientRepository clientRepository;
	private ChambreRepository chambreRepository;
	
	public ReservationController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	@PostMapping("/reservations")
	Reservation addReservation(@RequestBody Reservation reservation) {
		
		List<Chambre> chambres = new ArrayList<Chambre>();
		
		reservation.setClient(clientRepository.getClient(reservation.getClient().getNumero()));
		
		reservation.getChambres().forEach(c -> chambres.add(c));
		
		reservation.setChambres(chambres);
		
		return reservationRepository.save(reservation);
	}
}
