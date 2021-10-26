package serevlet;

import entity.Industr;
import entity.TaxOrgan;
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
import java.util.List;

@WebServlet("/toEditTaxPayerServlet.do")
public class toEditTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        conntion coa=new conntion();
        TaxPayer taxPayer = coa.selectTaxPayer(id);

        Integer userId = taxPayer.getUserId();

        dao da=new dao();
        Taxer taxer = da.selectTaxerById(userId);

        List<TaxOrgan> li=da.selectAllshuiwuju();
        List<Industr> lis=da.selectAllhangye();


        req.getSession().setAttribute("organs" ,li);
        req.getSession().setAttribute("Allhangye",lis);
        req.setAttribute("gaitaxerName",taxer.getTaxerName());
        req.setAttribute("gaitaxPayer",taxPayer);

        req.getRequestDispatcher("editTaxPayer.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        String bizAddress = req.getParameter("bizAddress");
        String legalMobile = req.getParameter("legalMobile");
        int taxOrganId = Integer.parseInt(req.getParameter("taxOrganId"));
        int industryId =Integer.parseInt(req.getParameter("taxIndustr"));
        String bizScope = req.getParameter("bizScope");
        String invoiceType = req.getParameter("piaozhong");
        String legalPerson = req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard");


        conntion coa =new conntion();
        int m=coa.updateTaxPayer(id,payerCode,payerName,bizAddress,legalMobile,taxOrganId,industryId,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard);
        if (m==1){
            resp.getWriter().write("Successfully modified");
        }else {
            resp.getWriter().write("Fail to edit");
        }




    }
}
