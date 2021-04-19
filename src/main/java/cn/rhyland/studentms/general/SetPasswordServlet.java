package cn.rhyland.studentms.general;

import cn.rhyland.studentms.dao.StudentDao;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SetPasswordServlet", value = "/user/setpassword")
public class SetPasswordServlet extends HttpServlet {
    private static final StudentDao studentdao = new StudentDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String NewPassword = request.getParameter("newpassword");
        String Identity = request.getParameter("identity");
        JSONObject jsonObject = new JSONObject();
        if (Identity.equals("3")){
            try {
                Boolean r = studentdao.setpassword(id, NewPassword);
                if (r){
                    jsonObject.put("status","200");
                    jsonObject.put("message","修改密码成功");
                }
                else {
                    jsonObject.put("status","201");
                    jsonObject.put("message","修改密码失败");
                }
                response.getWriter().print(jsonObject.toJSONString());
                response.getWriter().flush();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
