package com.example.makingdevs.javasql.database;

/**
 * Created by makingdevs on 13/02/17.
 */

public class AccountDbSchema {
    public static class AccountTable {
        public static final String NAME = "accounts";
        public static class Column {
           public  static final String NAME = "username";
            public static final String ACCOUNT_NUMBER= "account_number";
        }
    }
}
