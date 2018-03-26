package lab;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String fio;
    private double rating;
    private String faculty;

    public Student(int id, String fio, double rating, String faculty) {
        this.id = id;
        this.fio = fio;
        this.rating = rating;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Double.compare(student.rating, rating) == 0 &&
                Objects.equals(fio, student.fio) &&
                Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, rating, faculty);
    }

    @Override
    public String toString() {
        return id + " " + fio + " " + rating + " " + faculty;
    }

    @Override
    public int compareTo(Student other) {
        int r = this.fio.compareTo(other.fio);
        if (r == 0) {
            return Integer.compare(this.id, other.id);
        }
        return r;
    }
}
