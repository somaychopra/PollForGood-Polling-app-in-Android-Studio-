package software.project.pollforgood.Model;

public class Polls {

    private String time, question, option1, option2, option3, option4, option5, option6, option7, date, pollid;
    private int option1count, option2count, option3count, option4count, option5count, option6count, option7count, durationinHrs,hourofday,dayofyear;

    public Polls() {

    }

    public Polls(int hourofday, int dayofyear) {
        this.hourofday = hourofday;
        this.dayofyear = dayofyear;
    }

    public Polls(String time, String question, String option1, String option2, String option3, String option4, String option5, String option6, String option7, String date, String pollid, int option1count, int option2count, int option3count, int option4count, int option5count, int option6count, int option7count, int durationinHrs) {
        this.time = time;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.option6 = option6;
        this.option7 = option7;
        this.date = date;
        this.pollid = pollid;
        this.option1count = option1count;
        this.option2count = option2count;
        this.option3count = option3count;
        this.option4count = option4count;
        this.option5count = option5count;
        this.option6count = option6count;
        this.option7count = option7count;
        this.durationinHrs = durationinHrs;
    }

    public int getHourofday() {
        return hourofday;
    }

    public void setHourofday(int hourofday) {
        this.hourofday = hourofday;
    }

    public int getDayofyear() {
        return dayofyear;
    }

    public void setDayofyear(int dayofyear) {
        this.dayofyear = dayofyear;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getOption6() {
        return option6;
    }

    public void setOption6(String option6) {
        this.option6 = option6;
    }

    public String getOption7() {
        return option7;
    }

    public void setOption7(String option7) {
        this.option7 = option7;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPollid() {
        return pollid;
    }

    public void setPollid(String pollid) {
        this.pollid = pollid;
    }

    public int getOption1count() {
        return option1count;
    }

    public void setOption1count(int option1count) {
        this.option1count = option1count;
    }

    public int getOption2count() {
        return option2count;
    }

    public void setOption2count(int option2count) {
        this.option2count = option2count;
    }

    public int getOption3count() {
        return option3count;
    }

    public void setOption3count(int option3count) {
        this.option3count = option3count;
    }

    public int getOption4count() {
        return option4count;
    }

    public void setOption4count(int option4count) {
        this.option4count = option4count;
    }

    public int getOption5count() {
        return option5count;
    }

    public void setOption5count(int option5count) {
        this.option5count = option5count;
    }

    public int getOption6count() {
        return option6count;
    }

    public void setOption6count(int option6count) {
        this.option6count = option6count;
    }

    public int getOption7count() {
        return option7count;
    }

    public void setOption7count(int option7count) {
        this.option7count = option7count;
    }

    public int getDurationinHrs() {
        return durationinHrs;
    }

    public void setDurationinHrs(int durationinHrs) {
        this.durationinHrs = durationinHrs;
    }
}