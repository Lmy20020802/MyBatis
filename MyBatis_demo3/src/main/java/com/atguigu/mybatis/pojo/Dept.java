package com.atguigu.mybatis.pojo;

import java.util.List;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author lmy
 * @Date 2022/4/11 18:43
 **/
public class Dept {

    private Integer did;

    private String deptName;

    private List<Emp> emps;

    public Dept() {

    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
