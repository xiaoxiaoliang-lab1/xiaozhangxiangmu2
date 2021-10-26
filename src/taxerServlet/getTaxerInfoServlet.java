package taxerServlet;

import entity.TaxOrgan;
import entity.Taxer;
import net.sf.json.JSONObject;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getTaxerInfoServlet.do")
public class getTaxerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        JSONObject json = new JSONObject();
        String id = req.getParameter("id");
        dao da=new dao();
        Taxer taxer = da.selectTaxerById(Integer.valueOf(id));
         TaxOrgan tx= da.selectOrganById(taxer.getOrganId());


        req.setAttribute("taxer", taxer);
        req.setAttribute("organ",tx);

        req.getRequestDispatcher("taxerInfo.jsp").forward(req, resp);



    }
}
