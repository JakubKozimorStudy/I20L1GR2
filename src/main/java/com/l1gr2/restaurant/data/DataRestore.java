package com.l1gr2.restaurant.data;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataRestore {

    public void clear_database(File file) throws IOException {


        //File file = new File("F:\\Programowanie\\testowyintellij\\src\\com\\company\\kopijka.sql");

        String path = null;
        //String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //path = path + "_" + date + ".sql";        //to backup


        path = file.getAbsolutePath();
        path = path.replace('\\', '/');

        //Process runtime = Runtime.getRuntime().exec("mysqldump -u root restaurant --routines -r "+path);   // back

        String[] restoreCmd = new String[]{"mysql ", "--user=" + "root", "--password=" + "", "-e", "source " + path}; //restore
        Process runtime = Runtime.getRuntime().exec(restoreCmd);
    }
}