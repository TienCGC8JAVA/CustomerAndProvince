package com.chauchau.service.customer;

import com.chauchau.model.Customer;
import com.chauchau.model.Province;
import com.chauchau.service.GeneralService;


public interface CustomerService extends GeneralService<Customer> {

  Iterable<Customer> findAllByProvince(Province province);

}
