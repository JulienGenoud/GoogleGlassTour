package eu.epitech.myintra.models;

/**
 * Created by ohayon_m on 28/10/14.
 */
public class Mark {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(Integer scolaryear) {
        this.scolaryear = scolaryear;
    }

    public String getCorrector() {
        return corrector;
    }

    public void setCorrector(String corrector) {
        this.corrector = corrector;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "title='" + title + '\'' +
                ", module='" + module + '\'' +
                ", date='" + date + '\'' +
                ", mark='" + mark + '\'' +
                ", scolaryear=" + scolaryear +
                ", corrector='" + corrector + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    String title;
    String module;
    String date;
    String mark;
    Integer scolaryear;
    String corrector;
    String comment;

}
