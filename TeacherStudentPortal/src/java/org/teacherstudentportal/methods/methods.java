package org.teacherstudentportal.methods;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.teacherstudentportal.controller.loginController.checklogin;
import org.teacherstudentportal.entities.student;

public class methods {

    public static student student = new student();

    public static Connection connectDB() {
        System.out.println("-------- MYSQL JDBC Connection Testing ------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            
        }
        System.out.println("MYSQL JDBC Driver Registered!");
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_portal", "root", "");
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
        }
        if (con != null) {
            System.out.println("Success!!!");

        } else {
            System.out.println("Failed!!!");
        }
        return con;
    }

    public Boolean checkLogin(Connection con, String email, String pass, String role) {
        Boolean temp = false;
        String name = "ss";
        String var = role;
        String admin = "ADMINISTRATOR";
        String student = "student";
        String instructor = "instructor";
        String insid;
        String stuid;
        out.println(role);

        try {
            if (admin.equals(var)) {
                out.println(var);
                PreparedStatement ps = con.prepareStatement("select * from ADMINISTRATOR where email=? and password=?");
                //ps.setString(1,role);
                ps.setString(1, email);
                ps.setString(2, pass);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {

                        if (rs.getString("name") != null) {
                            name = rs.getString("name");
                            checklogin.setUser(name);

                            temp = true;
                        }
                    }
                    con.close();
                } catch (SQLException e) {
                    temp = false;
                    out.println("error from if");
                    //Logger.getLogger(MethodUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (student.equals(var)) {
                out.println(var);
                PreparedStatement ps = con.prepareStatement("select * from student where email=? and password=?");
                //ps.setString(1,role);
                ps.setString(1, email);
                ps.setString(2, pass);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        if (rs.getString("stu_first_name") != null) {
                            name = rs.getString("stu_first_name");
                            checklogin.setUser(name);
                            temp = true;
                        }
                        if (rs.getString("STU_ID") != null) {
                            stuid = rs.getString("STU_ID");
                            checklogin.setStuid(stuid);
                            out.println(checklogin.getStuid());
                        }
                    }
                    con.close();
                } catch (SQLException e) {
                    temp = false;
                    out.println("error from if");
                    //Logger.getLogger(MethodUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (instructor.equals(var)) {
                out.println(var);
                PreparedStatement ps = con.prepareStatement("select * from instructor where email=? and password=?");
                //ps.setString(1,role);
                ps.setString(1, email);
                ps.setString(2, pass);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        if (rs.getString("ins_first_name") != null) {
                            name = rs.getString("ins_first_name");
                            checklogin.setUser(name);
                            temp = true;
                        }
                        if (rs.getString("ins_id") != null) {
                            insid = rs.getString("INS_ID");
                            checklogin.setInsid(insid);
                            out.println(checklogin);

                        }
                    }
                    con.close();
                } catch (SQLException e) {
                    temp = false;
                    out.println("error from if");
                    //Logger.getLogger(MethodUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            out.println("error from outer try");
            //Logger.getLogger(MethodUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;

    }

    public boolean updateStuData(Connection con, String id, String fname, String lname, String dob, String sex, String address, String email, String phone, String insid, String depid) {
        boolean temp = false;

        String query = "update student set STU_FIRST_NAME='" + fname + "',STU_LAST_NAME='" + lname + "',STU_DOB='" + dob + "',STU_SEX='" + sex + "',STU_ADDRESS='" + address + "',EMAIL='" + email + "',STU_PHONE='" + phone + "',INS_ID='" + insid + "',DEP_ID='" + depid + "' where STU_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);

            if (i != 0) {
                temp = true;
                out.println("success");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public boolean studentUpdData(Connection con, String id, String fname, String lname, String dob, String sex, String address, String email, String phone, String insid, String depid, String Password) {
        boolean temp = false;

        String query = "update student set STU_FIRST_NAME='" + fname + "',STU_LAST_NAME='" + lname + "',STU_DOB='" + dob + "',STU_SEX='" + sex + "',STU_ADDRESS='" + address + "',EMAIL='" + email + "',STU_PHONE='" + phone + "',INS_ID='" + insid + "',DEP_ID='" + depid + "',PASSWORD='" + Password + "' where STU_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);

            if (i != 0) {
                temp = true;
                out.println("success");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public boolean insUpdateData(Connection con, String id, String fname, String lname, String dob, String sex, String address, String email, String phone, String did, String password) {
        boolean temp = false;

        String query = "update instructor set INS_FIRST_NAME='" + fname + "',INS_LAST_NAME='" + lname + "',INS_DOB='" + dob + "',INS_SEX='" + sex + "',INS_ADDRESS='" + address + "',EMAIL='" + email + "',INS_PHONE='" + phone + "',DEP_ID='" + did + "',PASSWORD='" + password + "'where INS_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);

            if (i != 0) {
                temp = true;
                out.println("success");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public boolean updateInsData(Connection con, String id, String fname, String lname, String dob, String sex, String address, String email, String phone, String did) {
        boolean temp = false;

        String query = "update instructor set INS_FIRST_NAME='" + fname + "',INS_LAST_NAME='" + lname + "',INS_DOB='" + dob + "',INS_SEX='" + sex + "',INS_ADDRESS='" + address + "',EMAIL='" + email + "',INS_PHONE='" + phone + "',DEP_ID='" + did + "'where INS_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);

            if (i != 0) {
                temp = true;
                out.println("success");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public boolean updateDepData(Connection con, String id, String name) {
        boolean temp = false;

        String query = "update department set DEP_NAME='" + name + "' where DEP_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);

            if (i != 0) {
                temp = true;
                out.println("success");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public boolean updateCouData(Connection con, String id, String title, String desc, String credit) {
        boolean temp = false;

        String query = "update course set cou_title='" + title + "',cou_desc='" + desc + "',cou_credit='" + credit + "'where COU_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);

            if (i != 0) {
                temp = true;
                out.println("success");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public Boolean deleteStuData(Connection con, String id) {
        boolean temp = false;
        System.out.println(id);
        String query = "delete from STUDENT where STU_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);
            if (i != 0) {
                temp = true;
                out.println("success from delete");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public Boolean deleteInsData(Connection con, String id) {
        boolean temp = false;

        String query = "delete from instructor where INS_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);
            if (i != 0) {
                temp = true;
                out.println("success from delete");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public Boolean deleteCouData(Connection con, String id) {
        boolean temp = false;

        String query = "delete from course where COU_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);
            if (i != 0) {
                temp = true;
                out.println("success from delete");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public Boolean deleteDepData(Connection con, String id) {
        boolean temp = false;

        String query = "delete from department where DEP_ID='" + id + "'";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(query);
            if (i != 0) {
                temp = true;
                out.println("success from department");
            }

        } catch (SQLException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
            out.println("error in resulset update method");
            temp = false;
        }

        return temp;
    }

    public Boolean insertInsData(Connection con, String id, String fname, String lname, String dob, String sex, String address, String email, String phone, String depid, String password) {
        Boolean temp = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into instructor(INS_ID,INS_FIRST_NAME,INS_LAST_NAME,INS_DOB,INS_SEX,INS_ADDRESS,EMAIL,DEP_ID,PASSWORD,INS_PHONE) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, dob);
            ps.setString(5, sex);
            ps.setString(6, address);
            ps.setString(7, email);
            ps.setString(8, depid);
            ps.setString(9, password);
            ps.setString(10, phone);

            int chk = ps.executeUpdate();

            if (chk != 0) {
                temp = true;
                con.close();

            } else {
                //JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                temp = false;
            }

            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return temp;
    }

    public Boolean insertStuData(Connection con, String id, String fname, String lname, String dob, String sex, String address, String email, String phone, String insid, String depid, String password) {
        Boolean temp = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into student(STU_ID,STU_FIRST_NAME,STU_LAST_NAME,STU_DOB,STU_SEX,STU_ADDRESS,EMAIL,STU_PHONE,INS_ID,DEP_ID,PASSWORD) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, dob);
            ps.setString(5, sex);
            ps.setString(6, address);
            ps.setString(7, email);
            ps.setString(8, phone);
            ps.setString(9, insid);
            ps.setString(10, depid);
            ps.setString(11, password);

            int chk = ps.executeUpdate();

            if (chk != 0) {
                temp = true;
                con.close();

            } else {
                //JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                temp = false;
            }

            con.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public Boolean insertCouData(Connection con, String id, String title, String desc, String credit, String depid) {
        Boolean temp = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into course (COU_ID,COU_TITLE,COU_DESC,COU_CREDIT,DEP_ID) values(?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, title);
            ps.setString(3, desc);
            ps.setString(4, credit);
            ps.setString(5, depid);

            int chk = ps.executeUpdate();

            if (chk != 0) {
                temp = true;
                con.close();

            } else {
                //JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                temp = false;
            }

            con.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public Boolean insertDepData(Connection con, String id, String name) {
        Boolean temp = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into department (DEP_ID,DEP_NAME) values(?,?)");
            ps.setString(1, id);
            ps.setString(2, name);

            int chk = ps.executeUpdate();

            if (chk != 0) {
                temp = true;
                con.close();

            } else {
                //JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                temp = false;
            }

            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return temp;
    }

    public Boolean insertGradeData(Connection con, String grade, String sid, String cid) {
        Boolean temp = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into grade (GRADE,STU_ID,CLA_ID) values(?,?,?)");
            ps.setString(1, grade);
            ps.setString(2, sid);
            ps.setString(3, cid);

            int chk = ps.executeUpdate();

            if (chk != 0) {
                temp = true;
                con.close();

            } else {
                //JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
                temp = false;
            }

            con.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public Boolean checkGrade(Connection con, String id) {

        Boolean temp = false;
        ResultSet ins;
        String grade;
        try {
            Statement inssmt = con.createStatement();
            String mySQL = "select * from grade where STU_ID='" + id + "'";
            ins = inssmt.executeQuery(mySQL);
            if (ins.next()) {
                grade = ins.getString("grade");
                checklogin.setGrade(grade);
                temp = true;
            }
        } catch (SQLException e) {
            out.println("error");
            temp = false;
        }
        return temp;
    }

}
