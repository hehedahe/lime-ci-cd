package com.lime.service;

import com.lime.domain.Member;

public interface MemberService {

  int add(Member member);

  Member getLoginUser(String email, String password);

  Member getUser(String email);

}






