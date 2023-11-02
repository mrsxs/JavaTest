package com.EmployeeManager.dao.impl;

import com.EmployeeManager.dao.DeptDao;
import com.EmployeeManager.entity.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门数据访问对象实现类
 */
public class DeptDaoimpl extends BaseDao implements DeptDao {

    /**
     * 添加部门
     *
     * @param dept 部门对象
     * @return 受影响的行数
     */
    @Override
    public int addDept(Dept dept) {
        int count = 0;

        try {

            String sql = "insert into dept(deptno, dname ,loc) values(?,?,?)";
            String[] params = {dept.getDeptno() + "", dept.getDname(), dept.getLoc()};

            count = super.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 删除部门
     *
     * @param deptno 部门编号
     * @return 受影响的行数
     */
    @Override
    public int deleteDept(int deptno) {
        int count = 0;


        try {

            String sql = "delete from emp where deptno=?";
            count = super.update(sql, deptno);

            String sql1 = "delete from dept where deptno=?";
            count = super.update(sql1, deptno);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 更新部门
     *
     * @param dept 部门对象
     * @return 受影响的行数
     */
    @Override
    public int updateDept(Dept dept) {
        int count = 0;


        try {
            String sql = "update dept set dname=COALESCE(?, dname),loc=COALESCE(?,loc) where deptno=?";
            Object[] params = {dept.getDname(), dept.getLoc(), dept.getDeptno()};

            count = super.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    /**
     * 获取所有部门
     *
     * @return 部门列表
     */
    @Override
    public List<Dept> getAlldepts() {
        List<Dept> list = new ArrayList<>();

        try {
            String sql = "select * from dept";
            ResultSet query = super.query(sql, null);
            while (query.next()) {
                Dept dept = new Dept();
                dept.setDeptno(query.getInt("deptno"));
                dept.setDname(query.getString("dname"));
                dept.setLoc(query.getString("loc"));
                list.add(dept);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        closeAll();
        return list;
    }

    /**
     * 根据部门编号获取部门
     *
     * @param id 部门编号
     * @return 部门列表
     */
    @Override
    public List<Dept> getById(int id) {
        List<Dept> list = new ArrayList<>();
        try {
            String sql = "select * from dept where deptno=?";
            Object[] params = {id};
            ResultSet rs = super.query(sql, params);
            while (rs.next()) {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                list.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeAll();
        return list;
    }

    /**
     * 判断部门编号是否存在
     *
     * @param deptId 部门编号
     * @return 是否存在
     */
    public boolean isExistdeptno(int deptId) {
        boolean exist = false;
        try {
            String sql = "select * from dept where deptno=?";
            exist = super.isExist(sql, deptId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return exist;

    }

    /**
     * 判断部门是否存在
     *
     * @param deptno 部门编号
     * @return 是否存在
     */
    @Override
    public boolean isExisdept(int deptno) {
        //判断emp这个表有没有deptno为deptno值的记录
        boolean exist = false;
        try {
            String sql = "select * from emp where deptno=?";
            exist = super.isExist(sql, deptno);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return exist;
    }
}
