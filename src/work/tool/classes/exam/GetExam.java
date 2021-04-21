package work.tool.classes.exam;

import work.sql.JDBCUtil;
import work.tool.interfaces.exam.GetExamItf;
import work.tool.property.exam.ExamProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class GetExam implements GetExamItf {
    @Override
    public ArrayList<ExamProperty> getChoiceExam() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConn();
            String sql = "SELECT * FROM access";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<ExamProperty> exams = new ArrayList<>();
            int i = 1;
            while (rs.next()) {

                ExamProperty exam = new ExamProperty();
                exam.setId(i);
                exam.setQuestion(rs.getString("question"));
                exam.setOptions(rs.getString("options"));
                exam.setScore(rs.getInt("score"));

                exams.add(exam);
                i++;
            }

            Collections.shuffle(exams);

            return new ArrayList<>(exams.subList(0, 50));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.replace(conn, ps, rs);
        }

        return null;
    }
}
