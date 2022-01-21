package com.daniinyan.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.daniinyan.models.Contact;
import com.daniinyan.services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public List<Contact> findAll() {
		return contactService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> findById(@PathVariable Long id) {
		return contactService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Contact> create(@Valid @RequestBody Contact contact) {
		Contact contato = contactService.save(contact);
		
		//refatorar essa parte para melhor leitura
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(contato.getId()).toUri();
		
		return ResponseEntity.created(uri).body(contato);
	}
	
	@PutMapping("/id")
	public ResponseEntity update(@PathVariable("id") Long id,
								@RequestBody Contact contact) {
		
		return contactService.findById(id)
				.map(record -> {
					record.setName(contact.getName());
					record.setEmail(contact.getEmail());
					record.setPhone(contact.getPhone());
					Contact updated = contactService.save(record);
					return ResponseEntity.accepted().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/id"})
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return contactService.findById(id)
				.map(record -> {
					contactService.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}

}
