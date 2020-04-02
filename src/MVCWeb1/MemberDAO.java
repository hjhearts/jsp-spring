package MVCWeb1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private DataSource dataFactory;

    public MemberDAO() {
        try {
            System.out.println("MemberDAO 생성자 호출");
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/mysql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<MemberVO> listMembers(){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        List<MemberVO> membersList = new ArrayList<MemberVO>();
        try{
            conn = dataFactory.getConnection();
            sql = "select * from t_member order by joinDate DESC";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
                membersList.add(memberVO);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return membersList;
    }
    public void addMember(MemberVO vo){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "insert into t_member(id, pwd, name, email) values(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPwd());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delMember(String id){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            MemberVO memberVO = findMemberById(id);
            if(memberVO != null) {
                sql = "delete from t_member where id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
            }else{
                System.out.println("아이디 조회 결과가 없습니다");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public MemberVO findMemberById(String id){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        MemberVO memberVO = null;
        try{
            conn = dataFactory.getConnection();
            sql = "select * from t_member where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                String _id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                memberVO = new MemberVO(_id, pwd, name, email, joinDate);
            }else{
                System.out.println("아이디 정보가 없습니다.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return memberVO;
    }
    public void modMember(MemberVO vo){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "update t_member set pwd=?, name=?, email=? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getPwd());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getId());
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}