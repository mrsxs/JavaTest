package com.song.dao.impl;

import com.song.dao.EmployeeDao;
import com.song.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 职员的数据库操作类
 * 
 * @author song
 */

public class EmployeeDaoimpl extends BaseDao implements EmployeeDao {

    /**
     * 添加职员信息
     *
     * @param employee 职员对象
     * @return
     */
    @Override
    public int addEmployee(Employee employee) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 添加职员信息
            String sql = "insert into Employee(EmpName,EmpPwd,Sex,Age,HireLong,Salary) values(?,?,?,?,?,?)";

            // 参数
            Object[] params = { employee.getEmpName(), employee.getEmpPwd(), employee.getSex(), employee.getAge(),
                    employee.getHireLong(), employee.getSalary() };
            // 执行sql语句
            count = super.executeUpdate(sql, params);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return count;
    }

    /**
     * 删除职员信息
     *
     * @param id 职员id
     * @return
     */
    @Override
    public int deleteEmployee(int id) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 删除职员信息
            String sql = "delete from Employss where EmployeeId = ?";
            Object[] params = { id };
            count = super.executeUpdate(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return count;
    }

    /**
     * 修改职员信息
     *
     * @param employee 职员对象
     * @return
     */
    @Override
    public int updateEmployee(Employee employee) {
        int count = 0;
        try {
            super.getConnection();
            // sql语句 修改职员信息
            String sql = "update Employee set ";
            if (employee.getEmpName() != null) {
                sql += "EmpName = '" + employee.getEmpName() + "',";
            }
            if (employee.getEmpPwd() != null) {
                sql += "EmpPwd = '" + employee.getEmpPwd() + "',";
            }
            if (employee.getSex() != null) {
                sql += "Sex = '" + employee.getSex() + "',";
            }
            if (employee.getAge() != 0) {
                sql += "Age = '" + employee.getAge() + "',";
            }
            if (employee.getSalary() != 0) {
                sql += "Salary = '" + employee.getSalary() + "',";
            }
            // 去掉最后一个逗号
            sql = sql.substring(0, sql.length() - 1);
            sql += " where EmployeeId = '" + employee.getEmployeeId() + "'";
            System.out.println(sql);
            count = super.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return count;
    }

    /**
     * 多条件查询
     * 
     * @param name 名字
     *             sex 性别
     *             age 开始年龄
     *             age1 结束年龄
     *             hireLong 开始入职时间
     *             hireLong1 结束入职时间
     *             salary 开始工资
     *             salary1 结束工资
     * @return 职员集合
     * 
     */
    @Override
    public List<Employee> compoundQuery(String name, String sex, int age, int age1, String hireLong, String hireLong1,
            int salary, int salary1) {
        List<Employee> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 多条件查询
            String sql = "select * from Employee where 1=1 ";
            if (name != null) {
                // 模糊查询
                sql += "and EmpName like '%" + name + "%'";
            }
            if (sex != null) {
                sql += "and Sex='" + sex + "'";
            }
            if (age != 0) {
                sql += "and Age>'" + age + "'";
            }
            if (age1 != 0) {
                sql += "and Age<'" + age1 + "'";
            }
            if (hireLong != null) {
                sql += "and HireLong>'" + hireLong + "'";
            }
            if (hireLong1 != null) {
                sql += "and HireLong<'" + hireLong1 + "'";
            }
            if (salary != 0) {
                sql += "and Salary>'" + salary + "'";
            }
            if (salary1 != 0) {
                sql += "and Salary<'" + salary1 + "'";
            }
            System.out.println(sql);
            ResultSet rs = super.executeQuery(sql);
            next(list, rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }

        return list;
    }

    /**
     * 封装结果集
     *
     * @param list 结果集
     * @param rs   查询结果
     * @throws SQLException
     */

    private static void next(List<Employee> list, ResultSet rs) throws SQLException {
        // 遍历结果集
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("EmployeeId"));
            employee.setEmpName(rs.getString("EmpName"));
            employee.setSex(rs.getString("Sex"));
            employee.setAge(rs.getInt("Age"));
            employee.setHireLong(rs.getString("HireLong"));
            employee.setSalary(rs.getDouble("Salary"));
            list.add(employee);
        }
    }

    /**
     * 查询所有职员信息
     *
     * @return 职员集合
     */
    @Override
    public List<Employee> selectEmployee() {
        List<Employee> list = new ArrayList<>();
        try {
            super.getConnection();
            // sql语句 查询所有职员信息
            String sql = "select * from Employee";
            ResultSet rs = super.executeQuery(sql);
            next(list, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }

        return list;
    }

    /**
     * 判断职员是否存在
     *
     * @param id 职员id
     * @return 存在返回true，不存在返回false
     */
    @Override
    public boolean isExist(int id) {
        boolean flag = false;
        try {
            super.getConnection();
            // sql语句 判断职员是否存在
            String sql = "select * from Employee where EmployeeId = ?";
            Object[] params = { id };
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.connClose();
        }
        return flag;
    }

    /**
     * 根据id查询职员信息
     * 
     * @param id  职员id
     * @return 职员对象
     */
    @Override
    public Employee selectEmployeeById(int id) {
        Employee employee = new Employee();
        try {
            super.getConnection();
            // sql语句 根据id查询职员信息
            String sql = "select * from Employee where EmployeeId = ?";
            Object[] params = { id };
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt("EmployeeId"));
                employee.setEmpName(resultSet.getString("EmpName"));
                employee.setSex(resultSet.getString("Sex"));
                employee.setAge(resultSet.getInt("Age"));
                employee.setHireLong(resultSet.getString("HireLong"));
                employee.setSalary(resultSet.getDouble("Salary"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    /**
     * 判断账户密码是否正确
     *
     * @param name    账户
     * @param password 密码
     * @return 正确返回true，错误返回false
     */
    @Override
    public boolean isExist(String name, String password) {
        boolean flag = false;
        try {
            super.getConnection();
            String sql = "select * from Employee where EmpName = ? and EmpPwd = ?";
            Object[] params = { name, password };
            ResultSet resultSet = super.executeQuery(sql, params);
            while (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
