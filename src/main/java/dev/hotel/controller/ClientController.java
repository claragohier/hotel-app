package dev.hotel.controller;

import java.util.List;

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
	public List<Client> list() {
		return clientRepository.findAll();
	}
	
}
