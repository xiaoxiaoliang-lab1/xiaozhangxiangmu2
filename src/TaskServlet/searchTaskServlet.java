package TaskServlet;

import entity.TaxSource;
import entity.Taxer;
import net.sf.json.JSONObject;
import untity.BeanUtil;
import untity.DBUtil;
import untity.conntion;
import untity.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/searchTaskServlet.do")
public class searchTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        String industryName = req.getParameter("industryName");
        String organName = req.getParameter("subOrganId");
        String bizScope = req.getParameter("bizScope");
        String executeTime = req.getParameter("startDate");
        String recordTaskDate = req.getParameter("endDate");
        String page = req.getParameter("page");//第几页
        String rows = req.getParameter("rows");//一页多少条
        
        if(payerCode!=null||payerName!=null||industryName!=null||bizScope!=null||executeTime!=null||recordTaskDate!=null){
            List<TaxSource> select = searchTaskServlet.select(Integer.parseInt(page), Integer.parseInt(rows),payerCode, payerName,  organName, industryName, executeTime, recordTaskDate);
            Map<String, Object> map = new HashMap<>();
            map.put("rows", select);

            int a= searchTaskServlet.count( payerCode, payerName, industryName, bizScope, executeTime, recordTaskDate);
            map.put("total", a);
            PrintWriter out = resp.getWriter();
            out.write(JSONObject.fromObject(map).toString());
            out.flush();
            out.close();

        }else {
          
            conntion coa=new conntion();
            dao da=new dao();
            List<TaxSource> ll= da.selectSourceBypage(Integer.parseInt(page), Integer.parseInt(rows));
            Map<String, Object> map = new HashMap<>();
            map.put("rows", ll);

            map.put("total", coa.countTask());
            PrintWriter out = resp.getWriter();
            out.write(JSONObject.fromObject(map).toString());
            out.flush();
            out.close();
        }
    }

    public static int count(
            String payerCode,
            String payerName,
            String organName,
            String industryName,
            String executeTime,
            String recordTaskDate){
        boolean pc = payerCode != null && payerCode.length() > 0;
        boolean pn = payerName != null && payerName.length() > 0;
        boolean in = industryName != null && industryName.length() > 0;
        boolean bi = organName != null && organName.length() > 0;
        boolean ex = executeTime != null && executeTime.length() > 0;
        boolean re = recordTaskDate != null && recordTaskDate.length() > 0;

        String sql = "select count(s.id)  from tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_industry i on s.payerId=p.id and s.subOrganId=o.id and p.industryId=i.id WHERE  p.removeState=0 ";
        if(pc){
            sql = sql+" and payerCode = " + payerCode;
            System.out.println(sql);
        }
        if(pn){
            sql = sql+" and payerName like '%" + payerName +"%'";
        }
        if(in){
            sql = sql+" and i.industryName = '" + industryName + "'";
        }
        if(bi){
            sql = sql+" and o.organName = '" + organName + "'";
        }
        if(ex){
            sql = sql+" and s.executeTime = '" + executeTime + "'";
        }
        if(re){
            sql = sql+" and s.recordTaskDate = '" + recordTaskDate + "'";
        }
        System.out.println(sql);
        List<Map<String, String>> query = DBUtil.query(sql);
        int s = Integer.parseInt(query.iterator().next().get("count(s.id)"));
        System.out.println(s);
        return s;
    }
    public static List<TaxSource> select(int page, int size,  String payerCode,String payerName, String organName, String industryName, String executeTime, String recordTaskDate){
        boolean pc = payerCode != null && payerCode.length() > 0;
        boolean pn = payerName != null && payerName.length() > 0;
        boolean in = industryName != null && industryName.length() > 0;
        boolean bi = organName != null && organName.length() > 0;
        boolean ex = executeTime != null && executeTime.length() > 0;
        boolean re = recordTaskDate != null && recordTaskDate.length() > 0;

        String sql = "select * ,timestampdiff(day,executeTime,recordTaskDate) as timeOutfrom from tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_industry i on s.payerId=p.id and s.subOrganId=o.id and p.industryId=i.id WHERE  p.removeState=0 ";
        if(pc){
            sql = sql+" and payerCode = " + payerCode;

        }
        if(pn){
            sql = sql+" and payerName like '%" + payerName +"%'";
        }
        if(in){
            sql = sql+" and i.industryName = '" + industryName + "'";
        }
        if(bi){
            sql = sql+" and o.organName = '" + organName + "'";
        }
        if(ex){
            sql = sql+" and s.executeTime = '" + executeTime + "'";
        }
        if(re){
            sql = sql+" and s.recordTaskDate = '" + recordTaskDate + "'";
        }
        sql = sql + " limit ?,?";

        List<Map<String, String>> query = DBUtil.query(sql, (page - 1) * size, size);
        List<TaxSource> l = new ArrayList<>();
        for (Map<String, String> mp:query) {
            TaxSource so = new TaxSource();
            BeanUtil.mapToBean(so,mp);
            l.add(so);
        }
        return l;
    }
}
