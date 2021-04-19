package cn.rhyland.studentms.dao;

import cn.rhyland.studentms.entity.Student;
import cn.rhyland.studentms.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    //  查询所有，返回List集合
    public List findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from Student_Info";
        return (List) runner.query(sql, new BeanHandler<>(Student.class));
    }

    public Student find(int student_number) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from Student_Info where Student_Number = ?";
        return (Student) runner.query(sql, new BeanHandler<>(Student.class), student_number);
    }

    public Boolean insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "Insert into Student_Info (Student_Name,Student_Number,Student_Password) values(?, ?, ?)";
        Object[] params = {student.getStudent_Name(), student.getStudent_Number(), student.getStudent_Password()};
        int r = runner.update(sql, params);
        return r > 0;
    }

    public Boolean delete(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from Student_Info where Student_ID = ?";
        //4.执行
        int r = queryRunner.update(sql, id);
        return r > 0;
    }

    public Boolean setpassword(int id, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update Student_Info set Student_Password = ? where Student_ID = ?";
        Object[] params = {password, id};
        int r = queryRunner.update(sql, params);
        return r > 0;
    }

    public List<Object[]> findmygrade(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select Grades_ID,Course_Name,Teacher_Name,Grades,Grades_Level from Course_Grades,Course_Info,Teacher_Info";
        sql+=" WHERE Course_Grades.Course_ID =Course_Info.Course_ID and Course_Info.Teacher_ID =Teacher_Info.Teacher_ID and Course_Grades.Student_ID =?";
        Object[] params = {id};
        return queryRunner.query(sql,new ArrayListHandler(),params);
    }
}
