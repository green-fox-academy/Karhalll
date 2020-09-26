package com.greemfoxacademy.exampleexam.service;

import com.greemfoxacademy.exampleexam.model.Alias;
import com.greemfoxacademy.exampleexam.repository.AliasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliaserServiceImpl implements AliaserService {

  private final AliasRepo aliasRepo;

  @Autowired
  public AliaserServiceImpl(AliasRepo aliasRepo) {
    this.aliasRepo = aliasRepo;
  }

  @Override
  public boolean isAlias(String alias) {
    return aliasRepo.findFirstByAlias(alias) != null;
  }

  @Override
  public Alias newAliaser(String url, String alias) {
    return aliasRepo.save(new Alias(url, alias));
  }

  @Override
  public Alias getAliasByAlias(String alias) {
    return aliasRepo.findFirstByAlias(alias);
  }
}
