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
    
    public ResultSet getSelectedPlayer(String name){
        try{
            resultSet = statement.executeQuery("select * from 12CS10053.Person where name like \""+name+"\"%;");
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
    
    public ResultSet getOwnerDetails(String name,String year){
        try{
            resultSet = statement.executeQuery("select * from Person natural join TeamOwner where name=\""+name+"\" and year="+year+";");
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
    
    public ResultSet getTeamBids(String teamname,String year){
        try{
            resultSet = statement.executeQuery("select * from Person natural join Bids where teamname=\""+teamname+"\" and year="+year+";");
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
    
    
    
    
     public ResultSet getHighestBids(String teamname,String year){
        try{
            if(year!=""){
                    resultSet = statement.executeQuery("select * from Person natural join Bids where teamname like \""+teamname+"%\" and year="+year+" order by bid_amount desc;");
            }
            else{
                    resultSet = statement.executeQuery("select * from Person natural join Bids where teamname like \""+teamname+"%\" order by bid_amount desc;");
            }
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public ResultSet getHighestTeamSumBid(String teamname,String year){
       try{
           if(year!=""){
                   resultSet = statement.executeQuery("select *, sum(bid_amount) as sum from Person natural join Bids where teamname like \""+teamname+"%\" and year="+year+" group by teamname order by sum desc;");
           }
           else{
                   resultSet = statement.executeQuery("select *, sum(bid_amount) as sum from Person natural join Bids where teamname like \""+teamname+"%\" group by teamname order by sum desc;");
           }
       } catch (SQLException e) {
           return null;
       }
       return resultSet;
    }

    public ResultSet getAverageBid(String teamname,String year){
       try{
           if(year!=""){
                   resultSet = statement.executeQuery("select *, avg(bid_amount) as avg from Person natural join Bids where teamname like \""+teamname+"%\" and year="+year+" group by teamname order by avg desc;");
           }
           else{
                   resultSet = statement.executeQuery("select *, avg(bid_amount) as avg from Person natural join Bids where teamname like \""+teamname+"%\" group by teamname order by avg desc;");
           }
       } catch (SQLException e) {
           return null;
       }
       return resultSet;
   }

   public ResultSet IPLDatesAndVenue(String year){
       try{
           if(year!=""){
                   resultSet = statement.executeQuery("select * from IPL natural join IPLDates where year="+year+";");
           }
           else{
                   resultSet = statement.executeQuery("select * from IPL natural join IPLDates");
           }
       } catch (SQLException e) {
           return null;
       }
       return resultSet;
   }


   public ResultSet getRetirement(String year){
       try{
           if(year!=""){
                   resultSet = statement.executeQuery("select * from Retirement natural join Person where year = "+year+" order by year;");
           }
           else{
                   resultSet = statement.executeQuery("select * from Retirement natural join Person order by year;");
           }
       } catch (SQLException e) {
           return null;
       }
       return resultSet;
   }

   public ResultSet getTrades(String year){
       try{
           if(year!=""){
                   resultSet = statement.executeQuery("select * from Trades natural join Person where year = "+year+" order by year;");
           }
           else{
                   resultSet = statement.executeQuery("select * from Trades natural join Person order by year;");
           }
       } catch (SQLException e) {
           return null;
       }
       return resultSet;
   }

   public ResultSet getReplacments(String year){
       try{
           if(year!=""){
                   resultSet = statement.executeQuery("select * from Replacements natural join Person where year = "+year+" order by year;");
           }
           else{
                   resultSet = statement.executeQuery("select * from Replacements natural join Person order by year;");
           }
       } catch (SQLException e) {
           return null;
       }
       return resultSet;
   }

   public ResultSet getTeamwiseHighestBids(String year){
       try{
           if(year!=""){
                   resultSet = statement.executeQuery("select * from Person natural join Bids, (select teamname as tname,max(bid_amount) as bid_amt from Person natural join Bids where year = "+year+" group by teamname) as a where year="+year+" and teamname=a.tname and bid_amount = a.bid_amt;");
           }
           else{
                   resultSet = statement.executeQuery("select * from Person natural join Bids, (select teamname as tname,max(bid_amount) as bid_amt from Person natural join Bids group by teamname) as a where teamname=a.tname and bid_amount = a.bid_amt;");
           }
       } catch (SQLException e) {
           return null;
       }
       return resultSet;
   }
}
