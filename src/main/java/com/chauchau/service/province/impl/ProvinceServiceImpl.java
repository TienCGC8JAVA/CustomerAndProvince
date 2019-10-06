package com.chauchau.service.province.impl;

import com.chauchau.model.Province;
import com.chauchau.repository.ProvinceRepository;
import com.chauchau.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceServiceImpl implements ProvinceService {

  @Autowired
  private ProvinceRepository provinceRepository;

  @Override
  public Iterable<Province> findAll() {
    return provinceRepository.findAll();
  }

  @Override
  public Province findById(int id) {
    return provinceRepository.findOne(id);
  }

  @Override
  public void save(Province province) {
    provinceRepository.save(province);
  }

  @Override
  public void remove(int id) {
    provinceRepository.delete(id);
  }
}
