package com.song.entity;

/**
 * 员工实体类
 * 
 * @Author song
 */

public class Employee {
    /**
     * 员工id
     */
    private int employeeId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 员工密码
     */
    private String empPwd;
    /**
     * 员工性别
     */
    private String sex;
    /**
     * 员工年龄
     */
    private int age;
    /**
     * 入职时间
     */
    private String hireLong;
    /**
     * 员工工资
     */
    private double salary;

    /**
     * 无参构造方法
     */
    public Employee() {
    }

    /**
     * 有参构造方法
     * 
     * @param employeeId 员工id
     * @param empName    员工姓名
     * @param empPwd     员工密码
     * @param sex        员工性别
     * @param age        员工年龄
     * @param hireLong   入职时间
     * @param salary     员工工资
     */
    public Employee(int employeeId, String empName, String empPwd, String sex, int age, String hireLong,
            double salary) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.empPwd = empPwd;
        this.sex = sex;
        this.age = age;
        this.hireLong = hireLong;
        this.salary = salary;
    }
    public Employee(int employeeId, String empName, String empPwd, String sex, int age,  double salary) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.empPwd = empPwd;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String empName, String empPwd, String sex, int age, String hireLong, double salary) {
        this.empName = empName;
        this.empPwd = empPwd;
        this.sex = sex;
        this.age = age;
        this.hireLong = hireLong;
        this.salary = salary;
    }



    /**
     * 获取
     * 
     * @return employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置
     * 
     * @param employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取
     * 
     * @return empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置
     * 
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取
     * 
     * @return empPwd
     */
    public String getEmpPwd() {
        return empPwd;
    }

    /**
     * 设置
     * 
     * @param empPwd
     */
    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    /**
     * 获取
     * 
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * 
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * 
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * 
     * @return hireLong
     */
    public String getHireLong() {
        return hireLong;
    }

    /**
     * 设置
     * 
     * @param hireLong
     */
    public void setHireLong(String hireLong) {
        this.hireLong = hireLong;
    }

    /**
     * 获取
     * 
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 设置
     * 
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Employee{employeeId = " + employeeId + ", empName = " + empName + ", empPwd = " + empPwd + ", sex = "
                + sex + ", age = " + age + ", hireLong = " + hireLong + ", salary = " + salary + "}";
    }
}
