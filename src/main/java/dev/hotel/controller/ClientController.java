package dev.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@RestController
public class ClientController {

	private ClientRepository clientRepository;
	
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@GetMapping("/clients")
	List<Client> list(@RequestParam Integer start,
						@RequestParam Integer size) {
		return clientRepository.findAll();
	}
	
	@GetMapping("/clients/{numero}")
	public ResponseEntity<?> one(@PathVariable String numero) {
		if(clientRepository.getClient(numero) != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(clientRepository.getClient(numero));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/clients")
	public ResponseEntity<?> addClient(@RequestBody Client client) {
		if(client.getNom().length() < 2 || client.getPrenoms().length() < 2) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Veuillez entrer un nom et prénom avec au minimum 2 caractères"); 
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(this.clientRepository.save(client));
		}
	}
	
}
