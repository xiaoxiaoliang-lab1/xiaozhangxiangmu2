package serevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/yanzheng")
public class YanzhengConttroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String code = (String)req.getSession().getAttribute("code");
        if (name.equals(code)){
            PrintWriter wr = resp.getWriter();
            wr.write("true");
            wr.flush();
            wr.close();
        }else {
            PrintWriter wr = resp.getWriter();
            wr.write("false");
            wr.flush();
            wr.close();
        }
    }
}
