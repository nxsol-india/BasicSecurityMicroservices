package com.nxpert.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nxpert.entity.Partner;


@FeignClient(name="partner-service")
public interface FeignPartnerServiceProxy {

	@RequestMapping(method = RequestMethod.GET, value = "/partner")
	public List<Partner> retrievePartnerList();
	
	/*@RequestMapping(method = RequestMethod.GET, value = "/partner/findById/{id}")
	public Partner retrievePartner(@PathVariable("id") Long id);*/

	@RequestMapping(method = RequestMethod.POST, value = "/partner")
	public Partner savePartner(@RequestBody Partner partner);
}