package com.tony_funny.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony_funny.api.output.NewOutput;
import com.tony_funny.dto.NewDTO;
import com.tony_funny.service.INewService;

@RestController
public class NewAPI {
	
	@Autowired
	private INewService newService;
	
	@PostMapping(value = "/new")
	public NewDTO insertNew(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);
	}
	
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO newDTO, @PathVariable("id") long id) {
		newDTO.setId(id);
		return newService.save(newDTO);
	}
	
	@DeleteMapping("/new")
	public void deleteNew(@RequestBody Long[] ids) {
		newService.delete(ids);
	}
	
	@GetMapping(path = "/new")
	public NewOutput showNews(@RequestParam(value = "page", required = false) Integer page, 
											@RequestParam(value = "limit", required = false) Integer limit) {
		NewOutput newOutput = new NewOutput();
		if(page != null && limit != null) {//= Phan trang
			newOutput.setPage(page);
			newOutput.setTotalPage((int) Math.ceil((double)newService.getTotalNew() / limit));
			Pageable pageable = new PageRequest(page-1, limit);
			newOutput.setListTotal(newService.showNews(pageable));
		}else {
			newOutput.setListTotal(newService.showNews());
		}
		return newOutput;
	}
	
}
