package ru.job4j.profession;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 14.04.2018
 */
public class Doctor extends Profession {

    public Doctor(String profession, String name) {
        this.profession = profession;
        this.name = name;
    }
}

class PatientDiagnose {
    public String patient;

    public String diagnose;

    public PatientDiagnose(String patient, String diagnose) {
        this.patient = patient;
        this.diagnose = diagnose;
    }
}