package com.tony_funny.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tony_funny.convertor.NewConvertor;
import com.tony_funny.dto.NewDTO;
import com.tony_funny.entity.CategoryEntity;
import com.tony_funny.entity.NewEntity;
import com.tony_funny.repository.CategoryRepository;
import com.tony_funny.repository.NewRepository;
import com.tony_funny.service.INewService;

@Service
public class NewService implements INewService{

	 @Autowired
	 private NewRepository newRepository;

	 @Autowired
	 private CategoryRepository categoryRepository;
	 
	 //= Hàm chung cho INSERT & UPDATE dua vao (id)
	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		//= Cập nhật bài viết
		if(newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = NewConvertor.toEntity(newDTO, oldNewEntity);
		}else {
			newEntity = NewConvertor.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		return NewConvertor.toDto(newRepository.save(newEntity));
	}

	@Override
	public void delete(Long[] ids) {
		for (Long item:ids) {
			newRepository.delete(item);
		}
		
	}

	@Override
	public List<NewDTO> showNews(Pageable pageable) {
		List<NewDTO> listResult = new ArrayList<NewDTO>();
		List<NewEntity> list = newRepository.findAll(pageable).getContent();
		for (NewEntity item : list) {
			listResult.add(NewConvertor.toDto(item));
		}
		
		return listResult;
	}

	@Override
	public int getTotalNew() {
		return (int) newRepository.count();
	}

	@Override
	public List<NewDTO> showNews() {
		List<NewDTO> listResult = new ArrayList<NewDTO>();
		List<NewEntity> findAll = newRepository.findAll();
		for (NewEntity item : findAll) {
			listResult.add(NewConvertor.toDto(item));
		}
		return listResult;
	}

}
