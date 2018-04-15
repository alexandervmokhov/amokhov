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
    public String teach;

    public String student;

    public TeachStudent(String teach, String student) {
        this.teach = teach;
        this.student = student;
    }
}
