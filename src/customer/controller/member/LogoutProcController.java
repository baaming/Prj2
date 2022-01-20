package customer.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.MemberDao;
import customer.vo.Member;

public class LogoutProcController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		System.out.println("========== < LogoutProcController > ==========");
		
		// 로그아웃 처리
		request.getSession().invalidate();
		response.sendRedirect("../customer/notice.do");
		
	}
	
}
