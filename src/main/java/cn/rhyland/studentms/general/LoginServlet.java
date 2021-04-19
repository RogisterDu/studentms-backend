package cn.rhyland.studentms.general;

import cn.rhyland.studentms.dao.StudentDao;
import cn.rhyland.studentms.dao.TeacherDao;
import cn.rhyland.studentms.entity.Student;
import cn.rhyland.studentms.entity.Teacher;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/user/login")
public class LoginServlet extends HttpServlet {
    private static final StudentDao studentDao = new StudentDao();
    private static final TeacherDao teacherDao = new TeacherDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int number = Integer.parseInt(request.getParameter("number"));
        String password = request.getParameter("password");
        String identify = request.getParameter("identity");
        JSONObject jsonObject = new JSONObject();
        if (identify.equals("3")) {
            Student s1 = new Student();
            try {
                s1 = studentDao.find(number);
                if (s1.getStudent_ID() == 0) {
                    jsonObject.put("status", "201");
                    jsonObject.put("message", "用户名不存在");
                } else if (s1.getStudent_Password().equals(password)) {
                    JSONArray UserInfo = new JSONArray();
                    UserInfo.add(s1);                       //将bean实体类转为 json
                    jsonObject.put("code",200);
                    jsonObject.put("message","查询成功");
                    jsonObject.put("user-info",UserInfo);
                } else {
                    jsonObject.put("status", "202");
                    jsonObject.put("message", "密码错误");
                }
                response.getWriter().print(jsonObject.toJSONString());
                response.getWriter().flush();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        else if (identify.equals("9")){
            Teacher t1 = new Teacher();
            try {
                t1 = teacherDao.find(number);
                if (t1.getTeacher_ID() == 0) {
                    jsonObject.put("status", "200");
                    jsonObject.put("message", "用户名不存在");
                } else if (t1.getTeacher_Password().equals(password)) {
                    JSONArray UserInfo = new JSONArray();
                    UserInfo.add(t1);                       //将bean实体类转为 json
                    jsonObject.put("code",200);
                    jsonObject.put("message","查询成功");
                    jsonObject.put("user-info",UserInfo);
                } else {
                    jsonObject.put("status", "202");
                    jsonObject.put("message", "密码错误");
                }
                response.getWriter().print(jsonObject.toJSONString());
                response.getWriter().flush();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
