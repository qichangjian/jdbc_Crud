package com.qcj.dao;

import com.qcj.entity.Dept;

import java.util.List;

public interface DeptDao {
    //插入数据
    int insert(Dept dept);
    //根据id删除数据
    int delete(int id);
    //修改时护具
    int update(Dept dept);
    //查询所有数据
    List<Dept> selectAll();
    //根据deptno查询数据
    List<Dept> selectDeptByNO(int id);
}
