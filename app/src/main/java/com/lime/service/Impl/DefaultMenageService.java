package com.lime.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lime.dao.ManageDao;
import com.lime.domain.Field;
import com.lime.domain.User;
import com.lime.service.ManageService;

@Service
public class DefaultMenageService implements ManageService {

  @Autowired
  ManageDao manageDao;

  @Transactional
  public List<User> userList() {
    return manageDao.findAll();
  }
  @Transactional
  public User userGet(int no) {
    User manage = manageDao.findByNo(no);
    return manage;
  }

  @Transactional
  public int update(User manage) {
    return manageDao.update(manage);
  }

  @Transactional
  public int delete(int no) {
    return manageDao.delete(no);
  }

  @Transactional
  public List<Field> fieldList() {
    return manageDao.findFieldAll();
  }

  @Transactional
  public Field fieldGet(int no) {
    return manageDao.findFieldByNo(no);
  }
}






