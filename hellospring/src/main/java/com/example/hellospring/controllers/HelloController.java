package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	//	요청을 받아야 한다
	//	url 패턴 /hello 에 반응하고
	//	파라미터로 name 을 받는다
	//	ex : /hello?name=홍길동
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam String name) {
		//	Spring 의 기본 응답 객체는 ModelAndView
		//	데이터(Model)와 뷰 객체의 정보를 함께 가지고 있다
		ModelAndView mav = new ModelAndView();
		
		//	데이터 설정
		mav.addObject("message", "Hello, " + name);		//	Servlet 에서 attribute 추가와 비슷함
		mav.setViewName("/WEB-INF/views/hello.jsp");	
		
		return mav;
	}
	
	//	String 을 반환하면 기본적으로 뷰 이름을 의미
	@RequestMapping("/hello2")
	public String hello2() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello3")
	public String hello3() {
		return "<h3>Direct Response</h3>";
	}
	
}
