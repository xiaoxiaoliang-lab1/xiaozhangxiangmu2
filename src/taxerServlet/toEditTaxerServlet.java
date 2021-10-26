package taxerServlet;

import entity.TaxOrgan;
import entity.Taxer;
import entity.User;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
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

@WebServlet("/toEditTaxerServlet.do")
public class toEditTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        dao da=new dao();
        Taxer taxer = da.selectTaxerById(Integer.valueOf(id));
        req.setAttribute("taxer", taxer);
        List<TaxOrgan> taxOrgans = da.selectAllshuiwuju();
        req.setAttribute("organs",taxOrgans);

        req.getRequestDispatcher("editTaxer.jsp").forward(req,
                resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        JSONObject json = new JSONObject();
        HttpSession session = req.getSession();
        // 建立对象，获取和设置参数
        Taxer taxer = new Taxer();
        String id = req.getParameter("id");
        taxer.setId(Integer.parseInt(id));
        String taxerCode = req.getParameter("taxerCode");
        taxer.setTaxerCode(taxerCode);
        String taxerName = req.getParameter("taxerName");
        taxer.setTaxerName(taxerName);
        String mobile = req.getParameter("mobile");
        taxer.setMobile(mobile);
        String address = req.getParameter("address");
        taxer.setAddress(address);
        String sex = req.getParameter("sex");
        taxer.setSex(sex);
        String birthday = req.getParameter("birthday");
        if(StringUtils.isNotEmpty(birthday))
            taxer.setBirthday(birthday);
        String email = req.getParameter("email");
        taxer.setEmail(email);
        String organId = req.getParameter("organId");
        if ("-1".equals(organId)) {
            taxer.setOrganId(null);
        } else {
            taxer.setOrganId(Integer.parseInt(organId));
        }
        dao da=new dao();
        Date date = new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        String format = sim.format(date);
        taxer.setRecordDate(format);
       String user = String.valueOf(session.getAttribute("user"));
        User user1 = da.selectUserByName(user);
        taxer.setRecordUserId(user1.getId());
        taxer.setState(0);

        // 保存
        boolean b = da.updateTaxer(taxer, Integer.parseInt(id));
        if (b) {
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
