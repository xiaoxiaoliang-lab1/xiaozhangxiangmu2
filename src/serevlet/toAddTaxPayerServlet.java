package serevlet;

import entity.Industr;
import entity.TaxOrgan;
import entity.TaxPayer;
import entity.Taxer;
import net.sf.json.JSONObject;
import untity.conntion;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/toAddTaxPayerServlet.do")
public class toAddTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao da=new dao();
        List<TaxOrgan> li=da.selectAllshuiwuju();
        List<Industr> lis=da.selectAllhangye();
        List<Taxer> lit =da.selectAllTaxer();

        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String format = sdf.format(date);

        req.setAttribute("curDate",format);
        req.setAttribute("organs" ,li);
        req.setAttribute("industrys",lis);
        req.setAttribute("taxer",lit);
        req.getRequestDispatcher("addTaxPayer.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        JSONObject json = new JSONObject();
        HttpSession session = req.getSession();
        // 建立对象，获取和设置参数，对于和外键相连的字段判断是否有选择
        TaxPayer payer = new TaxPayer();
        String payerCode = req.getParameter("payerCode");
        payer.setPayerCode(payerCode);
        payer.setOrganName(null);
        payer.setIndustryName(null);
        String payerName = req.getParameter("payerName");
        payer.setPayerName(payerName);
        String bizAddress = req.getParameter("bizAddress");
        payer.setBizAddress(bizAddress);

        String taxOrganId = req.getParameter("taxOrganId");
        if ("-1".equals(taxOrganId)) {
            payer.setTaxOrganId(null);
        } else {
            payer.setTaxOrganId(Integer.parseInt(taxOrganId));
        }

        String industryId = req.getParameter("industryId");
        if ("-1".equals(industryId)) {
            payer.setIndustryId(null);
        } else {
            payer.setIndustryId(Integer.parseInt(industryId));
        }
        String bizScope = req.getParameter("bizScope");
        payer.setBizScope(bizScope);

        String invoiceType = req.getParameter("invoiceType");
        if ("-1".equals(invoiceType)){
            payer.setInvoiceType(null);
        }else {
            payer.setInvoiceType(invoiceType);
        }


        String legalPerson = req.getParameter("legalPerson");
        payer.setLegalPerson(legalPerson);
        String legalIdCard = req.getParameter("legalIdCard");
        payer.setLegalIdCard(legalIdCard);
        String legalIdCardImageURL = req.getParameter("legalIdCardImageURL");
        payer.setLegalIdCardImageURL(null);
        String finaceName = req.getParameter("finaceName");
        payer.setFinaceName(finaceName);
        String finaceIdCard = req.getParameter("finaceIdCard");
        payer.setFinaceIdCard(finaceIdCard);
        String finaceIdCardImageURL = req.getParameter("finaceIdCardImageURL");
        payer.setFinaceIdCardImageURL(null);
        String taxerName = req.getParameter("taxerName");
        payer.setTaxerName(taxerName);
        String bizAddressPhone = req.getParameter("bizAddressPhone");
        payer.setBizAddressPhone(bizAddressPhone);

        String userId = req.getParameter("luru");
        if ("-1".equals(userId)) {
            payer.setUserId(null);
        } else {
            payer.setUserId(Integer.valueOf(userId));
        }
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String format = sdf.format(date);
        payer.setRecordDate(format);

        conntion coa=new conntion();
        boolean b=coa.addtaxpayer(payer);

//        boolean b =da.addPayer(payer);
        if (b) {
            json.put("success", true);
            json.put("msg", "sucess");
        } else {
            json.put("success", false);
            json.put("msg", "fail");
        }
        out.print(json);
        out.flush();
        out.close();

    }





}
