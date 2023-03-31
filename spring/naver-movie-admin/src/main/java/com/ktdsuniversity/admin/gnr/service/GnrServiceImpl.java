package com.ktdsuniversity.admin.gnr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.gnr.dao.GnrDAO;
import com.ktdsuniversity.admin.gnr.vo.GnrVO;

@Service
public class GnrServiceImpl implements GnrService {
	
	@Autowired
	private GnrDAO gnrDAO;

	@Override
	public List<GnrVO> readAllGnrVO(String gnrNm) {
		return gnrDAO.readAllGnrVO(gnrNm);
	}

	@Override
	public boolean createOneGnr(GnrVO gnrVO) {
		return gnrDAO.createOneGnr(gnrVO) > 0;
	}

	@Override
	public boolean updateOneGnr(GnrVO gnrVO) {
		return gnrDAO.updateOneGnr(gnrVO) > 0;
	}

	@Override
	public boolean deleteOneGnrByGnrId(int gnrId) {
		return gnrDAO.deleteOneGnrByGnrId(gnrId) > 0;
	}

}
