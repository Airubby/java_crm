package com.airubby.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airubby.crm.pojo.BaseDict;
import com.airubby.crm.service.BaseDictService;

/**
 * 客户信息处理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private BaseDictService dictService;
	
	@Value("${customer_from_type}")
	private String customer_from_type;
	
	@Value("${customer_industry_type}")
	private String customer_industry_type;
	
	@Value("${customer_level_type}")
	private String customer_level_type;
	
	@RequestMapping("list")
	public String list(Model model) {
		// 查询来源
		List<BaseDict> fromType = dictService.getBaseDictByCode(customer_from_type);
		// 查询行业
		List<BaseDict> industryType = dictService.getBaseDictByCode(customer_industry_type);
		// 查询级别
		List<BaseDict> levelType = dictService.getBaseDictByCode(customer_level_type);

		// 设置数据模型返回
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		return "customer";
	}
	
	@RequestMapping("myTag")
	public String myTag() {
		return "myTag";  //跳转到myTag页面
	}
}
