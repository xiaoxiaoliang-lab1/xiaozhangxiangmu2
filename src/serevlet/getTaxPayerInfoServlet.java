package serevlet;

import entity.TaxPayer;
import entity.Taxer;
import untity.conntion;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getTaxPayerInfoServlet.do")
public class getTaxPayerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));


        conntion coa=new conntion();
        TaxPayer taxPayer = coa.selectTaxPayer(id);

        Integer userId = taxPayer.getUserId();

        dao da=new dao();
        Taxer taxer = da.selectTaxerById(userId);


        req.setAttribute("taxerName",taxer.getTaxerName());
        req.setAttribute("taxPayer",taxPayer);
        req.getRequestDispatcher("payerInfo.jsp").forward(req,resp);

    }
}
