package com.airubby.crm.mapper;

import java.util.List;

import com.airubby.crm.pojo.BaseDict;

/**
 * 数据字典持久化接口
 * @author Administrator
 *
 */
public interface BaseDictMapper {
	/**
	 * 根据字典编码查询字典列表
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
