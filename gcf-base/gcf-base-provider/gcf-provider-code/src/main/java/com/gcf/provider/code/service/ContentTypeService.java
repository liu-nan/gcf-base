package com.gcf.provider.code.service;

import com.gcf.common.bean.Page;
import com.gcf.provider.code.controller.dto.ContentTypeDto;
import com.gcf.provider.code.exception.GcfCodeException;

public interface ContentTypeService {

	/**
	 * 创建内容类型
	 * @return
	 * @throws GcfCodeException
	 */
	public ContentTypeDto create(ContentTypeDto dto) throws GcfCodeException;
	
	/**
	 * 修改内容类型
	 * @return
	 * @throws GcfCodeException
	 */
	public ContentTypeDto modify(ContentTypeDto dto) throws GcfCodeException;
	
	/**
	 * 根据主键删除内容类型
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
	public ContentTypeDto findById(String id) throws GcfCodeException;
	
	/**
	 * 根据代码查询
	 * @param code
	 * @return
	 * @throws GcfCodeException
	 */
	public ContentTypeDto findByCode(String code) throws GcfCodeException;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws GcfCodeException
	 */
	public Page<ContentTypeDto> findForPage(ContentTypeDto dto) throws GcfCodeException;
}
