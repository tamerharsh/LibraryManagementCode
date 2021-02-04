import java.sql.Connection;  
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.SQLException;  
import java.sql.Statement;  
import org.omg.CORBA.AnySeqHelper;
   
public class CreateNewTable {  
   
    public static void createTable() throws ClassNotFoundException {  
        // SQLite connection string  
        String url = "jdbc:sqlite:.\\test.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n"  
                + " id integer PRIMARY KEY,\n"  
                + " name text NOT NULL,\n"  
                + " capacity real\n"  
                + ");";  
        sql="CREATE TABLE if not exists books (`BookID` VARCHAR(45) NOT NULL,`Bookname` VARCHAR(45) NULL,`Author` VARCHAR(45) NULL,`Publisher` VARCHAR(45) NULL,`PublisherDate` VARCHAR(45) NULL,`Available` VARCHAR(45) NULL,PRIMARY KEY (`BookID`));";
        
          
        try{  
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    public static void createNewDatabase() throws ClassNotFoundException{  
   
        String url = "jdbc:sqlite:.\\test.db";  
   
        try {  
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created.");  
            }  
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
    }
   private Connection connect() throws ClassNotFoundException {  
        // SQLite connection string  
        String url = "jdbc:sqlite:.\\test.db";  
        Connection conn = null;  
        try {  
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insert() throws ClassNotFoundException {  
        String sql = "INSERT INTO books(BookID, BookName,Author,Publisher,PublisherDate,Available) VALUES(2,1,1,1,1,'yes')";  
   
        try{  
            Connection conn = this.connect();  
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
//            PreparedStatement pstmt = conn.prepareStatement(sql);  
//            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) throws Exception{  
        createNewDatabase();
        createTable();  
        CreateNewTable table=new CreateNewTable();
        table.insert();
    }  
   
}  