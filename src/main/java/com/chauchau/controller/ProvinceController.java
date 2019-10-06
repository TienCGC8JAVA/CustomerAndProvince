package com.chauchau.controller;

import com.chauchau.model.Customer;
import com.chauchau.model.Province;
import com.chauchau.service.customer.CustomerService;
import com.chauchau.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("provinces")
public class ProvinceController {

  @Autowired
  private ProvinceService provinceService;

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public ModelAndView listProvinces(){
    Iterable<Province> provinces = provinceService.findAll();
    ModelAndView modelAndView = new ModelAndView("/provinces/list");
    modelAndView.addObject("provinces", provinces);
    return modelAndView;
  }

  @GetMapping("/create-province")
  public ModelAndView showCreateForm(){
    ModelAndView modelAndView = new ModelAndView("/provinces/create");
    modelAndView.addObject("province", new Province());
    return modelAndView;
  }

  @PostMapping("/create-province")
  public ModelAndView saveProvince(@ModelAttribute("province") Province province){
    provinceService.save(province);

    ModelAndView modelAndView = new ModelAndView("/provinces/create");
    modelAndView.addObject("province", new Province());
    modelAndView.addObject("message", "New province created successfully");
    return modelAndView;
  }

  @GetMapping("/edit-province/{id}")
  public ModelAndView showEditForm(@PathVariable Integer id){
    Province province = provinceService.findById(id);
    if(province != null) {
      ModelAndView modelAndView = new ModelAndView("/provinces/edit");
      modelAndView.addObject("province", province);
      return modelAndView;

    }else {
      ModelAndView modelAndView = new ModelAndView("/404");
      return modelAndView;
    }
  }

  @PostMapping("/edit-province")
  public ModelAndView updateProvince(@ModelAttribute("province") Province province){
    provinceService.save(province);
    ModelAndView modelAndView = new ModelAndView("/provinces/edit");
    modelAndView.addObject("province", province);
    modelAndView.addObject("message", "Province updated successfully");
    return modelAndView;
  }

  @GetMapping("/delete-province/{id}")
  public ModelAndView showDeleteForm(@PathVariable Integer id){
    Province province = provinceService.findById(id);
    if(province != null) {
      ModelAndView modelAndView = new ModelAndView("/provinces/delete");
      modelAndView.addObject("province", province);
      return modelAndView;

    }else {
      ModelAndView modelAndView = new ModelAndView("/404");
      return modelAndView;
    }
  }

  @PostMapping("/delete-province")
  public String deleteProvince(@ModelAttribute("province") Province province){
    provinceService.remove(province.getId());
    return "redirect:/provinces";
  }

  @GetMapping("/view-province/{id}")
  public ModelAndView viewProvince(@PathVariable("id") int id){
    Province province = provinceService.findById(id);
    if(province == null){
      return new ModelAndView("/404");
    }

    Iterable<Customer> customers = customerService.findAllByProvince(province);

    ModelAndView modelAndView = new ModelAndView("/provinces/view");
    modelAndView.addObject("province", province);
    modelAndView.addObject("customers", customers);
    return modelAndView;
  }
}
