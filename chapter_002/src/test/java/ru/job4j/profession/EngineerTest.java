package ru.job4j.profession;

import org.junit.Test;

/**
 * @author Alexander Mokhov (alexander.v.mokhov@gmail.com
 * @version $Id$
 * since 15.04.2018
 */
public class EngineerTest {

    /**
     * Тест проверяет, что методы public getProfession и public getName
     * из родительского класса Profession, возвращают профессию и имя
     * при их вызове для унаследованного класса Engineer.
     */
    @Test
    public void getInfoAboutEngineer() {
        Engineer engineer = new Engineer("Engineer", "Wright");
    }

    /**
     * Тест проверяет, что метод HouseBuilt возвращает построен и дом.
     */
    @Test
    public void getInfoAboutHouse() {
        HouseBuilt result = new HouseBuilt("in USA", "Fallingwater");
    }

}