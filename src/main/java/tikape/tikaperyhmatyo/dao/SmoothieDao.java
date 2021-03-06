
package tikape.tikaperyhmatyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.tikaperyhmatyo.db.Database;
import tikape.tikaperyhmatyo.domain.Ingredient;
import tikape.tikaperyhmatyo.domain.Smoothie;
import tikape.tikaperyhmatyo.domain.SmoothieIngredient;

public class SmoothieDao implements Dao<Smoothie, Integer> {
    private Database db;
    private IngredientDao iDao;
    private SmoothieIngredientDao siDao;
    
    public SmoothieDao(Database db) {
        this.db = db;
        this.iDao = new IngredientDao(this.db);
        this.siDao = new SmoothieIngredientDao(this.db);
    }

    @Override
    public Smoothie findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Smoothie> findAll() throws SQLException {
        List<Smoothie> smoothies = new ArrayList<>();
        
        try (Connection connection = this.db.getConnection()) {
            ResultSet rs = connection.prepareStatement("SELECT id, name FROM Smoothie").executeQuery();
            while (rs.next()) {
                List<Ingredient> ingredients = iDao.findAll();
                List<SmoothieIngredient> smoothieIngredients = siDao.findAll();
                smoothies.add(new Smoothie(rs.getInt("id"), rs.getString("name")));
            }
        }
        
        return smoothies; 
    }

    @Override
    public Smoothie saveOrUpdate(Smoothie object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
