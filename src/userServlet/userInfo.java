package userServlet;

import entity.Taxer;
import entity.User;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userInfo.do")
public class userInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xiaozhang = String.valueOf(req.getSession().getAttribute("xiaozhang"));
        dao da=new dao();
        User user = da.selectUserByName(xiaozhang);
        req.getSession().setAttribute("user",user);
        Taxer taxer = da.selectTaxerById(user.getTaxerId());
        req.getSession().setAttribute("taxer",taxer);
        req.getRequestDispatcher("userInfo.jsp").forward(req,resp);
    }
}
