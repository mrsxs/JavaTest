package com.EmployeeManager.dao;

import com.EmployeeManager.entity.Dept;

import java.util.List;

public interface DeptDao {
    /**
     * 添加部门
     * @param dept 部门对象
     * @return 返回添加的部门数量
     */
    public int addDept(Dept dept);

    /**
     * 删除部门
     * @param id 部门编号
     * @return 返回删除的部门数量
     */
    public int deleteDept(int id);

    /**
     * 修改部门
     * @param dept 部门对象
     * @return 返回修改的部门数量
     */
    public int updateDept(Dept dept);

    /**
     * 获取所有部门
     * @return 返回所有部门的列表
     */
    public List<Dept> getAlldepts();


    /**
     * 根据部门编号获取部门
     * @param id 部门编号
     * @return 返回部门列表
     */
    public List<Dept> getById(int id);

    /**
     * 判断部门名称是否存在
     * @param deptno 部门编号
     * @return 如果存在返回true，否则返回false
     */
    public boolean isExistdeptno(int deptno);

    /**
     * 判断部门下是否有职员信息
     * @param deptno 部门编号
     * @return 如果存在职员信息返回true，否则返回false
     */
    public boolean isExisdept(int deptno);
}
