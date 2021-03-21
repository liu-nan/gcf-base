package com.gcf.provider.code.service.impl;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcf.common.bean.Page;
import com.gcf.provider.code.controller.dto.ContentTypeDto;
import com.gcf.provider.code.exception.GcfCodeException;
import com.gcf.provider.code.service.ContentTypeService;

@Service
public class ContentTypeServiceImpl implements ContentTypeService {

	@Override
	public ContentTypeDto create(ContentTypeDto dto) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentTypeDto modify(ContentTypeDto dto) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) throws GcfCodeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByCode(String code) throws GcfCodeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContentTypeDto findById(String id) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentTypeDto findByCode(String code) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContentTypeDto> findForPage(ContentTypeDto dto) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

}
