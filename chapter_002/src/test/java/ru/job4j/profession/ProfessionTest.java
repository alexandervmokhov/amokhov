package ru.job4j.profession;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 15.04.2018
 */
public class ProfessionTest {
    /**
     * Тест проверяет, что методы public getProfession и public getName
     * из родительского класса Profession, возвращают профессию и имя
     * при их вызове для унаследованного класса Doctor.
     */
    @Test
    public void getInfoAboutProfessionAndNameFromProfessionForDoctor() {
        Profession doctor = new Doctor("Doctor", "House");
        assertThat(doctor.getProfession(), is("Doctor"));
        assertThat(doctor.getName(), is("House"));
    }

    /**
     * Тест проверяет, что класс PatientDiagnose из файла
     * Doctor возвращает имя пациента и диагноз.
     */
    @Test
    public void getInfoAboutPatient() {
    PatientDiagnose patientDiagnose = new PatientDiagnose("Wilson", "cancer");
    assertThat(patientDiagnose.getPatient(), is("Wilson"));
    assertThat(patientDiagnose.getDiagnose(), is("cancer"));
    }

    /**
     * Тест проверяет, что методы public getProfession и public getName
     * из родительского класса Profession, возвращают профессию и имя
     * при их вызове для унаследованного класса Engineer.
     */
    @Test
    public void getInfoAboutProfessionAndNameFromProfessionForEngineer() {
        Profession engineer = new Engineer("Engineer", "Wright");
        assertThat(engineer.getProfession(), is("Engineer"));
        assertThat(engineer.getName(), is("Wright"));
    }

    /**
     * Тест проверяет, что класс HouseBuilt из файла
     * Engineer возвращает страну постройки и название дома.
     */
    @Test
    public void getInfoAboutHouse() {
        HouseBuilt houseBuilt = new HouseBuilt("in USA", "Fallingwater");
        assertThat(houseBuilt.getBuilt(), is("in USA"));
        assertThat(houseBuilt.getHouse(), is("Fallingwater"));
    }

    /**
     * Тест проверяет, что методы public getProfession и public getName
     * из родительского класса Profession, возвращают профессию и имя
     * при их вызове для унаследованного класса Teacher.
     */
    @Test
    public void getInfoAboutProfessionAndNameFromProfessionForTeacher() {
        Teacher teacher = new Teacher("Teacher", "Parsentev");
        assertThat(teacher.getProfession(), is("Teacher"));
        assertThat(teacher.getName(), is("Parsentev"));
    }

    /**
     * Тест проверяет, что класс TeachStudent из файла
     * Teacher возвращает вид обучения и фамилию студента.
     */
    @Test
    public void getInfoAboutStudent() {
        TeachStudent teachStudent = new TeachStudent("Java programming", "Mokhov");
        assertThat(teachStudent.getTeach(), is("Java programming"));
        assertThat(teachStudent.getStudent(), is("Mokhov"));
    }
}