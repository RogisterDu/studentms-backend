package cn.rhyland.studentms.student;

import cn.rhyland.studentms.dao.StudentDao;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetMyGradesServlet", value = "/student/grade")
public class GetMyGradesServlet extends HttpServlet {
    private static final StudentDao studentDao = new StudentDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            List<Object[]> ls= studentDao.findmygrade(2);
            String str = JSON.toJSONString(studentDao.findmygrade(2));
            response.getWriter().print(str);
            response.getWriter().flush();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
