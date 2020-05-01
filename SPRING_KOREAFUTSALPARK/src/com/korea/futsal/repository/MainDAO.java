package com.korea.futsal.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korea.futsal.vo.*;

@Repository
public class MainDAO {
	@Autowired
	private DataSource datasource;

	@Autowired
	private SqlSession sqlsession;

	// index & branchlistview & branchdetail
	public List<BranchDto> getBranchList_dao() {
		List<BranchDto> BranchList = sqlsession.selectList("futsalsql.branchlist_view");
		return BranchList;
	}

	// idCheck
	public List<MemberDto> selectID_dao(String id) {
		return sqlsession.selectList("futsalsql.IDCheck", id);
	}

	// signinput
	public int insert_member_dao(MemberDto vo) {
		return sqlsession.insert("futsalsql.Signinsert", vo);
	}

	// loginbutton
	public MemberDto login_dao(MemberDto vo) {
		return sqlsession.selectOne("futsalsql.Login", vo);
	}

	// teamboardlist
	public List<TeamBoardListDto> getTeamBoardList(TeamPageDto teamPageDto) {
		List<TeamBoardListDto> teamboardlist = sqlsession.selectList("futsalsql.listPage", teamPageDto);
		return teamboardlist;
	}

	public int getListCount_teamboard(TeamPageDto teamPageDto) {
		int listCount = 0;
		listCount = sqlsession.selectOne("futsalsql.gettotalcount", teamPageDto);
		return listCount;
	}

	public List<TeamDto> getTeamList(TeamPageDto teamPageDto) {
		List<TeamDto> TeamList = sqlsession.selectList("futsalsql.getteamlist", teamPageDto);
		return TeamList;
	}

	public List<NoticeboardDto> getnoticelist(String a) {
		List<NoticeboardDto> noticelist = sqlsession.selectList("futsalsql.noticeboardList3", a);
		return noticelist;
	}

	// branchdetail
	public List<GroundDto> getGroundDetail_ji(String BRANCHNO) {
		List<GroundDto> GrounddetailList = sqlsession.selectList("futsalsql.grounddetail_view", BRANCHNO);
		return GrounddetailList;
	}
	public List<BranchDto> getBranchDetail_ji(String BRANCHNO) {
		List<BranchDto> BranchdetailList = sqlsession.selectList("futsalsql.branchdetail_view", BRANCHNO);
		return BranchdetailList;
	}
	/*
	 * // BranchDetail_Action public List<BranchDto> getBranchList2_ji() {
	 * List<BranchDto> BranchList =
	 * sqlsession.selectList("futsalsql.branchlist_view_admin"); return BranchList;
	 * }
	 */
	/*
	 * // Admin_QnAList_Action public List<QnaDto> Qnaviewlist() { List<QnaDto>
	 * Qnalist = sqlsession.selectList("futsalsql.AdminQnaListview"); return
	 * Qnalist; }
	 * 
	 * public List<QnaDto> Qnaviewdetail(int q_b_no) { List<QnaDto> QnaDetaillist =
	 * sqlsession.selectList("futsalsql.AdminQnaDetailview", q_b_no); return
	 * QnaDetaillist; }
	 * 
	 * // AdminBrabchRepinsertAction public void insertinform(AdminBranchRepDto
	 * AdminBranchRepDto) { sqlsession.insert("futsalsql.AdminBranchRepinsert",
	 * AdminBranchRepDto); }
	 * 
	 * public List<AdminBranchRepDto> getAdminBranchRep(String branch_no) {
	 * List<AdminBranchRepDto> AdminBranchRepList =
	 * sqlsession.selectList("futsalsql.AdminBranchRepselect", branch_no); return
	 * AdminBranchRepList; }
	 * 
	 * // ApplyList_Action ->TeamApplyList_Service public List<PlayerRegistDto>
	 * getLeader(PlayerRegistDto Player) { PlayerRegistDto obb = Player;
	 * List<PlayerRegistDto> Applyer =
	 * sqlsession.selectList("futsalsql.leader_check", obb); return Applyer; }
	 * 
	 * public List<PlayerRegistDto> getApplyer_team(PlayerRegistDto Player) {
	 * PlayerRegistDto obb = Player; List<PlayerRegistDto> Applyer =
	 * sqlsession.selectList("futsalsql.team_apply_list", obb); return Applyer; }
	 * 
	 * public List<MemberDto> getMember(PlayerRegistDto applyer) { PlayerRegistDto
	 * obb = applyer; List<MemberDto> Member =
	 * sqlsession.selectList("futsalsql.team_apply_member_list", obb); return
	 * Member; }
	 * 
	 * // BrabchinsertAction public void insertinform(BranchDto BranchDto) {
	 * sqlsession.insert("futsalsql.Brabchinsert", BranchDto); }
	 * 
	 * public void insertinform2(BranchDto BranchDto) {
	 * sqlsession.update("futsalsql.Brabchupdate", BranchDto); }
	 */

