package com.song.dao;

import com.song.entity.Employee;

public interface Employeeid {
    /**
     * 添加职员信息
     */
    public int addEmployee(Employee employee);

    /**
     * 删除职员信息
     */
    public int deleteEmployee(int id);
    /**
     * 修改职员信息
     */
    public int updateEmployee(Employee employee);
    /**
     * 多条件查询
     */
    public int CompoundQuery(Employee employee);
    /**
     * 查询所有
     */
    public int selectEmployee();

}