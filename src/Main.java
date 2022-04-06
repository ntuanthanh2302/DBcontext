import Entity.Departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Departments app =new Departments();
        List<Departments> dao = app.getFunctionDepartment();
        for (Departments d: dao) {
            System.out.println(d.getDept_no()+"|"+d.getDept_name());
        }
    }
}
