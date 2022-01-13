package dev.hotel.controller;

import java.util.List;
import java.util.Optional;

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
	List<Client> list() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/clients/{id}")
	Client one(@PathVariable Integer id) {
		Optional<Client> optionalEntity =  clientRepository.findById(id);
		Client client = optionalEntity.get();
		return client;
	}
	
	@PostMapping("/clients")
	Client addClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
}
