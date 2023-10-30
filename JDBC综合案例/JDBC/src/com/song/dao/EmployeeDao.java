package com.song.dao;

import com.song.entity.Employee;
import com.song.entity.Sales;

import java.util.List;

public interface EmployeeDao {
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
    public List<Employee> CompoundQuery(String name, String Sex, int age, int age1, String HireLong, String HireLong1, int Salary, int Salary1);

    /**
     * 查询所有
     */
    public List<Employee> selectEmployee();

    /**
     * 判断id是否存在
     */
    public boolean isExist(int id);

    /**
     * 根据id查询
     */
    public Employee selectEmployeeById(int id);

}