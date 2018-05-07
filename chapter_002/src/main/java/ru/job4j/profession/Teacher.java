package ru.job4j.profession;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 14.04.2018
 */
public class Teacher extends Profession {

    public Teacher(String profession, String name) {
        this.profession = profession;
        this.name = name;
    }
}

class TeachStudent {
    private String teach;

    private String student;

    public TeachStudent(String teach, String student) {
        this.teach = teach;
        this.student = student;
    }

    public String getTeach() {
        return this.teach;
    }

    public String getStudent() {
        return this.student;
    }
}
