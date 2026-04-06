import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Product implements Comparable<Product>{
    private int id ;
    private String name;
    private double price;

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Product(int id , String name , double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price , other.price);
    }

    public static void main(String[] args) {
        DAO<Product> dao = new mysqlProductDAO();
        List<Product> products = dao.getAll();
        for (Product product : products){
            System.out.println("ID : " + product.getId() + "Name : " + product.getName() + "Price : " + product.getPrice());
        }
    }
}
class ConnectFactory {
    private static String URl = "jdbc:mysql://localhost:3306/product_db";
    private static String USERNAME = "root";
    private static String PASSWORD = "pass";

    public static Connection getConnection() throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URl, USERNAME, PASSWORD);
        }catch(Exception err){
        throw new Exception(err);
    }
}}

interface DAO<T>{
    public List<T> getAll();
}
class mysqlProductDAO implements DAO<Product>{
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from products";
        try(Connection conn = ConnectFactory.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                products.add(new Product(rs.getInt("id"),rs.getString("name"),rs.getDouble("price")));
            }
            return  products;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}