package cn.rhyland.studentms.dao;

import cn.rhyland.studentms.entity.Student;
import cn.rhyland.studentms.entity.Teacher;
import cn.rhyland.studentms.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class TeacherDao {
    public List findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from Teacher_Info";
        return (List) runner.query(sql, new BeanHandler<>(Student.class));
    }

    public Teacher find(int teacher_number) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from Teacher_Info where Teacher_Number = ?";
        return (Teacher) runner.query(sql, new BeanHandler<>(Teacher.class), teacher_number);
    }

    public Boolean insert(Teacher teacher) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "Insert into Teacher_Info (Teacher_Name,Teacher_Number,Teacher_Password) values(?, ?, ?)";
        Object[] params = {teacher.getTeacher_ID(), teacher.getTeacher_Number(), teacher.getTeacher_Password()};
        int r = runner.update(sql, params);
        return r > 0;
    }

    public Boolean delete(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from Teacher_Info where Student_ID = ?";
        //4.执行
        int r = queryRunner.update(sql, id);
        return r > 0;
    }
}
