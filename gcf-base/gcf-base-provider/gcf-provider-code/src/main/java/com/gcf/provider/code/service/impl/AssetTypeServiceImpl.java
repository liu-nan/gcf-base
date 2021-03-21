package com.gcf.provider.code.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.common.bean.Page;
import com.gcf.provider.code.controller.dto.AssetTypeDto;
import com.gcf.provider.code.exception.GcfCodeException;
import com.gcf.provider.code.repository.entity.AssetTypeEntity;
import com.gcf.provider.code.repository.jpa.AssetTypeRepository;
import com.gcf.provider.code.service.AssetTypeService;

@Service
public class AssetTypeServiceImpl implements AssetTypeService {
	
	@Autowired
	private AssetTypeRepository assetTypeRepository;

	@Override
	public AssetTypeDto create(AssetTypeDto dto) throws GcfCodeException {
		AssetTypeEntity entity = new AssetTypeEntity();
		assetTypeRepository.save(entity);
		return null;
	}

	@Override
	public AssetTypeDto modify(AssetTypeDto dto) throws GcfCodeException {
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
	public AssetTypeDto findById(String id) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetTypeDto findByCode(String code) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AssetTypeDto> findForPage(AssetTypeDto dto) throws GcfCodeException {
		// TODO Auto-generated method stub
		return null;
	}

}
