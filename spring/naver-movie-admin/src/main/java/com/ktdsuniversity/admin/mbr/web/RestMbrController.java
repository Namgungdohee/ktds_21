package com.ktdsuniversity.admin.mbr.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktdsuniversity.admin.common.api.exceptions.ApiException;
import com.ktdsuniversity.admin.common.api.vo.ApiResponseVO;
import com.ktdsuniversity.admin.common.api.vo.ApiStatus;
import com.ktdsuniversity.admin.mbr.service.MbrService;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestMbrController {

	@Autowired
	private MbrService mbrService;
	
	@PostMapping("/api/mbr/lgn")
	public ApiResponseVO doLoginAdminMember(MbrVO mbrVO, HttpSession session) {
		MbrVO mbr = mbrService.readOneMbrVyIdAndPwd(mbrVO);
		if(mbr == null) {
			throw new ApiException("403", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		else {
			session.setAttribute("__ADMIN__", mbr);
		}
		return new ApiResponseVO(ApiStatus.OK,"","","/index");
	}
}
