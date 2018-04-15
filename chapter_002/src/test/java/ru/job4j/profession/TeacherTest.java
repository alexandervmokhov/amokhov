package ru.job4j.profession;

import org.junit.Test;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 15.04.2018
 */
public class TeacherTest {

    /**
     * Тест проверяет, что методы public getProfession и public getName
     * из родительского класса Profession, возвращают профессию и имя
     * при их вызове для унаследованного класса Teacher.
     */
    @Test
    public void getInfoAboutTeacher() {
        Teacher teacher = new Teacher("Teacher", "Parsentev");
    }

    /**
     * Тест проверяет, что метод TeachStudent возвращает учит и студент.
     */
    @Test
    public void getInfoAboutStudent() {
        TeachStudent result = new TeachStudent("Java programming", "Mokhov");
    }

}