package com.sda.jdbc;

public class Main {
    public static void main(String[] args) {
        MotherJdbcDao motherJdbcDao = new MotherJdbcDao();

        Mother mother1 = new Mother("Maria",30,"str. Lalelelor");

        motherJdbcDao.create(mother1);


    }
}
