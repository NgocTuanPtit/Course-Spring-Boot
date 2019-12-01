package com.tony_funny.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tony_funny.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
	void delete(Long[] ids);
	List<NewDTO> showNews(Pageable pageable);
	List<NewDTO> showNews();
	int getTotalNew();
}
