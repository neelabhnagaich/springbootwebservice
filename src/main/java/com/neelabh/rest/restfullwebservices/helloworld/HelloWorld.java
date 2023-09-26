package com.neelabh.rest.restfullwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	MessageSource messageSource;
	
	public HelloWorld(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="hello-world")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path="hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello, %S", name));
	}
	
	@RequestMapping(method=RequestMethod.GET, path="hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
	}
	
	
}
