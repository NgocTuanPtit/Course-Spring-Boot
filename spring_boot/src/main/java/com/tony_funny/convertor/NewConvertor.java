package com.tony_funny.convertor;

import com.tony_funny.dto.NewDTO;
import com.tony_funny.entity.NewEntity;

public class NewConvertor {

	public static NewEntity toEntity(NewDTO newDTO) {
		NewEntity entity = new NewEntity();
		entity.setContent(newDTO.getContent());
		entity.setTitle(newDTO.getTitle());
		entity.setThumbnail(newDTO.getThumbnail());
		entity.setShortDescription(newDTO.getShortDescription());
		return entity;
	}
	
	public static NewEntity toEntity(NewDTO newDTO, NewEntity entity) {
		entity.setContent(newDTO.getContent());
		entity.setTitle(newDTO.getTitle());
		entity.setThumbnail(newDTO.getThumbnail());
		entity.setShortDescription(newDTO.getShortDescription());
		return entity;
	}
	
	public static NewDTO toDto(NewEntity entity) {
		NewDTO dto = new NewDTO();
		dto.setCategoryCode(entity.getCategory().getCode());
		dto.setContent(entity.getContent());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		dto.setTitle(entity.getTitle());
		dto.setId(entity.getId());
		return dto;
	}
}
