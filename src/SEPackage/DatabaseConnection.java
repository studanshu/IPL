/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Manav
 */
public class DatabaseConnection {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public DatabaseConnection(){
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("java.sql.DriverManager");
            // Setup the connection with the DB
            String host="jdbc:mysql://10.5.18.69/12CS10053";
            String user="12CS10053";
            String pass="btech12";
            connect = DriverManager.getConnection(host, user, pass);

            statement = connect.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Unable to connect");
        }
    }
    
    public ResultSet getPlayerNames(){
        try{
            resultSet = statement.executeQuery("select * from 12CS10053.Person;");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
    public ResultSet getPlayerStatistics(String name, String year){
        try{
            resultSet = statement.executeQuery("select * from Person natural join Player_statistics where name=\""+name+"\" and year="+year+";");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
    public ResultSet getPlayerDetails(String name){
        try{
            resultSet = statement.executeQuery("select * from Person natural join Player where name=\""+name+"\";");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
    public ResultSet getPlayerTeam(String name,String year){
        try{
            resultSet = statement.executeQuery("select * from Person natural join TeamPlayer where name=\""+name+"\" and year="+year+";");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
    public ResultSet getPlayerBid(String name,String year){
        try{
            resultSet = statement.executeQuery("select * from Person natural join Bids where name=\""+name+"\" and year="+year+";");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
    public ResultSet getTeam(String name,String year){
        try{
            resultSet = statement.executeQuery("select * from Person natural join TeamPlayer where teamname=\""+name+"\" and year="+year+";");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
    public ResultSet getCaptain(String name,String year){
        try{
            resultSet = statement.executeQuery("select * from Person natural join Team where teamname=\""+name+"\" and year="+year+";");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
}
