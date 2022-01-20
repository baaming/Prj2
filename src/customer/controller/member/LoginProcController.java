package customer.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.MemberDao;
import customer.vo.Member;

public class LoginProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < LoginProcController > ==========");

		String uid = request.getParameter("id");
		String pwd = request.getParameter("password");

		MemberDao dao = new MemberDao();
		Member m = dao.getMember(uid); // 리턴타입이 Member니까 Member로 받아줘야 됨

		
		//System.out.println("m.pwd : " + m.getPwd()); 

		if (m == null) { // 아이디 없음
			request.setAttribute("error", "아이디틀림");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);

		} else if (!m.getPwd().equals(pwd)) { // DB에 있는 pwd와 내가 입력한 pwd가 일치하지 않은 경우
			request.setAttribute("error", "비번틀림");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		} else { // 로그인 성공
			// 아이디를 세션에 담고 notice.do로 이동
			request.getSession().setAttribute("uid", uid);
			response.sendRedirect("../customer/notice.do");
		}

	}

}
