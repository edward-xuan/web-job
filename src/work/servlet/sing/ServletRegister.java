package work.servlet.sing;

import work.tool.sing.classes.UserLog;
import work.tool.sing.interfaces.UserLogItf;
import work.tool.sing.property.UserProperty;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "ServletRegister", value = "/reg")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password = Base64.getEncoder().encodeToString(password.getBytes());
        UserProperty up = new UserProperty(username, email, password);

        UserLogItf ui = new UserLog(up);
        boolean b = ui.singUp();

        // 注册失败，重新注册，进入注册界面
        if (!b) {
            response.sendRedirect("register.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(123);
    }
}
