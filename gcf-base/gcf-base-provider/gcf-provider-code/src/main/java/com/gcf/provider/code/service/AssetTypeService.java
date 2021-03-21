package com.gcf.provider.code.service;


import com.gcf.common.bean.Page;
import com.gcf.provider.code.controller.dto.AssetTypeDto;
import com.gcf.provider.code.exception.GcfCodeException;

/**
 * 素材类型Service
 * @author Romi.Liu
 *
 */
public interface AssetTypeService {
	
	/**
	 * 创建素材类型
	 * @return
	 * @throws GcfCodeException
	 */
	public AssetTypeDto create(AssetTypeDto dto) throws GcfCodeException;
	
	/**
	 * 修改素材类型
	 * @return
	 * @throws GcfCodeException
	 */
	public AssetTypeDto modify(AssetTypeDto dto) throws GcfCodeException;
	
	/**
	 * 根据主键删除素材类型
	 * @param id
	 * @return
	 * @throws GcfCodeException
	 */
	public boolean deleteById(int id) throws GcfCodeException;
	
	/**
	 * 根据代码删除
	 * @param code
	 * @return
	 * @throws GcfCodeException
	 */
	public boolean deleteByCode(String code) throws GcfCodeException;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 * @throws GcfCodeException
	 */
	public AssetTypeDto findById(String id) throws GcfCodeException;
	
	/**
	 * 根据代码查询
	 * @param code
	 * @return
	 * @throws GcfCodeException
	 */
	public AssetTypeDto findByCode(String code) throws GcfCodeException;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws GcfCodeException
	 */
	public Page<AssetTypeDto> findForPage(AssetTypeDto dto) throws GcfCodeException;
}
