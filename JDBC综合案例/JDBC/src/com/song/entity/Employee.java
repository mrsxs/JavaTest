package com.song.entity;

public class Employee {
    private int EmployeeId;
    private String EmpName;
    private String EmpPwd;
    private String Sex;
    private int Age;
    private String HireLong;
    private double Salary;

    public Employee() {
    }

    public Employee(int EmployeeId, String EmpName, String EmpPwd, String Sex, int Age, String HireLong, double Salary) {
        this.EmployeeId = EmployeeId;
        this.EmpName = EmpName;
        this.EmpPwd = EmpPwd;
        this.Sex = Sex;
        this.Age = Age;
        this.HireLong = HireLong;
        this.Salary = Salary;
    }

    public Employee(String EmpName, String EmpPwd, String Sex, int Age, String HireLong, double Salary) {
        this.EmpName = EmpName;
        this.EmpPwd = EmpPwd;
        this.Sex = Sex;
        this.Age = Age;
        this.HireLong = HireLong;
        this.Salary = Salary;
    }

    public Employee(int employeeId, String EmpName, String EmpPwd, String Sex, int Age, double Salary) {
        this.EmployeeId = employeeId;
        this.EmpName = EmpName;
        this.EmpPwd = EmpPwd;
        this.Sex = Sex;
        this.Age = Age;
        this.Salary = Salary;
    }

    /**
     * 获取
     *
     * @return EmployeeId
     */
    public int getEmployeeId() {
        return EmployeeId;
    }

    /**
     * 设置
     *
     * @param EmployeeId
     */
    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    /**
     * 获取
     *
     * @return EmpName
     */
    public String getEmpName() {
        return EmpName;
    }

    /**
     * 设置
     *
     * @param EmpName
     */
    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    /**
     * 获取
     *
     * @return EmpPwd
     */
    public String getEmpPwd() {
        return EmpPwd;
    }

    /**
     * 设置
     *
     * @param EmpPwd
     */
    public void setEmpPwd(String EmpPwd) {
        this.EmpPwd = EmpPwd;
    }

    /**
     * 获取
     *
     * @return Sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * 设置
     *
     * @param Sex
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    /**
     * 获取
     *
     * @return Age
     */
    public int getAge() {
        return Age;
    }

    /**
     * 设置
     *
     * @param Age
     */
    public void setAge(int Age) {
        this.Age = Age;
    }

    /**
     * 获取
     *
     * @return HireLong
     */
    public String getHireLong() {
        return HireLong;
    }

    /**
     * 设置
     *
     * @param HireLong
     */
    public void setHireLong(String HireLong) {
        this.HireLong = HireLong;
    }

    /**
     * 获取
     *
     * @return Salary
     */
    public double getSalary() {
        return Salary;
    }

    /**
     * 设置
     *
     * @param Salary
     */
    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String toString() {
        return "Employee{EmployeeId = " + EmployeeId + ", EmpName = " + EmpName + ", EmpPwd = " + EmpPwd + ", Sex = " + Sex + ", Age = " + Age + ", HireLong = " + HireLong + ", Salary = " + Salary + "}";
    }
}
