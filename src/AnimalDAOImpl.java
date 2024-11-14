import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAOImpl implements AnimalDAO{
    private static final String INSERT_QUERY="insert into animals(name,species,age) values(?,?,?)";
    private static  final String RETRIVE_ALL="select* from animals";
    private static final String RETRIVE_BY_ID= "select* from animals where id=?";
    private static  final String UPDATE_BY_ID="update animals set name=? where id=?";
    private static final String DELETE_BY_ID= "delete from animals where id=?";
    @Override
    public int insertAnimal(Animal animal) {
        int x= -1;
        try{
            Connection con=ConnectorFactory.getConnection();
            PreparedStatement pstmt= con.prepareStatement(INSERT_QUERY);
            pstmt.setString(1, animal.getName());
            pstmt.setString(2, animal.getSpecies());
            pstmt.setInt(3,animal.getAge());
            x= pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return x;
    }

    @Override
    public List<Animal> getAllAnimals() {
        List<Animal> animalList = new ArrayList<>();
        try{
            Connection con= ConnectorFactory.getConnection();
            Statement stmt= con.createStatement();
            ResultSet resultSet= stmt.executeQuery(RETRIVE_ALL);
            while (resultSet.next()){
                animalList.add(new Animal(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("species"),resultSet.getInt("age") ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animalList;
    }

    @Override
    public Animal getAnimalById(int id) {
        try{
            Connection con= ConnectorFactory.getConnection();
            PreparedStatement pstmt= con.prepareStatement(RETRIVE_BY_ID);
            pstmt.setInt(1,id);
            ResultSet resultSet= pstmt.executeQuery();
            while (resultSet.next()){
                return new Animal(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("species"),resultSet.getInt("age"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public int updateAnimalById(int id, String name) {
        int rowsAffected=-1;
        try{
            Connection con= ConnectorFactory.getConnection();
            PreparedStatement pstmt= con.prepareStatement(UPDATE_BY_ID);
            pstmt.setInt(2,id);
            pstmt.setString(1,name);
             rowsAffected= pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public void deleteAnimalById(int id) {
        try{
            Connection con= ConnectorFactory.getConnection();
            PreparedStatement pstmt= con.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1,id);
            int x= pstmt.executeUpdate();
            if(x>0){
                System.out.println("The data of the animal with id: "+id+" has been deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
