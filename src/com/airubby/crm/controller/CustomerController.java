package com.airubby.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airubby.crm.pojo.BaseDict;
import com.airubby.crm.pojo.Customer;
import com.airubby.crm.pojo.QueryVo;
import com.airubby.crm.service.BaseDictService;
import com.airubby.crm.service.CustomerService;
import com.airubby.crm.utils.Page;

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
	@Autowired
	private CustomerService customerService;
	
	@Value("${customer_from_type}")
	private String customer_from_type;
	
	@Value("${customer_industry_type}")
	private String customer_industry_type;
	
	@Value("${customer_level_type}")
	private String customer_level_type;
	
	@RequestMapping("list")
	public String list(Model model,QueryVo vo) {
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
		
		//跟据查询条件分页查询用户列表
		Page<Customer> page = customerService.getCustomerByQueryVo(vo);
		
		//设置分页数返回
		model.addAttribute("page", page);
		
		//返回查询条件
		model.addAttribute("vo", vo);
		
		return "customer";
	}
	
	@RequestMapping("myTag")
	public String myTag() {
		return "myTag";  //跳转到myTag页面
	}
}
