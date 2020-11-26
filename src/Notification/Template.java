package Notification;
import java.sql.*;


public class Template
{
    private Connection connection;
    public Template() throws SQLException {
        this.connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Notification","root","");
    }
    public String read(String name){
        String temp="";
        try{
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
    public void addTemplate(String name,String temp){
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Templates(Name,Template) VALUES (?,?)");
            statement.setString(1,name);
            statement.setString(2,temp);
            int rows = statement.executeUpdate();
            if(rows > 0)
                System.out.println("Inserted");
            else
                System.out.println("Not Inserted");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(String name){
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Templates WHERE Name=?");
            statement.setString(1,name);
            int rows = statement.executeUpdate();
            if(rows > 0)
                System.out.println("Deleted");
            else
                System.out.println("Not Deleted");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateTemplate(String name , String temp){
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE Templates SET Template = ?  WHERE Name=?");
            statement.setString(1,temp);
            statement.setString(2,name);
            int rows = statement.executeUpdate();
            if(rows > 0)
                System.out.println("Updated");
            else
                System.out.println("Not Updated");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
