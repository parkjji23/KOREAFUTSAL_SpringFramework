package com.korea.futsal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea.futsal.repository.MainDAO;
import com.korea.futsal.vo.*;

@Service
public class MainService {
	@Autowired
	private MainDAO singleDAO;
	
	public List<BranchDto> index_BranchList_service() {
		return singleDAO.getBranchList_dao();
	}
	public String idcheck_service(String id) {
		String ci = "using";
		List<MemberDto> checkId = singleDAO.selectID_dao(id);
		if(checkId.isEmpty())
			ci = "unusing";
		return ci;
	}
	public int signsubmit_service(MemberDto vo){
		return singleDAO.insert_member_dao(vo);
	}
	public String login_service(MemberDto vo){
		MemberDto loginresult = singleDAO.login_dao(vo);
		return (loginresult!=null)? "loginCom":"loginFail"; //조건문 한줄로쓰는방법, (조건), ? = if문을 뜻함, true : false
	}
	public List<TeamBoardListDto> teamboardlist_service(TeamPageDto teamPageDto) {
		return singleDAO.getTeamBoardList(teamPageDto);
	}
	public int teamboardlist_page_service(TeamPageDto teamPageDto) {
		return singleDAO.getListCount_teamboard(teamPageDto);
	}
	public List<TeamDto> teamboardlist_teamList_service(TeamPageDto teamPageDto) {
		return singleDAO.getTeamList(teamPageDto);
	}
	public List<NoticeboardDto> teamboardlist_notice_service(String a) {
		a = "팀게시판 공지사항";
		return singleDAO.getnoticelist(a);
	}
	public List<GroundDto> BranchDetail_ground_service(String BRANCHNO) {
		return singleDAO.getGroundDetail_ji(BRANCHNO);
	}
	public List<BranchDto> BranchDetail_branch_service(String BRANCHNO) {
		return singleDAO.getBranchDetail_ji(BRANCHNO);
	}
	/*public 페이징() {
		
	}*/

}
