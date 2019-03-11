package question;

import util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import question.QuestionVO;

public class QuestionDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	
	public ArrayList<QuestionVO> Test()
	{
		ArrayList<QuestionVO> datas = new ArrayList<QuestionVO>();
		
		try {
			conn = JDBCutil.connect();
			
			String sql = "select * from question_package";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				QuestionVO question = new QuestionVO();
				question.setNo(Integer.valueOf(rs.getString("no")));
				question.setTitle(rs.getString("title"));
				question.setQ1(rs.getString("q1"));
				question.setQ2(rs.getString("q2"));
				question.setQ3(rs.getString("q3"));
				question.setQ4(rs.getString("q4"));
				question.setPart(rs.getString("part"));
				question.setAnswer(rs.getString("answer"));
				
				
				System.out.println("=======>"+ question.getTitle());
			
				datas.add(question);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		JDBCutil.disconnect(pstmt, conn);
		}
		
		
		return datas;
	}
	
}
