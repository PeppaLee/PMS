package com.pms.dao.impl;

import com.pms.dao.idao.IEmpDao;
import com.pms.dao.pojo.Emp;
import com.pms.dao.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("empDao")
public class EmpDaoImpl implements IEmpDao {
    @Override
    public List<Emp> findByName(String name) throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select eno,ename,esex,ebirthday,eid,eedu,dno,jno,hireday,jobstartday,estate,etype,efrom from t_emp where ename like ?";
        List<Emp> empList = qr.query(sql, new BeanListHandler<Emp>(Emp.class), "%" + name + "%");
        return empList;
    }

    @Override
    public List<Emp> findAll() throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select eno,ename,esex,ebirthday,eid,eedu,dno,jno,hireday,jobstartday,estate,etype,efrom from t_emp";
        List<Emp> empList = qr.query(sql, new BeanListHandler<Emp>(Emp.class));
        return empList;
    }

    @Override
    public Emp findById(Integer id) throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select eno,ename,esex,ebirthday,eid,eedu,dno,jno,hireday,jobstartday,estate,etype,efrom from t_emp where eno=?";
        Emp emp = qr.query(sql, new BeanHandler<Emp>(Emp.class), id);
        return emp;
    }

    @Override
    public List<Emp> findByPage(int page, int size) throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select eno,ename,esex,ebirthday,eid,eedu,dno,jno,hireday,jobstartday,estate,etype,efrom from t_emp limit ?,?";
        List<Emp> empList = qr.query(sql, new BeanListHandler<Emp>(Emp.class), (page - 1) * size, size);
        return empList;
    }

    @Override
    public void save(Emp t) throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "insert into t_emp(ename,esex,ebirthday,eid,eedu,dno,jno,hireday,jobstartday,estate,etype,efrom) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, t.getEname(), t.getEsex(), t.getEbirthday(), t.getEid(), t.getEedu(), t.getDno(), t.getJno(),
                t.getHireday(), t.getJobstartday(), t.getEstate(), t.getEtype(), t.getEfrom());

    }

    @Override
    public void update(Emp t) throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "update t_emp set ename=?,esex=?,ebirthday=?,eid=?,eedu=?,dno=?,jno=?,hireday=?,jobstartday=?,estate=?,etype=?,efrom=? where eno=?";
        qr.update(sql, t.getEname(), t.getEsex(), t.getEbirthday(), t.getEid(), t.getEedu(), t.getDno(), t.getJno(),
                t.getHireday(), t.getJobstartday(), t.getEstate(), t.getEtype(), t.getEfrom(), t.getEno());
    }

    @Override
    public void delete(Emp t) throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "delete from t_emp where eno=?";
        qr.update(sql, t.getEno());

    }
}
