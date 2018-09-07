package com.qcj.dao.impl;

import com.qcj.dao.DeptDao;
import com.qcj.entity.Dept;
import com.qcj.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public int insert(Dept dept) {
        int rows = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,dept.getDeptno());
            ps.setString(2,dept.getDname());
            ps.setString(3,dept.getLoc());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    @Override
    public int update(Dept dept) {
        int rows = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update dept set dname = ? , loc = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dept.getDname());
            ps.setString(2,dept.getLoc());
            ps.setInt(3,dept.getDeptno());

            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    @Override
    public List<Dept> selectAll() {
        List<Dept> list = new LinkedList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                list.add(dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<Dept> selectDeptByNO(int id) {
        List<Dept> list = new LinkedList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                list.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
