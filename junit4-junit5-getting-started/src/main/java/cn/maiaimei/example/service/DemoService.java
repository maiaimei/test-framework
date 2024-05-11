package cn.maiaimei.example.service;

import cn.maiaimei.example.repository.DemoRepository;

public class DemoService {

  private final DemoRepository demoRepository;

  public DemoService(DemoRepository demoRepository) {
    this.demoRepository = demoRepository;
  }

  public String insert() {
    return demoRepository.insert();
  }

  public String update() {
    return demoRepository.update();
  }
}
