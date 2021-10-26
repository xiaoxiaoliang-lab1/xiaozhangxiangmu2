package serevlet;

import cn.hutool.json.JSONUtil;
import entity.Pagebean;
import entity.messmge;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/listpayer.do")
public class listpayer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");//第几页
        String rows = req.getParameter("rows");//一页多少条


        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");


        if(payerCode!=null||payerName!=null){


            dao da=new dao();
            List ll = null;
            ll=da.selectSerch(payerCode,payerName,Integer.parseInt(page), Integer.parseInt(rows));
            Map<String, Object> map = new HashMap<>();
            map.put("rows", ll);
            int a=1;
            if (payerCode==null){
                conntion coa=new conntion();
                a=coa.countBypayerName(payerName);
            }
            map.put("total",a);
            PrintWriter out = resp.getWriter();
            out.write(JSONObject.fromObject(map).toString());
            out.flush();
            out.close();
        }else {
            conntion coa=new conntion();
            List ll = null;
            try {
                ll = coa.selectPage(Integer.parseInt(page), Integer.parseInt(rows));

            } catch (Exception e) {
                e.printStackTrace();
            }
            //new UserDao().
            Map<String, Object> map = new HashMap<>();
            try {
                map.put("total", coa.selectcount());
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.put("rows", ll);

            PrintWriter out = resp.getWriter();
            out.write(JSONObject.fromObject(map).toString());
            out.flush();
            out.close();
        }



    }
    }

