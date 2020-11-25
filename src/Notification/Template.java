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
}
