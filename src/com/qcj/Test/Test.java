package com.qcj.Test;

import com.qcj.dao.impl.DeptDaoImpl;
import com.qcj.entity.Dept;

import java.util.List;

/**
 *    默写的完整的增删改查
 */
public class Test {
    public static void main(String[] args) {
        DeptDaoImpl deptDao = new DeptDaoImpl();
        //向dept表中插入数据
        Dept dept = new Dept(50,"CLEAN","NAC");
        deptDao.insert(dept);
        //查询编号为50的数据
        System.out.println("-------查询id为50部门----------");
        List<Dept> deptList = deptDao.selectDeptByNO(50);
        deptList.forEach(System.out::println);
        //查询所有
        System.out.println("-------查询所有----------");
        List<Dept> deptListAll =deptDao.selectAll();
        deptListAll.forEach(System.out::println);
        //删除50的数据
        deptDao.delete(50);
    }
}
