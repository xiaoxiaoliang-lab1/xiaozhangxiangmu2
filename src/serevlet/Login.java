package serevlet;

import untity.conntion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("loguser");
        String pass = req.getParameter("logpass");
        String save = req.getParameter("save");

        HttpSession session = req.getSession();

        if(session.getAttribute("user")!=null){
            if (session.getAttribute("user").equals(user)){

                req.getSession().setAttribute("xiaozhang",user);
                PrintWriter wr = resp.getWriter();
                wr.write("true");
                wr.flush();
                wr.close();
            }else {
                if (save != null) {
                    conntion con = new conntion();
                    int lj = con.lianjie(user, pass);
                    if (lj != 0) {
                        session.setAttribute("user", user);
                        session.setMaxInactiveInterval(15);

                        req.getSession().setAttribute("permissionId",lj);
                        req.getSession().setAttribute("xiaozhang", user);

                        PrintWriter wr = resp.getWriter();
                        wr.write("true");
                        wr.flush();
                        wr.close();
                    } else {
                        PrintWriter wr = resp.getWriter();
                        wr.write("false");
                        wr.flush();
                        wr.close();
                    }

                } else {
                    conntion con = new conntion();
                    int lj = con.lianjie(user, pass);
                    if (lj != 0 ) {

                        req.getSession().setAttribute("permissionId",lj);
                        req.getSession().setAttribute("xiaozhang", user);
                        PrintWriter wr = resp.getWriter();
                        wr.write("true");
                        wr.flush();
                        wr.close();
                    } else {
                        PrintWriter wr = resp.getWriter();
                        wr.write("false");
                        wr.flush();
                        wr.close();
                    }

                }
            }
        }else {
            if (save != null) {
                conntion con = new conntion();
                int lj = con.lianjie(user, pass);
                if (lj !=0) {
                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(15);
                    req.getSession().setAttribute("permissionId",lj);
                    req.getSession().setAttribute("xiaozhang", user);


                    PrintWriter wr = resp.getWriter();
                    wr.write("true");
                    wr.flush();
                    wr.close();
                } else {
                    PrintWriter wr = resp.getWriter();
                    wr.write("false");
                    wr.flush();
                    wr.close();
                }

            } else {
                conntion con = new conntion();
                int lj = con.lianjie(user, pass);
                if (lj !=0 ) {

                    req.getSession().setAttribute("permissionId",lj);
                    req.getSession().setAttribute("xiaozhang", user);


                    PrintWriter wr = resp.getWriter();
                    wr.write("true");
                    wr.flush();
                    wr.close();
                } else {
                    PrintWriter wr = resp.getWriter();
                    wr.write("false");
                    wr.flush();
                    wr.close();
                }
            }

        }



    }
}
