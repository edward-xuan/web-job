package work.tool.property.exam;

public class ExamProperty {
    public int id = 0;
    public String question;
    public String options;
    public String answer;
    public int score;

    public ExamProperty() {
    }

    public ExamProperty(int id, String question, String options, String answer, int score) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
