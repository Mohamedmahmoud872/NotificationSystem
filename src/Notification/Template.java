package Notification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Template {
    public String read(String name){
        String temp="";
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Notification","root","");
            Statement statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select Template from Templates Where Name='" + name +  "'");
            while (resultSet.next()){
                temp = resultSet.getString("Template");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "";
        }
        return temp;
    }
}
