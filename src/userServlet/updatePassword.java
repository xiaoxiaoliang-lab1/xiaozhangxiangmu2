package userServlet;

import net.sf.json.JSONObject;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updatePassword.do")
public class updatePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String username = req.getParameter("username");
        // 设置字符编码，数据类型，获取json，输出对象
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        JSONObject json = new JSONObject();
        // 更新密码
        dao da=new dao();

        boolean b = da.update(username, oldPassword, newPassword);
        if (b) {
            json.put("success", true);
            json.put("msg", "success");
        } else {
            json.put("success", false);
            json.put("msg", "failed");
        }
        out.print(json.toString());
        out.flush();
        out.close();
    }
}
