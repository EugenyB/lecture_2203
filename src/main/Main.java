package main;

import lab.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ivanov", 75, "nniknup"));
        students.add(new Student(2, "Fetrenko", 70, "nnki"));
        students.add(new Student(3, "Sidoruk", 95, "nnhi"));
        students.add(new Student(4, "Zayceva", 86, "nniknup"));
        students.add(new Student(5, "Ivanov", 90, "nnhi"));


        Set<String> faculties = getFaculties(students);
        System.out.println(faculties);

        Map<String, List<Student>> map = getStudentsByFaculties(students);
        System.out.println(map);

        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("------------------------------");
        Collections.sort(students, new MyComparator());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private Map<String, List<Student>> getStudentsByFaculties(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            if (!map.containsKey(student.getFaculty())) {
                map.put(student.getFaculty(), new ArrayList<>());
            }
            map.get(student.getFaculty()).add(student);
        }
        return map;
    }

    private Set<String> getFaculties(List<Student> students) {
        return students.stream().map(Student::getFaculty).collect(Collectors.toSet());
    }
}

class MyComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int f = o1.getFaculty().compareTo(o2.getFaculty());
        if (f!=0) return f;
        int t = o1.getFio().compareTo(o2.getFio());
        if (t!=0) return t;
        return Integer.compare(o1.getId(), o2.getId());
    }
}