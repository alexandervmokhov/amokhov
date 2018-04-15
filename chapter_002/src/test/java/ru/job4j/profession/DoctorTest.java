package ru.job4j.profession;

import org.junit.Test;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 15.04.2018
 */
public class DoctorTest {

    /**
     * Тест проверяет, что методы public getProfession и public getName
     * из родительского класса Profession, возвращают профессию и имя
     * при их вызове для унаследованного класса Doctor.
     */
    @Test
    public void getInfoAboutDoctor() {
    Doctor doctor = new Doctor("Doctor", "House");
    }

    /**
     * Тест проверяет, что метод PatientDiagnose возвращает пациента и диагноз.
     */
    @Test
    public void getInfoAboutPatient() {
        PatientDiagnose result = new PatientDiagnose("Wilson", "cancer");
    }

}