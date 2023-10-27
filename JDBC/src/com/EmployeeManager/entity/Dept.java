package com.EmployeeManager.entity;

import com.EmployeeManager.dao.impl.DeptDaoimpl;

public class Dept extends DeptDaoimpl {
    private int deptno;
    private String dname;
    private String loc;

    public Dept() {
    }

    /**
     * 构造函数
     *
     * @param deptno 部门编号
     * @param dname 部门名称
     * @param loc 部门所在地
     */
    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    /**
     * 获取部门编号
     *
     * @return 部门编号
     */
    public int getDeptno() {
        return deptno;
    }

    /**
     * 设置部门编号
     *
     * @param deptno 部门编号
     */
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    /**
     * 获取部门名称
     *
     * @return 部门名称
     */
    public String getDname() {
        return dname;
    }

    /**
     * 设置部门名称
     *
     * @param dname 部门名称
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * 获取部门所在地
     *
     * @return 部门所在地
     */
    public String getLoc() {
        return loc;
    }

    /**
     * 设置部门所在地
     *
     * @param loc 部门所在地
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * 返回部门信息的字符串表示形式
     *
     * @return 部门信息的字符串表示形式
     */
    public String toString() {
        return "Dept{deptno = " + deptno + ", dname = " + dname + ", loc = " + loc + "}";
    }
}
