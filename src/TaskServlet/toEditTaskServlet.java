package TaskServlet;

import entity.*;
import untity.conntion;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toEditTaskServlet.do")
public class toEditTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        dao da=new dao();
        conntion coa=new conntion();

        TaxSource ts=da.selectSourceById(Integer.parseInt(id));

        Taxer Approver = da.selectTaxerById(ts.getApproverId());
        Taxer Execute = da.selectTaxerById(ts.getExecuteId());
        req.setAttribute("Approver",Approver);
        req.setAttribute("Execute",Execute);
        TaxPayer taxPayer = coa.selectTaxPayer(ts.getPayerId());
        User us= da.selectUserById(ts.getRecordUserId());
        req.setAttribute("user",us);
        req.setAttribute("payer",taxPayer);
        req.setAttribute("task",ts);

        List<TaxOrgan> li=da.selectAllshuiwuju();
        List<Industr> lis=da.selectAllhangye();
        List<Taxer> taxers = da.selectAllTaxer();
        req.setAttribute("taxers",taxers);
        req.setAttribute("organs" ,li);
        req.setAttribute("Allhangye",lis);
        req.getRequestDispatcher("editTask.jsp").forward(req, resp);

    }
}
