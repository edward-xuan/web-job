package work.servlet.exam;

import work.tool.classes.exam.GetExam;
import work.tool.property.exam.ExamProperty;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletExam", value = "/exam")
public class ServletExam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("exams") == null) {
            ArrayList<ExamProperty> exam = new GetExam().getChoiceExam();
            request.getSession().setAttribute("exams", exam);
            response.sendRedirect("/exam/test.jsp");
        } else {
            response.sendRedirect("/exam/test.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
