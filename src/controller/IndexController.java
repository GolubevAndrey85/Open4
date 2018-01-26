package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

@Controller
//@RequestMapping("/hello")
//@RequestMapping("/")
public class IndexController {

    private static final String url = "mysql://mysql:3306/footbalPlayers";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    PreparedStatement preparedStmt;
    String query = "";


    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "index";
    }
    /*@RequestMapping(method = RequestMethod.POST)
    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("someAttribute", "login page!");
        return "login";
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "username", required = false) String text) {

        ModelAndView model = new ModelAndView();
        System.out.println(text);
        query = "INSERT INTO users(username,game,score) VALUES ('" + text + "','3', 5);";
        System.out.println(query);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();



        } catch (SQLException | ClassNotFoundException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { preparedStmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }



        model.addObject("someAttribute", text);

        model.setViewName("login");

        return model;

    }

}
