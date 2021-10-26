package TaskServlet;

import entity.*;
import net.sf.json.JSONObject;
import untity.conntion;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/toAddTaskServlet.do")
public class toAddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String payerCode = req.getParameter("payerCode");
        dao da=new dao();
        conntion coa=new conntion();
        TaxPayer taxPayer =null;
        if (id!=null){
             taxPayer=coa.selectTaxPayer(Integer.parseInt(id));
        }
        if (payerCode!=null){
            taxPayer=coa.selectTaxPayerBypayeCode(Integer.parseInt(payerCode));
        }
        if(taxPayer!=null){
            Taxer taxer = da.selectTaxerById(taxPayer.getUserId());
            req.setAttribute("payer",taxPayer);
            req.setAttribute("taxerName",taxer.getTaxerName());
        }



        List<TaxOrgan> taxOrgans = da.selectAllshuiwuju();
        List<Taxer> taxers = da.selectAllTaxer();

        req.setAttribute("organs",taxOrgans);
        req.setAttribute("taxers",taxers);
        req.getRequestDispatcher("addTask.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaxSource ts=new TaxSource();
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("payerId");
        dao da=new dao();

        String xiaozhang = String.valueOf(req.getSession().getAttribute("xiaozhang"));
        User m=da.selectUserByName(xiaozhang);
        ts.setRecordUserId(m.getId());

        TaxPayer tx=da.selectPayerById(Integer.parseInt(id));

        ts.setRecordTaskDate(tx.getRecordDate());

        ts.setPayerId(Integer.valueOf(id));
        String taskName = req.getParameter("taskName");
        ts.setTaskName(taskName);
        String subOrganId = req.getParameter("subOrganId");
        ts.setSubOrganId(Integer.valueOf(subOrganId));
        String approverId = req.getParameter("approverId");
        ts.setApproverId(Integer.valueOf(approverId));
        String executeId = req.getParameter("executeId");
        ts.setExecuteId(Integer.valueOf(executeId));
        String executeTime = req.getParameter("executeTime");
        ts.setExecuteTime(executeTime);
        String taskState = req.getParameter("taskState");
        ts.setTaskState(taskState);

        conntion coa=new conntion();
        int i=coa.addTask(ts);
        if (i != 0) {
            json.put("success", true);
            json.put("id", id);
            json.put("msg", "success");
        } else {
            json.put("success", false);
            json.put("msg", "failed");
        }
        out.print(json);
        out.flush();
        out.close();



    }
}
