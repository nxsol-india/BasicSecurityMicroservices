/**
 * 
 */
package com.nxpert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nxpert.entity.Partner;
import com.nxpert.repository.PartnerRepository;

@RestController
public class PartnerController {
	
	@Autowired
	PartnerRepository partnerRepository;
	
	@GetMapping("/partner")
	public List<Partner> all() {
		List<Partner> partnerList = partnerRepository.findAll();
		return partnerList;
	}
	
	/*@RequestMapping("/partner/findById/{id}")
	public Partner byId(@PathVariable("id") Long id) {
		Optional<Partner>  user = partnerRepository.findById(id);
		return user.get();
	}*/
	
	@PostMapping("/partner")
	public Partner save(@RequestBody Partner partner) {
		return partnerRepository.save(partner);
	}
}
