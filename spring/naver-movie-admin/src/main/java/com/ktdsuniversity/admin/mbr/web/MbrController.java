package com.ktdsuniversity.admin.mbr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.admin.mbr.service.MbrService;

@Controller
public class MbrController {

	@Autowired
	private MbrService mbrService;
	
	@GetMapping("/")
	public String viewAdminLoginPage() {
		return "mbr/lgn";
	}
}
