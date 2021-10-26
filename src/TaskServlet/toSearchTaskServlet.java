package TaskServlet;

import entity.Industr;
import entity.TaxOrgan;
import entity.Taxer;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toSearchTaskServlet.do")
public class toSearchTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao da=new dao();
        List<TaxOrgan> taxOrgans = da.selectAllshuiwuju();
        List<Industr> industrs = da.selectAllhangye();

        req.setAttribute("organs",taxOrgans);
        req.setAttribute("industrys",industrs);
        req.getRequestDispatcher("searchTask.jsp").forward(req,resp);
    }
}
