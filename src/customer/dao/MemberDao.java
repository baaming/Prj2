package customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import customer.db.DBCon;
import customer.vo.Member;

public class MemberDao {
	public Member getMember(String uid) throws Exception {

		String sql = "SELECT * FROM member WHERE id=?";

		Connection con = DBCon.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, uid);

		ResultSet rs = pstmt.executeQuery();

		Member m = null; // m값을 리턴해주기 위해 if문 밖에 m을 선언해준 것

		if (rs.next()) {
			m=new Member();
			m.setId(rs.getString("id"));
			m.setPwd(rs.getString("pwd"));
			System.out.println("m.id : " + m.getId());
		}

		return m;
	}
}
