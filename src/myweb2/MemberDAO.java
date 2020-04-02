package myweb2;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private DataSource dataFactory;
    public MemberDAO(){

        try {
            Context ctx = new InitialContext();
            Context envContext = (Context)ctx.lookup("java:/comp/env");
            dataFactory = (DataSource)envContext.lookup("jdbc/mysql");
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public List<MemberBean> listMembers(){
        List<MemberBean> list = new ArrayList<MemberBean>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = dataFactory.getConnection();
            String sql = "select * from t_member order by joinDate DESC";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberBean bean = new MemberBean();
                bean.setId(id);
                bean.setPwd(pwd);
                bean.setName(name);
                bean.setEmail(email);
                bean.setJoinDate(joinDate);
                list.add(bean);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }catch(SQLException e){
            System.err.println("SqlException");
            e.printStackTrace();
        }catch(Exception ee){
            ee.printStackTrace();
        }
        return list;
    }

    public void add(MemberBean bean){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "insert into t_member values (?, ?, ?, ?, default)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getId());
            pstmt.setString(2, bean.getPwd());
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void delete(String id){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "delete from t_member where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean isExist(String id, String pwd){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        boolean flag = false;
        try{
            conn = dataFactory.getConnection();
            sql = "select * from t_member where id = ? and pwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            if(rs.next()){
                flag = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public List<MemberBean> findMember(String user_name){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        List<MemberBean> memberList = new ArrayList<>();
        try{
            conn = dataFactory.getConnection();
            sql = "select * from t_member where name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_name);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberBean bean = new MemberBean();
                bean.setId(id);
                bean.setPwd(pwd);
                bean.setName(name);
                bean.setEmail(email);
                bean.setJoinDate(joinDate);
                memberList.add(bean);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return memberList;
    }

    public boolean overLapped(String id){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sql;
        try{
            conn = dataFactory.getConnection();
            sql = "select * from t_member where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("true 를 리턴합니다.");
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

}


