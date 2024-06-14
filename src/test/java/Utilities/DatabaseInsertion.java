package Utilities;

import alchemy_Pages.Client_Dashboards;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.*;
import java.util.Properties;

public class DatabaseInsertion extends BaseClass {

//    public void testConnection() {
//
//        int localPort = 5432;
//        String dbName = "0523_r09_qa";
//        String dbUser = "plastic_bank";
//        String dbPassword = "93ijFZYypmCSyWHmFXSw";
//        Connection connection = null;
//
//        try {
//            // Connect to the PostgreSQL database
//            String url = "jdbc:postgresql://localhost:" + localPort + "/" + dbName;
//            System.out.println("Connecting to database with URL: " + url);
//            connection = DriverManager.getConnection(url, dbUser, dbPassword);
//            System.out.println("Connected to the database successfully!");
//
//            // Insert data into the database using a prepared statement
//            String sql = "INSERT INTO dashboard_mock (dashboard_id) VALUES (?)"; // Update table name and values as needed
//            PreparedStatement pstmt = connection.prepareStatement(sql);
//            pstmt.setString(1, Client_Dashboards.dashboardId);
//            pstmt.executeUpdate();
//            pstmt.close();
//            System.out.println("Data inserted successfully");
//
//        } catch (SQLException e) {
//            System.err.println("SQL Exception occurred: " + e.getMessage());
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println("Unexpected Exception occurred: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            // Clean up
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.err.println("Error while closing the connection: " + e.getMessage());
//                    e.printStackTrace();
//                }
//            }
//        }

    public void testConnection2() throws InterruptedException {

        String sshHost = "185.83.122.7";
        int sshPort = 54322;
        String sshUser = "ansible";
        String sshPassword = "ans3v3#";

        String remoteHost = "10.123.9.11";
        int remotePort = 5432;
        int localPort = 65432; // Use a different local port

        String dbName = "0523_r09_qa";
        String dbUser = "plastic_bank";
        String dbPassword = "93ijFZYypmCSyWHmFXSw";

        Session session = null;
        Connection connection = null;

        try {
            // Set up the SSH tunnel
            JSch jsch = new JSch();
            session = jsch.getSession(sshUser, sshHost, sshPort);
            session.setPassword(sshPassword);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();

            session.setPortForwardingL(localPort, remoteHost, remotePort);

            // Connect to the PostgreSQL database
            String url = "jdbc:postgresql://localhost:" + localPort + "/" + dbName;
            connection = DriverManager.getConnection(url, dbUser, dbPassword);

            // Do something with the connection
            System.out.println("Connected to the database successfully!");

            // Insert data into the database
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO dashboard_mock (dashboard_id) VALUES ('"+ Client_Dashboards.dashboardId +"');"; // Update table name and values as needed
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Data inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }
    }
