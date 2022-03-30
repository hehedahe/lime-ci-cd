package com.lime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lime.service.MarketService;

@RestController 
public class MarketController {

  @Autowired
  MarketService marketService; // 클래스 대신 인터페이스를 지정한다.

  //  @RequestMapping("/market/list")
  //  public Object list() {
  //    return marketService.list();
  //  }

  //  @RequestMapping("/market/list/region")
  //  public Object listRegion(String regionName) {
  //    System.out.println(regionName);
  //    return marketService.listRegion(regionName);
  //  }
  //
  //  @RequestMapping("/market/list/city")
  //  public Object listCity(String regionName, String cityName) {
  //    System.out.println(regionName);
  //    System.out.println(cityName);
  //    return marketService.listCity(regionName, cityName);
  //  }

  @RequestMapping("/market/list")
  public Object list(String regionName, String cityName, boolean checked) {
    if (checked == false) {
      System.out.println(regionName);
      System.out.println(cityName);
      System.out.println(checked);
      if (regionName.equals("지역") || regionName.equals("전체")) {
        System.out.println(regionName);
        return marketService.list();
      }

      if (cityName.equals("도시")) {
        System.out.println(regionName);
        return marketService.listRegion(regionName);
      }

      return marketService.listCity(regionName, cityName);

    } else {
      if (regionName.equals("지역") || regionName.equals("전체")) {
        System.out.println(regionName);
        return marketService.listChecked();
      }

      if (cityName.equals("도시")) {
        System.out.println(regionName);
        return marketService.listRegionChecked(regionName);
      }

      return marketService.listCityChecked(regionName, cityName);
    }
  }

  //  @RequestMapping("/contact/add")
  //  public Object add(Market contact, String[] tel) throws Exception {
  //
  //    // 요청 파라미터 분석 및 가공
  //    ArrayList<ContactTel> telList = new ArrayList<>();
  //    for (int i = 0; i < tel.length; i++) {
  //      String[] value = tel[i].split("_");
  //      if (value[1].length() == 0) {
  //        continue;
  //      }
  //      // 연락처 변경의 경우 이미 연락처 번호를 알기 때문에
  //      // 전화번호를 객체에 담을 때 연락처 번호도 함께 저장한다.
  //      ContactTel contactTel = new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]);
  //      telList.add(contactTel);
  //    }
  //    contact.setTels(telList);
  //
  //    // 서비스 객체 실행
  //    return contactService.add(contact);
  //  }
  //  /*
  //    // 1) 트랜잭션으로 묶어서 실행할 작업을 정의
  //    // => 스프링 프레임워크에서 정한 규칙에 따라 정의해야 한다.
  //    class ContactAddTransaction implements TransactionCallback {
  //      @Override
  //      public Object doInTransaction(TransactionStatus status) {
  //        // 트랜잭션으로 묶어서 할 작업을 기술한다.
  //        contactDao.insert(contact);
  //        for (int i = 0; i < tel.length; i++) {
  //          String[] value = tel[i].split("_");
  //          if (value[1].length() == 0) {
  //            continue;
  //          }
  //          contactDao.insertTel(new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]));
  //        }
  //        return 1;
  //      }
  //    }
  //
  //    // 2) 트랜잭션 작업을 수행한다.
  //    return transactionTemplate.execute(new ContactAddTransaction());
  //  }
  //   */
  //  @RequestMapping("/contact/get")
  //  public Object get(int no) {
  //    Market contact = contactService.get(no);
  //    if (contact == null) {
  //      return ""; // 컨트롤러는 서비스 객체의 리턴 값에 따라 응답 데이터를 적절히 가공하여 리턴한다.
  //    }
  //    return contact;
  //  }
  //
  //  @RequestMapping("/contact/update")
  //  public Object update(Market contact, String[] tel) throws Exception {
  //    // 요청 파라미터 분석 및 가공
  //    ArrayList<ContactTel> telList = new ArrayList<>();
  //    for (int i = 0; i < tel.length; i++) {
  //      String[] value = tel[i].split("_");
  //      if (value[1].length() == 0) {
  //        continue;
  //      }
  //      // 연락처 변경의 경우 이미 연락처 번호를 알기 때문에 
  //      // 전화번호를 객체에 담을 때 연락처 번호도 함께 저장한다. 
  //      ContactTel contactTel = new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]);
  //      telList.add(contactTel);
  //    }
  //    contact.setTels(telList);
  //
  //    // 서비스 객체 실행
  //    return contactService.update(contact);
  //  }
  //
  //  @RequestMapping("/contact/delete")
  //  public Object delete(int no) throws Exception {
  //    return contactService.delete(no);
  //  }




}




