package com.song.dao.impl;

import com.song.dao.EmployeeDao;
import com.song.entity.Employee;
import com.song.entity.Sales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoimpl extends BaseDao implements EmployeeDao {


    /**
     * 添加职员信息
     *
     * @param employee
     * @return
     */
    @Override
    public int addEmployee(Employee employee) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "insert into Employee(EmpName,EmpPwd,Sex,Age,HireLong,Salary) values(?,?,?,?,?,?)";
            Object[] params = {employee.getEmpName(), employee.getEmpPwd(), employee.getSex(), employee.getAge(), employee.getHireLong(), employee.getSalary()};
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
     * @param id
     * @return
     */
    @Override
    public int deleteEmployee(int id) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "delete from Employss where EmployeeId = ?";
            Object[] params = {id};
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
     * @param employee
     * @return
     */
    @Override
    public int updateEmployee(Employee employee) {
        int count = 0;
        try {
            super.getConnection();
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
            //去掉最后一个逗号
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
     * 多条件查询职员信息
     *
     * @param
     * @return
     */
    @Override
    public List<Employee> CompoundQuery(String name, String Sex, int age, int age1, String HireLong, String HireLong1, int Salary, int Salary1) {
        List<Employee> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Employee where 1=1 ";
            if (name != null) {
                //模糊查询
                sql += "and EmpName like '%" + name + "%'";
            }
            if (Sex != null) {
                sql += "and Sex='" + Sex + "'";
            }
            if (age != 0) {
                sql += "and Age>'" + age + "'";
            }
            if (age1 != 0) {
                sql += "and Age<'" + age1 + "'";
            }
            if (HireLong != null) {
                sql += "and HireLong>'" + HireLong + "'";
            }
            if (HireLong1 != null) {
                sql += "and HireLong<'" + HireLong1 + "'";
            }
            if (Salary != 0) {
                sql += "and Salary>'" + Salary + "'";
            }
            if (Salary1 != 0) {
                sql += "and Salary<'" + Salary1 + "'";
            }
            System.out.println(sql);
            ResultSet rs = super.executeQuery(sql);
            next(list, rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }

        return list;
    }

    /**
     * 封装结果集
     *
     * @param list
     * @param rs
     * @throws SQLException
     */

    private static void next(List<Employee> list, ResultSet rs) throws SQLException {
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
     * @return
     */
    @Override
    public List<Employee> selectEmployee() {
        List<Employee> list = new ArrayList<>();
        try {
            super.getConnection();
            String sql = "select * from Employee";
            ResultSet rs = super.executeQuery(sql);
            next(list, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }

        return list;
    }

    /**
     * 判断职员是否存在
     *
     * @param id
     * @return
     */
    @Override
    public boolean isExist(int id) {
        boolean flag = false;
        try {
            super.getConnection();
            String sql = "select * from Employee where EmployeeId = ?";
            Object[] params = {id};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            super.connClose();
        }
        return flag;
    }

    /**
     *  根据id查询职员信息
     * @param id
     * @return
     */
    @Override
    public Employee selectEmployeeById(int id) {
        Employee employee = new Employee();
        try {
            super.getConnection();
            String sql = "select * from Employee where EmployeeId = ?";
            Object[] params = {id};
            ResultSet resultSet = super.executeQuery(sql, params);
            if (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt("EmployeeId"));
                employee.setEmpName(resultSet.getString("EmpName"));
                employee.setSex(resultSet.getString("Sex"));
                employee.setAge(resultSet.getInt("Age"));
                employee.setHireLong(resultSet.getString("HireLong"));
                employee.setSalary(resultSet.getDouble("Salary"));

            }finally {
                super.connClose();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
