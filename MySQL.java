import java.sql.*;

public class MySQL extends TwitterApp {


    public void ekle(String id, String tweet, String tarih, String kullaniciIsmi, String urlAdres, int begeniSayisi, int retweetSayisi) throws SQLException {


        if(kontrolEt(id)) {

            String dbURL = "jdbc:mysql://localhost:3306/tw_test";
            String kullaniciAdi = "root";
            String sifre = "Ordulu52!*.";

            Connection dbCon = null;
            PreparedStatement stmt = null;
            int rs;

            String query = "INSERT INTO tweets VALUES (?,?,?,?,?,?,?)";
            try {

                dbCon = DriverManager.getConnection(dbURL, kullaniciAdi, sifre);

                stmt = dbCon.prepareStatement(query);
                stmt.setString(1, id);
                stmt.setString(2, tweet);
                stmt.setString(3, tarih);
                stmt.setString(4, kullaniciIsmi);
                stmt.setString(5, urlAdres);
                stmt.setInt(6, begeniSayisi);
                stmt.setInt(7, retweetSayisi);

                rs = stmt.executeUpdate();

                System.out.println("yokkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
                System.out.println("Tweet ID=" + id);
                System.out.println("Tweet Text=" + tweet);
                System.out.println("Tweet Date=" + tarih);
                System.out.println("Tweet User Name=" + kullaniciIsmi);
                System.out.println("Tweet Link=" + urlAdres);
                System.out.println("Tweet Like Count=" + begeniSayisi);
                System.out.println("Tweet Retweet Count=" + retweetSayisi);
                System.out.println("*********************************************************************************************************");


            } catch (SQLException ex) {
                System.out.println("HATA VAR!" + ex.getSQLState());
                System.out.println("HATA VAR DETAY!" + ex);
            } finally {
                dbCon.close();
                stmt.close();

            }
        }else{
            System.out.println("Var////////////////////////////////////////////////");
        }

    }

    private boolean kontrolEt(String id) throws SQLException {

        String dbURL = "jdbc:mysql://localhost:3306/tw_test";
        String kullaniciAdi = "root";
        String sifre = "Ordulu52!*.";

        Connection dbCon = null;
        Statement stmt = null;

        String query = "SELECT * FROM tweets WHERE tweet_id =('" + id + "')";

        try {

            dbCon = DriverManager.getConnection(dbURL, kullaniciAdi, sifre);
            stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) return false;

        } catch (SQLException ex) {
            System.out.println("HATA VAR!" + ex.getSQLState());
            System.out.println("HATA VAR DETAY!" + ex);
        } finally {
            dbCon.close();
            stmt.close();

        }
        return true;
    }
}