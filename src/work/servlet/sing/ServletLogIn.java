package work.servlet.sing;

import work.tool.sing.classes.UserLog;
import work.tool.sing.property.UserProperty;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "ServletLogIn", value = "/log")
public class ServletLogIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password = Base64.getEncoder().encodeToString(password.getBytes());

        UserLog ui = new UserLog(new UserProperty(email, password));
        boolean b = ui.login();

        // 登录失败，重新登录, 进入登录界面
        if (!b) {
            response.sendRedirect("login.html");
        }
    }
}