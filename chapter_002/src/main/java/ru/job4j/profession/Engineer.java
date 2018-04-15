package ru.job4j.profession;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 14.04.2018
 */
public class Engineer extends Profession {

    public Engineer(String profession, String name) {
        this.profession = profession;
        this.name = name;
    }
}

class HouseBuilt {
    public String house;

    public String built;

    public HouseBuilt(String built, String house) {
        this.built = built;
        this.house = house;
    }
}
