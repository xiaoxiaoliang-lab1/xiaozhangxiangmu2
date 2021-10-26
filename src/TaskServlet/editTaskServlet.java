package TaskServlet;

import entity.TaxSource;
import entity.User;
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

@WebServlet("/editTaskServlet.do")
public class editTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        dao da=new dao();
        // 获取参数，建立对象
        TaxSource task = new TaxSource();
        String id = req.getParameter("id");
        task.setId(Integer.parseInt(id));
//        String payerId = req.getParameter("payerId");
//        task.setPayerId(Integer.valueOf(payerId));

//        String payerCode = req.getParameter("payerCode");
//        task.setPayerCode(payerCode);


//        String taskName = req.getParameter("taskName");
//        task.setTaskName(taskName);
        String subOrganId = req.getParameter("subOrganId");
        task.setSubOrganId(Integer.parseInt(subOrganId));

        String approverId = req.getParameter("approverId");
        task.setApproverId(Integer.parseInt(approverId));

        String executeId = req.getParameter("executeId");
        task.setExecuteId(Integer.parseInt(executeId));

        String executeTime = req.getParameter("executeTime");
        task.setExecuteTime(executeTime);

        String taskState = req.getParameter("taskState");
        task.setTaskState(taskState);


//        task.setTaskState("上级分配");

//        task.setIdea("无");
//        task.setRiskLevel(0);
//        String s1 = (String) session.getAttribute("xiaozhang");
//        User user = da.selectUserByName(s1);
//        Integer recordUserId = user.getId();
//        task.setRecordUserId(recordUserId);
//        Date date = new Date();
//        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
//        String format = sim.format(date);
//        task.setRecordTaskDate(format);

        conntion coa=new conntion();

        System.out.println(task);
        int b = coa.changeTask(task);

        if (b!=0) {
            json.put("success", true);
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

