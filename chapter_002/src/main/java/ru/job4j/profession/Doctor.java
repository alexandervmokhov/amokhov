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
    private String patient;

    private String diagnose;

    public PatientDiagnose(String patient, String diagnose) {
        this.patient = patient;
        this.diagnose = diagnose;
    }
    public String getPatient() {
        return this.patient;
    }

    public String getDiagnose() {
        return this.diagnose;
    }
}