	/*
	 * // BranchList_Action2 public List<BranchDto> getBranchList(String id) {
	 * List<BranchDto> BranchList =
	 * sqlsession.selectList("futsalsql.branchlist_view2", id); return BranchList; }
	 * 
	 * public List<BranchDto> getBranchList2(String branch_no) { List<BranchDto>
	 * BranchList2 = sqlsession.selectList("futsalsql.branchdetail_view2",
	 * branch_no); return BranchList2; }
	 * 
	 * // ConfirmbranchAction public List<BranchDto> selectbrabch(String
	 * branch_name) { List<BranchDto> checkbrabch =
	 * sqlsession.selectList("futsalsql.checkbrabch", branch_name); return
	 * checkbrabch; }
	 * 
	 * // ConfirmgroundAction public List<GroundDto> selectground(String
	 * ground_name) { List<GroundDto> checkground =
	 * sqlsession.selectList("futsalsql.checkground", ground_name); return
	 * checkground; }
	 * 
	 * // DatepickerSelectHiddenAction public List<ComResInfoDto>
	 * datepickerselecthidden(ComResInfoDto ComResInfoDto) { List<ComResInfoDto>
	 * ComResInfoList = sqlsession.selectList("futsalsql.datepicker_selecthidden",
	 * ComResInfoDto); return ComResInfoList; }
	 * 
	 * // DeleteReservation_Action public void Reservationdelete(int res_no) {
	 * sqlsession.delete("futsalsql.reservation_delete", res_no); }
	 * 
	 * // GroundinsertAction public void insertinform(GroundDto GroundDto) {
	 * sqlsession.insert("futsalsql.Groundinsert", GroundDto); }
	 * 
	 * // LeaderCheck_Action public List<TeamDto> leadercheck(String id) {
	 * List<TeamDto> leadercheckteam =
	 * sqlsession.selectList("futsalsql.leadercheck", id); return leadercheckteam; }
	 * 
	 * // League_allselect_Action public List<LeagueDto> getLeagueall() {
	 * List<LeagueDto> leagueAllList =
	 * sqlsession.selectList("futsalsql.leagueallselect"); return leagueAllList; }
	 * 
	 * // League_BranchList_Action public List<BranchDto> getLeagueBranchList() {
	 * List<BranchDto> leagueBranchList =
	 * sqlsession.selectList("futsalsql.leaguebranchlist"); return leagueBranchList;
	 * }
	 * 
	 * // League_join_step2_Action public List<LeagueDto> getLeaguecode1(int
	 * branch_no) { List<LeagueDto> leaguecode =
	 * sqlsession.selectList("futsalsql.leagueselectone", branch_no); return
	 * leaguecode; }
	 * 
	 * public List<TeamDto> getTeamList1(String id) { List<TeamDto> teamlist =
	 * sqlsession.selectList("futsalsql.teamleaguelist", id); return teamlist; }
	 * 
	 * //
	 * League_join_step3_Action*****************************************************
	 * ********************** public int playerregist(PlayerRegistDto
	 * playerRegistDto) { int playerregistresult1 =
	 * sqlsession.insert("futsalsql.leagueplayerregist", playerRegistDto); return
	 * playerregistresult1; }
	 * 
	 * // League_join_teamcheck_Action public List<LeagueResultDto>
	 * leagueteamcheck(LeagueResultDto leagueResultDto) { List<LeagueResultDto>
	 * leagueteamcheck = sqlsession.selectList("futsalsql.leagueteamcheck",
	 * leagueResultDto); return leagueteamcheck; }
	 * 
	 * public List<PlayerRegistDto> playerleaguecheck(PlayerRegistDto
	 * LeagueResultDto) { System.out.println("액션까지옴"); List<PlayerRegistDto>
	 * playerleaguecheck = sqlsession.selectList("futsalsql.leaguecheck",
	 * LeagueResultDto); return playerleaguecheck; }
	 * 
	 * public List<LeagueResultDto> leaguecheck(LeagueResultDto LeagueResultDto) {
	 * List<LeagueResultDto> playerleaguecheck =
	 * sqlsession.selectList("futsalsql.leaguecheck", LeagueResultDto); return
	 * playerleaguecheck; }
	 * 
	 * // League_team_step2_Action public List<LeagueDto> getLeaguecode(int
	 * branch_no) { List<LeagueDto> leaguecode =
	 * sqlsession.selectList("futsalsql.leagueselectone", branch_no); return
	 * leaguecode; }
	 * 
	 * public List<TeamDto> getTeamList_team(String id) { List<TeamDto> teamlist =
	 * sqlsession.selectList("futsalsql.teamleaguelist", id); return teamlist; }
	 * 
	 * // League_team_step3_Action public int teamregist(PlayerRegistDto
	 * playerRegistDto, LeagueResultDto leagueResultDto) { int teamregistresult1 =
	 * sqlsession.insert("futsalsql.leagueteamregist", leagueResultDto); return
	 * teamregistresult1; }
	 * 
	 * // LeagueList_Action public List<LeagueDto> getLeagueList() { List<LeagueDto>
	 * leagueList = sqlsession.selectList("futsalsql.leaguelist"); return
	 * leagueList; }
	 * 
	 * // LeagueResult_Action public List<LeagueResultDto>
	 * getLeagueResult(LeagueResultDto leagueresult) { LeagueResultDto obb =
	 * leagueresult; List<LeagueResultDto> LeagueResult =
	 * sqlsession.selectList("futsalsql.league_result", obb); return LeagueResult; }
	 * 
	 * public List<LeagueResultDto> getLeaguePoint(LeagueResultDto leagueresult) {
	 * LeagueResultDto obb = leagueresult; List<LeagueResultDto> LeagueResult =
	 * sqlsession.selectList("futsalsql.league_point", obb); return LeagueResult; }
	 * 
	 * public List<LeagueDto> getLeague(LeagueResultDto leagueresult) {
	 * LeagueResultDto obb = leagueresult; List<LeagueDto> LeagueResult =
	 * sqlsession.selectList("futsalsql.league", obb); return LeagueResult; }
	 * 
	 * // LeagueResult_Action2 public List<LeagueResultDto> getLeagueResult(int
	 * league_code) { List<LeagueResultDto> LeagueResult =
	 * sqlsession.selectList("futsalsql.league_result_Whleague", league_code);
	 * return LeagueResult; }
	 * 
	 * public List<PlayerRegistDto> getLeaguePlayer(int league_code) {
	 * List<PlayerRegistDto> LeaguePlayer =
	 * sqlsession.selectList("futsalsql.league_player_Whleague", league_code);
	 * return LeaguePlayer; }
	 * 
	 * // AdminLoginAction public List<AdminDto> login(AdminDto AdminDto) {
	 * List<AdminDto> loginadmin = sqlsession.selectList("futsalsql.AdminLogin",
	 * AdminDto); return loginadmin; }
	 * 
	 * // Matchapply_Action public int getListCount_match(TeamPageDto teamPageDto) {
	 * int listCount = 0; listCount =
	 * sqlsession.selectOne("futsalsql.matchtotalcount", teamPageDto); return
	 * listCount; }
	 * 
	 * public List<MatchlistDto> getMacthList(TeamPageDto teamPageDto) {
	 * List<MatchlistDto> matchlist =
	 * sqlsession.selectList("futsalsql.getmatchlist", teamPageDto); return
	 * matchlist; }
	 * 
	 * // MemberDetail_Action public List<GroundDto> getGroundDetail(String
	 * branch_no) { List<GroundDto> GroundList =
	 * sqlsession.selectList("futsalsql.grounddetail_view", branch_no); return
	 * GroundList; }
	 * 
	 * public List<BranchDto> getBranchDetail(String branch_no) { List<BranchDto>
	 * BranchList = sqlsession.selectList("futsalsql.branchdetail_view", branch_no);
	 * return BranchList; }
	 * 
	 * public List<MemberDto> getBranchList2() { List<MemberDto> MemberList =
	 * sqlsession.selectList("futsalsql.memberlist_view"); return MemberList; }
	 * 
	 * public List<MemberDto> getMemberDetail(String id) { List<MemberDto>
	 * MemberList = sqlsession.selectList("futsalsql.memberdetail_view", id); return
	 * MemberList; }
	 * 
	 * // Mypage_myteam_Action public List<TeamDto> getmyteaminfo(String id) {
	 * List<TeamDto> myteamlist = sqlsession.selectList("futsalsql.myteam", id);
	 * return myteamlist; }
	 * 
	 * public List<LeagueandLeagueResultDto> getmyleagueinfo(String id) {
	 * List<LeagueandLeagueResultDto> myleaguelist =
	 * sqlsession.selectList("futsalsql.myleague", id); return myleaguelist; }
	 * 
	 * //
	 * NoticeboardList_Action*******************************************************
	 * ************** public void noticeboard_readcount(NoticeboardDto NoticeDto) {
	 * NoticeboardDto obb = NoticeDto; int noticeboard_readcount =
	 * sqlsession.update("futsalsql.noticeboard_readcount", obb); }
	 * 
	 * public void noticeboard_insert(NoticeboardDto NoticeDto) {
	 * sqlsession.insert("futsalsql.noticeboard_insert", NoticeDto); }
	 * 
	 * public List<NoticeboardDto> getNoticeboardList(String a) {
	 * List<NoticeboardDto> noticeboardList =
	 * sqlsession.selectList("futsalsql.noticeboardList3", a); return
	 * noticeboardList; } public List<NoticeboardDto> getNoticeboardList2(int n_num)
	 * { List<NoticeboardDto> noticeboardList2 =
	 * sqlsession.selectList("futsalsql.noticeboardList_view2", n_num); return
	 * noticeboardList2; } public List<NoticeboardDto> getNoticeboardList() {
	 * List<NoticeboardDto> noticeboardList =
	 * sqlsession.selectList("futsalsql.noticeboardList"); return noticeboardList; }
	 * // Onedaystatus30_Action public void onedaylater_update(ReservationDto
	 * ReservationDto) { sqlsession.update("futsalsql.oneday_status30",
	 * ReservationDto); } // Paymentpage_Action public void
	 * insertReservation_paymentpage(ReservationDto ReservationDto) {
	 * sqlsession.insert("input_reservation_paymentpage", ReservationDto); } //
	 * PaymentsuccessAction public List<ReservationDto> getsuccessReservation(int
	 * res_no) { List<ReservationDto> ReservationList =
	 * sqlsession.selectList("futsalsql.paymentsuccess_Reservation",res_no); return
	 * ReservationList; } public List<BranchDto> getsuccessBranch(int res_no) {
	 * List<BranchDto> BranchList =
	 * sqlsession.selectList("futsalsql.paymentsuccess_Branch",res_no); return
	 * BranchList; } public List<GroundDto> getsuccessGround(int res_no) {
	 * List<GroundDto> GroundList =
	 * sqlsession.selectList("futsalsql.paymentsuccess_Ground",res_no); return
	 * GroundList; } // PlayerApply_Action public void getApplyer(PlayerRegistDto
	 * Player) { int applyer=0; PlayerRegistDto obb = Player; applyer =
	 * sqlsession.insert("futsalsql.team_apply", obb);
	 * sqlsession.insert("futsalsql.team_apply", obb); } // PlayerRegist_Action
	 * public List<PlayerRegistDto> getPlayerList(PlayerRegistDto Player) {
	 * PlayerRegistDto obb = Player; List<PlayerRegistDto> PlayerList =
	 * sqlsession.selectList("futsalsql.player_list",obb); return PlayerList; }
	 * public List<MemberDto> getMemberList(PlayerRegistDto Player) {
	 * PlayerRegistDto obb = Player; List<MemberDto> PlayerList =
	 * sqlsession.selectList("futsalsql.player_list_member",obb); return PlayerList;
	 * } // Qna_Action public List<QnaDto> selectQnaList(TeamPageDto teamPageDto) {
	 * List<QnaDto> list =
	 * sqlsession.selectList("futsalsql.getqnalist",teamPageDto); return list; }
	 * public int getListCount_qna(TeamPageDto teamPageDto) { int listCount = 0;
	 * listCount = sqlsession.selectOne("futsalsql.qnatotalcount", teamPageDto);
	 * return listCount; } // Res_statusAction public void
	 * updateresstaus(ReservationDto ReservationDto) {
	 * sqlsession.update("futsalsql.res_status_update", ReservationDto); } //
	 * Reservation_Action public void insertReservation(ReservationDto
	 * ReservationDto) { sqlsession.insert("futsalsql.input_reservation",
	 * ReservationDto); } // ReservationClick_Action public List<GroundDto>
	 * reservation_ground(String branch_no) { List<GroundDto> GroundList =
	 * sqlsession.selectList("futsalsql.click_ground_reservation",branch_no); return
	 * GroundList; } public List<BranchDto> reservation_branch(String branch_no) {
	 * List<BranchDto> BranchList =
	 * sqlsession.selectList("futsalsql.click_branch_reservation",branch_no); return
	 * BranchList; } public List<ReservationDto> getbookedDate(String branch_no) {
	 * List<ReservationDto> ReservationList =
	 * sqlsession.selectList("futsalsql.unavailable_nodatetime_pick",branch_no);
	 * return ReservationList; } public List<ComResInfoDto>
	 * getfulldate(ComResInfoDto comResInfoDto) { List<ComResInfoDto> fulldatelist =
	 * sqlsession.selectList("futsalsql.fulldate_select",comResInfoDto); return
	 * fulldatelist; } // Reservationhidden_Action public List<ComResInfoDto>
	 * selecthiddenobject(ComResInfoDto ComResInfoDto) { List<ComResInfoDto>
	 * ComResInfoList =
	 * sqlsession.selectList("futsalsql.rescomplete_ground_as_date",ComResInfoDto);
	 * return ComResInfoList; } // ReservationList_Action public
	 * List<ReservationDto> getReservationList(String id) { List<ReservationDto>
	 * reservationlist = sqlsession.selectList("futsalsql.reservationlist",id);
	 * return reservationlist; } public List<BranchDto>
	 * getReservationListBranch(String id) { List<BranchDto> BranchList =
	 * sqlsession.selectList("futsalsql.reservationlist_Branch",id); return
	 * BranchList; } public List<GroundDto> getReservationListGround(String id) {
	 * List<GroundDto> GroundList =
	 * sqlsession.selectList("futsalsql.reservationlist_Ground",id); return
	 * GroundList; } // SelectgroundAction public List<GroundDto>
	 * selectGroundname(GroundDto groundDto) { List<GroundDto> GroundList =
	 * sqlsession.selectList("futsalsql.GroundCheck",groundDto); return GroundList;
	 * } // SignModel public List<MemberDto> selectMember(String arg) {
	 * List<MemberDto> list = sqlsession.selectList("futsalsql.selectMember",arg);
	 * return list; } public MemberDto insertSangpum(MemberDto sangpum) { MemberDto
	 * obb = sangpum; int result = sqlsession.insert("futsalsql.insertSangpum",
	 * obb); return obb; } public MemberDto modifySign(MemberDto member) { MemberDto
	 * obb = member; int result = sqlsession.update("futsalsql.modifySign", obb);
	 * return obb; } public MemberDto modifyPw(MemberDto member) { MemberDto obb =
	 * member; int result = sqlsession.update("futsalsql.modifyPw", obb); return
	 * obb; } public MemberDto delSign(MemberDto member) { MemberDto obb = member;
	 * int result = sqlsession.delete("delSign", obb); return obb; } public
	 * List<QnaDto> selectQnaSearch(QnaDto board) { QnaDto obb = board; List<QnaDto>
	 * list = null; if (obb.getQ_b_email().equals("qTitle")) { list =
	 * sqlsession.selectList("futsalsql.qnatitle",obb); } else if
	 * (obb.getQ_b_email().equals("qContents")) { list =
	 * sqlsession.selectList("futsalsql.qnacontents",obb); } return list; } //
	 * Team_apply_check_Action********************************************* public
	 * List<PlayerRegistDto> playerapplycheck(PlayerRegistDto player) {
	 * List<PlayerRegistDto> playerapplycheck =
	 * sqlsession.selectList("futsalsql.playerapplycheck",player); if
	 * (!playerapplycheck.isEmpty()) System.out.println("지원 한 결과가 있으며 ..가져온아이디: " +
	 * playerapplycheck.get(0).getId()); else System.out.println("null 이 담겼다..");
	 * return playerapplycheck; }
	 * //************************************************** public
	 * List<PlayerRegistDto> playerteamcheck(PlayerRegistDto player) {
	 * List<PlayerRegistDto> playerteamcheck =
	 * sqlsession.selectList("futsalsql.playerteamcheck", player); if
	 * (!playerteamcheck.isEmpty()) System.out.println("가져온아이디: " +
	 * playerteamcheck.get(0).getId()); return playerteamcheck; } //
	 * Team_Join_Action public void approval(PlayerRegistDto Player) { int Applyer =
	 * 0; PlayerRegistDto obb = Player; Applyer =
	 * sqlsession.insert("futsalsql.join_success", obb);
	 * sqlsession.delete("futsalsql.join_fail", obb); } public void
	 * refusal(PlayerRegistDto Player) { int Applyer = 0; PlayerRegistDto obb =
	 * Player; Applyer = sqlsession.delete("futsalsql.join_fail", obb); } //
	 * TeamboarddeleteAction public void teamboarddelete(TeamBoardListDto
	 * teamBoardListDto) { sqlsession.delete("futsalsql.teamboarddelete",
	 * teamBoardListDto); } // TeamBoardDetail_Action public TeamBoardListDto
	 * teamBoardDetail(int teamBoardNo) {
	 * sqlsession.update("futsalsql.teamboardreadcount", teamBoardNo);
	 * TeamBoardListDto teamBoardOne =
	 * sqlsession.selectOne("futsalsql.teamboarddetail", teamBoardNo); return
	 * teamBoardOne; } // TeamboardListWriteAction public void
	 * insertinform(TeamBoardListDto teamBoardListDto) {
	 * sqlsession.insert("futsalsql.teamboardinsert", teamBoardListDto); } //
	 * TeamBoardListWriteformAction public List<TeamDto> getTeamList(String id) {
	 * List<TeamDto> teamlist = sqlsession.selectList("futsalsql.teamlist", id);
	 * return teamlist; } // TeamboardmodifyAction public void
	 * teamboardmodify(TeamBoardListDto teamBoardListDto) {
	 * sqlsession.update("futsalsql.teamboardmodify", teamBoardListDto); } //
	 * TeamBoardRep_Action public List<TeamBoardRepDto> teamBoardRep(int
	 * teamBoardNo) { List<TeamBoardRepDto> teamBoardRep =
	 * sqlsession.selectList("futsalsql.teamboardrep", teamBoardNo); return
	 * teamBoardRep; } // TeamBoardRepInsert_Action public int
	 * TeamRepInsert(TeamBoardRepDto teamboardrep) { int count =
	 * sqlsession.insert("futsalsql.teamboardrepinsert", teamboardrep); return
	 * count; } // TeamList_Action public List<TeamDto> getRegistPlayer1() {
	 * List<TeamDto> TeamList =
	 * sqlsession.selectList("futsalsql.registplayer_view"); return TeamList; }
	 * public List<TeamDto> selectTeamOne(TeamDto team) { TeamDto obb = team;
	 * List<TeamDto> list = sqlsession.selectList("futsalsql.teamone", obb); return
	 * list; } public int getListCount_teamlist(TeamPageDto teamPageDto) { int
	 * listCount = 0; listCount = sqlsession.selectOne("futsalsql.teamtotalcount",
	 * teamPageDto); return listCount; } // TeamModifyAction public void
	 * modifyinform(TeamDto TeamDto) { int result =
	 * sqlsession.update("futsalsql.Teammodify", TeamDto); } // TeamModifyFormAction
	 * public List<TeamDto> getTeamList(TeamDto TeamDto) { List<TeamDto> list =
	 * sqlsession.selectList("futsalsql.teamone", TeamDto); return list; } //
	 * TeamRegistAction public void insertinform(TeamDto TeamDto) { Random random =
	 * new Random(); int result = 0; while (result != 1) {
	 * TeamDto.setT_code(random.nextInt(1000000)); result =
	 * sqlsession.insert("futsalsql.Teaminsert", TeamDto); } } // TeamSearchAction
	 * public List<TeamDto> searchinform(TeamDto teamlist) { List<TeamDto> list =
	 * null; TeamDto obb = teamlist; if (obb.getTeamtype().equals("전체") ||
	 * obb.getBranchcode().equals("전국현황")) { list =
	 * sqlsession.selectList("futsalsql.searchteamlistall", obb); } else { list =
	 * sqlsession.selectList("futsalsql.searchteamlist", obb); } return list; }
	 * public List<TeamDto> getRegistPlayer() { List<TeamDto> TeamList =
	 * sqlsession.selectList("futsalsql.registplayer_view"); return TeamList; } //
	 * Yonglist_Action public int getListCount(TeamPageDto teamPageDto) { int
	 * listCount = 0; listCount = sqlsession.selectOne("futsalsql.yongtotalcount",
	 * teamPageDto); return listCount; } public List<YonglistDto>
	 * getYongList(TeamPageDto teamPageDto) { List<YonglistDto> yonglist =
	 * sqlsession.selectList("futsalsql.getyonglist", teamPageDto); return yonglist;
	 * }
	 */
}
