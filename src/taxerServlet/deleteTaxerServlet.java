package taxerServlet;

import net.sf.json.JSONObject;
import untity.conntion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteTaxerServlet.do")
public class deleteTaxerServlet extends HttpServlet {
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

        conntion coa=new conntion();
        int a=coa.delectTaxer(Integer.parseInt(id));

        if (a!=0) {
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
