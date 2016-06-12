package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gabriel on 12/06/16.
 */
public class Populate {
    public static void populate(Connection db) throws IOException, SQLException {
        Statement stmt = db.createStatement();
        try {
            String line;
            BufferedReader input = openSQLfile( "db/insert.sql" );
            while ((line = input.readLine()) != null) {
                stmt.executeUpdate(line);
                System.out.println(line);
            }
            input.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }

    }

    public static BufferedReader openSQLfile(String SQL_FILE) throws FileNotFoundException {
        return new BufferedReader( new FileReader(SQL_FILE) );
    }
}
