package com.korea.futsal.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.UrlPathHelper;

import com.korea.futsal.service.MainService;
import com.korea.futsal.vo.*;

@Controller
@SessionAttributes("ID")
public class MainController {
	@Autowired
	private MainService singletoneService;
	
	@RequestMapping("/index")//�ε��������� �̵�
	public String index(Model model) {
		List<BranchDto> BranchList = singletoneService.index_BranchList_service();
		model.addAttribute("BranchList", BranchList);
		return "/WEB-INF/views/index.jsp";
	}
	@RequestMapping("/sign")//ȸ������������ �̵�
	public String signbutton() {
		return "/WEB-INF/views/sign.jsp";
	}
	@RequestMapping(value="/idCheck", method = {RequestMethod.POST, RequestMethod.GET})//���̵� �ߺ�Ȯ��
	public @ResponseBody String idcheck_Ajax(String id) {
		return singletoneService.idcheck_service(id); //ci : �ߺ�Ȯ�ΰ����.0�Ǵ�1.�ߺ����̵� ������ 1.
	}
	@RequestMapping(value="/signinput", method = {RequestMethod.POST, RequestMethod.GET})
	public String signsubmit(Model model,@ModelAttribute MemberDto vo) {
		int signresult = singletoneService.signsubmit_service(vo); //signresult ; insert����� : 0=ȸ�����Խ���, 1=ȸ�����Լ��� [���߿� ���ǹ��� �� �� ����]
		model.addAttribute("signComUser", vo);
		return "/WEB-INF/views/insertResult.jsp";
	}
	@RequestMapping(value="/loginbutton", method = RequestMethod.POST)
	public @ResponseBody String loginbutton(@ModelAttribute MemberDto vo, Model model) {
		System.out.println("������ ���̵�: "+vo.getID());
		System.out.println("������ ���: "+vo.getPW());
		String lr = singletoneService.login_service(vo);
		if(lr.equals("loginCom")) {
			model.addAttribute("ID",vo.getID());
			model.addAttribute("PW",vo.getPW());
		}
		return lr; //�α��ΰ���� loginCom <>loginFail
	}
	@RequestMapping("/teamboardlist")//���Խ��� �̵�
	public String teamboardlist_menu(@ModelAttribute String a ,@ModelAttribute TeamPageDto teamPageDto,Model model) {
		List<TeamBoardListDto> teamboardlist = singletoneService.teamboardlist_service(teamPageDto);
		int teamboardlist_page = singletoneService.teamboardlist_page_service(teamPageDto);
		List<TeamDto> teamlist = singletoneService.teamboardlist_teamList_service(teamPageDto);
		List<NoticeboardDto> teamboardlistNotice = singletoneService.teamboardlist_notice_service(a);
		model.addAttribute("teamboardlist", teamboardlist);
		model.addAttribute("teamboardlist_page", teamboardlist_page);
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("teamboardlistNotice", teamboardlistNotice);
		return "/WEB-INF/views/team_board_list.jsp";
	}
	@RequestMapping("/branchlistview")//��������� �̵�
	public String branchlist_menu(Model model) {
		List<BranchDto> BranchList = singletoneService.index_BranchList_service();
		model.addAttribute("BranchList", BranchList);
		return "/WEB-INF/views/branchlist.jsp";
	}
	@RequestMapping(value = "/branchdetail", method = { RequestMethod.POST, RequestMethod.GET })//��� �󼼺���
	public String branchdetail(@RequestParam String BRANCHNO, Model model) {
		List<BranchDto> BranchList = singletoneService.index_BranchList_service();
		List<GroundDto> GrounddetailList = singletoneService.BranchDetail_ground_service(BRANCHNO);
		List<BranchDto> BranchdetailList = singletoneService.BranchDetail_branch_service(BRANCHNO);
		model.addAttribute("BranchList", BranchList);
		model.addAttribute("GrounddetailList", GrounddetailList);
		model.addAttribute("BranchdetailList", BranchdetailList);
		return "/WEB-INF/views/branchdetail.jsp";
	}

	/*@����¡
	public ����¡() {
		return ����¡;
	}*/
	//<�α��λ�������>
		/*int check=(int)request.getAttribute("check");
		String loginChk = request.getParameter("loginchk");
		String loginid = request.getParameter("username");
		System.out.println(loginChk+"��Ű üũ �� �����°�");
		if(check==0) {
			out.println("<script>alert('���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.');</script>");
		}else {
			
			if (loginChk != null) { // üũ�� ���
				Cookie c = new Cookie("id", loginid);
				c.setMaxAge(60*60);;
				c.setPath("/");
				response.addCookie(c);
			}
			out.println("ok");
			out.println("<script>alert('�α��ο������Ͽ����ϴ�.')</script>");
		}*/
		/*if (!loginuser.isEmpty()) {
		  	request.setAttribute("check", 1);
		}else {
			request.setAttribute("check", 0);
		}*/
	

////////////////////////////////////////////////////////////////////////////////////////
/*// �۾����� �̵�
@RequestMapping("/insertform")
public String insertlocationbutton() {
return "/WEB-INF/views/InsertForm.jsp";
}*/
/*
// �۾���
@RequestMapping(value = "/insert", method = { RequestMethod.POST, RequestMethod.GET })
public String insertadd(@ModelAttribute QnaDto vo) {
singletoneDAO.insert(vo);
return "redirect:/index";
}

// ������ư�̵�
@RequestMapping("/deleteform")
public String deletebutton() {
return "/WEB-INF/views/DeleteForm.jsp";
}

// �Խù�����
@RequestMapping(value = "/delete", method = { RequestMethod.POST, RequestMethod.GET })
public String delete(@RequestParam Integer pwd) {
singletoneDAO.delete(pwd);
return "redirect:/index";
}

// �Խù� �󼼺���
@RequestMapping(value = "/detail", method = { RequestMethod.POST, RequestMethod.GET })
public String titleclick(Model model, int no) {
QnaDto detaillist = singletoneDAO.detail(no);
model.addAttribute("detaillist", detaillist);

return "/WEB-INF/views/BoardDetail.jsp";
}

// ���������� ����Ʈ�������̵�
@RequestMapping(value = "/updateform", method = { RequestMethod.POST, RequestMethod.GET })
public String updateform(Model model, int no) {
QnaDto detaillist = singletoneDAO.detail(no);
model.addAttribute("detaillist", detaillist);
return "/WEB-INF/views/UpdateForm.jsp";
}

// �Խù�����
@RequestMapping(value = "/update", method = { RequestMethod.POST, RequestMethod.GET })
public String update(@ModelAttribute QnaDto vo) {
singletoneDAO.update(vo);
return "redirect:/index";
}*/
}
