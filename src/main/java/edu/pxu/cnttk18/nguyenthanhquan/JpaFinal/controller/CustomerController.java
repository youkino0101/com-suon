package edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.Customer;
import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.entity.CustomerType;
import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service.CustomerService;
import edu.pxu.cnttk18.nguyenthanhquan.JpaFinal.service.TypeService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TypeService typeService;

	@ModelAttribute("customerType")
	public List<CustomerType> customerType() {
		return typeService.getAll();
	}

	@GetMapping(value = { "/", "/home" })
	public String listcustomer(Model theModel, @RequestParam("s") Optional<String> s,
			@RequestParam("p") Optional<Integer> p, @RequestParam("search") Optional<String> search, Pageable page) {
		Sort sort;
		Page<Customer> aCustomers;
		Pageable pageable;
		if (search.isPresent()) {
			aCustomers = customerService.findAllByFullNameContaining(search.get(), page);
			theModel.addAttribute("a", aCustomers);
		}

		else if (s.isPresent()) {
			sort = Sort.by(Direction.ASC, s.orElse("fullName"), s.orElse("id"));
			pageable = PageRequest.of(p.orElse(0), 3, sort);
			aCustomers = customerService.findAll(pageable);
			theModel.addAttribute("a", aCustomers);
		} else {
			pageable = PageRequest.of(p.orElse(0), 3);
			aCustomers = customerService.findAll(pageable);
			theModel.addAttribute("a", aCustomers);
		}
		return "list";
	}

	@GetMapping("/showform")
	public String showFormNew(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer); 

		return "create";
	}

	@PostMapping("/saveCustomer")
	public String newCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "create";
		} else {
			
			customerService.save(customer);
			return "redirect:/";
		}
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") Long theId, Model theModel) {
		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("customer", theCustomer);
		return "update";
	}

	@PostMapping("/updateCustomer")
	public String UpdateSave(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "update";
		} else {
			customerService.save(customer);
			return "redirect:/";
		}
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") Long theId) {
		customerService.remove(theId);
		return "redirect:/home";
	}
}
