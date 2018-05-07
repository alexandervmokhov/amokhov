package ru.job4j.profession;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 14.04.2018
 */
public class Profession {
    public String profession;

    public String name;

    public Profession() {
    }

    private Profession(String profession, String name) {
        this.profession = profession;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }
}
