package com.EmployeeManager.dao;

import com.EmployeeManager.entity.Emp;

import java.util.List;

public interface EmpDao {
    /**
     * 对员工姓名进行唯一判断
     * @param name 员工姓名
     * @return 如果存在返回true，否则返回false
     */
    public boolean isExistName(String name);

    /**
     * 对员工工号进行唯一判断
     * @param id 员工工号
     * @return 如果存在返回true，否则返回false
     */
    public boolean isExistId(int id);

    /**
     * 添加数据方法
     * @param emp 员工对象
     * @return 返回添加的员工数量
     */
    public int addEmp(Emp emp);

    /**
     * 修改方法
     * @param emp 员工对象
     * @return 返回修改的员工数量
     */
    public int updateEmp(Emp emp);

    /**
     * 删除方法
     * @param id 员工工号
     * @return 返回删除的员工数量
     */
    public int deleteEmp(int id);

    /**
     * 查询所有员工信息
     * @return 返回所有员工信息的列表
     */
    public List<Emp> getAllEmps();


    /**
     * 根据id查询职业信息
     * @param id 员工工号
     * @return 返回符合条件的员工信息列表
     */
    public List<Emp> getById(int id);

}
