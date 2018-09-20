package com.ww.DyanmicCompile;

public class Emp {
    private String empNo;
    private String empName;

    public Emp(String empNo, String empName) {
        this.empNo = empNo;
        this.empName = empName;
    }

    public Emp(){

    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
