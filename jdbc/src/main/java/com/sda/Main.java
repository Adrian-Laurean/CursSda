package com.sda;

import com.sda.jdbc.MotherJdbcDao;

public class Main {
    public static void main(String[] args) {
        MotherJdbcDao motherJdbcDao = new MotherJdbcDao();

        Mother mother1 = new Mother("Maria",30,"str. Lalelelor");

        //motherJdbcDao.create(mother1);

        //System.out.println(motherJdbcDao.readAll());

        //motherJdbcDao.readAll().forEach(m-> System.out.println(m.toString()));
        Mother mother2 = new Mother("Cristina",40,"str. Trandafirilor");

        //motherJdbcDao.update(1,mother2);
        motherJdbcDao.delete(1);

    }
}
