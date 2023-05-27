package jv;

import java.sql.*;

class sql {
    static Statement st;
    static ResultSet rs;
    static Connection con;

    public static void main(String args[]) {
        try {
            AfficherClients();
        } catch (Exception e) {
            System.out.println(e);
        }

//
//        try {
//           SupristionparID(10);
//        } catch (Exception e) {
//            System.out.println(e);
//        }

//      Ajouter(100, "ABDELILAH", "AIT LHAj", "06234567", "abdeli@gm", "0000");
        Ajouter(10,"simo","kabouch ","08080802","simo@gml","1111");
        try {
            AfficherClients();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medka","root", "");
            // here sonoo is database name, root is username and password
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static void Ajouter(int id, String nom, String prenom, String tel, String Email, String Pass) {
        try {
            String req = "INSERT INTO client (ID, NOM, PRENOM, TELEPHONE, EMAIL, PASS) VALUES ("
                    + id + ",'" + nom + "','" + prenom + "','" + tel + "','" + Email + "','" + Pass + "');";
                     
            con = ConnectionDB();
            st = con.createStatement();
            st.executeUpdate(req);
            System.out.println("le client est bien Ajouter");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void AfficherClients() throws SQLException {
        con = ConnectionDB();
        Statement st = con.createStatement();
        try {
            ResultSet rs = st.executeQuery("select * from client");
            while (rs.next())
                System.out.println(rs.getInt("id") + "  " + rs.getString(2) + "  " + rs.getString(3) + " "
                        + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
//            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void SupristionparID(int id) {
        try {

            String req = "DELETE FROM client WHERE id =" + id;
            con = ConnectionDB();
            st = con.createStatement();
            st.executeUpdate(req);
            System.out.println("le client est bien suprimer");
        } catch (SQLException e) {
            System.out.println(e);

        }

    }
    public static void UpdateClientparId(int id, String nom, String prenom, String tel, String Email, String Pass ){
        try{
              String str = "update client  set id="+id+" , NOM='"+nom+"' , PRENOM='"+prenom+"' , TELEPHONE='"+tel+"' , EMAIL='"+Email+"' ,PASS='"+Pass+"' WHERE id="+id+" " ; 
             Connection conn =ConnectionDB();
             Statement st=con.createStatement();
             st.executeUpdate(str);
             system.out.println(" le client est bien modifier ");
            } catch (Exception e){
           system.out.println(e);
     }
}