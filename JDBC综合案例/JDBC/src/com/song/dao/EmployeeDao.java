package com.song.dao;

import com.song.entity.Employee;

import java.util.List;
/**
 * 职员的数据库操作类
 *
 * @Author song
 */

public interface EmployeeDao {
    /**
     * 添加职员信息
     * @param employee 职员对象
     * @return 返回受影响的行数
     */
    public int addEmployee(Employee employee);

    /**
     * 删除职员信息
     * @param id 职员id
     * @return 返回受影响的行数
     */
    public int deleteEmployee(int id);

    /**
     * 修改职员信息
     * @param employee 职员对象
     * @return 返回受影响的行数
     */
    public int updateEmployee(Employee employee);

    /**
     * 多条件查询
     * @param name 员工姓名
     *  sex 员工性别
     * age 开始员工年龄
     * age1 结束员工年龄
     * hireLong 开始入职时间
     * hireLong1 结束入职时间
     * salary 员工工资
     * salary1 员工工资
     * @return 返回职员集合
     * @return 返回职员集合
     * 
     */
    /**
     * 多条件查询
     * @param name 员工姓名
     * @param sex 员工性别
     * @param age 开始员工年龄
     * @param age1 结束员工年龄
     * @param hireLong 开始入职时间
     * @param hireLong1 结束入职时间
     * @param salary 员工工资
     * @param salary1 员工工资
     * @return 返回职员集合
     */
    public List<Employee> compoundQuery(String name, String sex, int age, int age1, String hireLong, String hireLong1, int salary, int salary1);

    /**
     * 查询所有
     * @return 返回职员集合
     */
    public List<Employee> selectEmployee();

    /**
     * 判断id是否存在
     * @param id 职员id
     * @return 返回布尔值
     */
    public boolean isExist(int id);

    /**
     * 根据id查询
     * @param id 职员id
     * @return 返回职员对象
     */
    public Employee selectEmployeeById(int id);

    /**
     * 判断账户密码是否正确
     * @param name 账户
     * @param password 密码
     * @return 返回布尔值
     */
    public boolean isExist(String name,String password);

}