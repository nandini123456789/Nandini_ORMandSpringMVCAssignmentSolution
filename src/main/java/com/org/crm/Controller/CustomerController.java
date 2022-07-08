package com.org.crm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.crm.Service.ICustomerService;
import com.org.crm.entity.Customer;


@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService iCustSrvice;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/add-new-customer")
	public String addNewCustomer() {
		return "AddNewCustomer";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/new-customer")
	public String addCustomer(@RequestParam("id") String custId, @RequestParam("f_Name") String f_name,@RequestParam("l_name") String l_name, 
			@RequestParam("email") String email) {
		int id=Integer.parseInt(custId);
		Customer cust=new Customer(id,f_name,l_name,email);
		iCustSrvice.insert(cust);
		return "redirect:show-customer";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/show-customer")
	public ModelAndView getAllCustomer(ModelAndView mav) {
		List<Customer> custs=iCustSrvice.getAllCustomer();
		mav.setViewName("cust-info");
		mav.addObject("custInfo",custs);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/delete-customer")
	public String DeleteCustomer(@RequestParam("id") String custId) {
		int id=Integer.parseInt(custId);
		if (iCustSrvice.delete(id)) {
			System.out.println("Student deleted.....");
		} else {
			System.out.println("Student not deleted");
		}
		return "redirect:show-customer";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/update-customer")
	public ModelAndView UpdateCustomer(@RequestParam("id") String custId, ModelAndView mav) {
		int id=Integer.parseInt(custId);
		Customer cust=iCustSrvice.getCustomer(id);
	    mav.setViewName("updateCustomer");
	    mav.addObject("custDetail",cust);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/updated-customer")
	public String ShowUpdatedCustomer(@RequestParam("id") String custId, @RequestParam("f_Name") String f_name,@RequestParam("l_name") String l_name, 
			@RequestParam("email") String email) {
		int id=Integer.parseInt(custId);
		Customer cust=new Customer(id,f_name,l_name,email);
		iCustSrvice.update(cust);
		return "redirect:show-customer";
	}
}
