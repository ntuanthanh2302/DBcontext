package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Departments {
    Connection cnn; //kết nối DB
    Statement stm;//thực thi
    PreparedStatement stm1;
    ResultSet rs; //chứa dữ liệu sau khi select

    private String dept_no;
    private String dept_name;

    public Departments() {
        connect();
    }

    public Departments( String dept_no, String dept_name) {
        this.dept_no = dept_no;
        this.dept_name = dept_name;
        connect();
    }


    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public void connect() {
        try {
            cnn = (new DBcontext()).connect();
            System.out.println("Connect thành công");
        } catch (Exception e) {
            System.out.println("Lỗi connect " + e.getMessage());
        }
    }

    public List<Departments> getFunctionDepartment() {
        List<Departments> list = new ArrayList<>();
        String str = "select * from pro_test1() ";
        try {
            cnn = (new DBcontext()).connect();
            //  stm = cnn.prepareStatement(strCheck);
            stm1 = cnn.prepareStatement(str);
            rs = stm1.executeQuery();
            while (rs.next()) {
                list.add(new Departments(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Lỗi get:" + e.getMessage());
        }
        return list;
    }

}
