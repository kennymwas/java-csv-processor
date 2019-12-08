package entities;



/*
 *sample class used for csv import
 */
public class TestModel {

    @CsvColumn(name = "FullName")
    private String fullName;

    @CsvColumn(name = "Course")
    private String course;

    public TestModel(){

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "fullName='" + fullName + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
