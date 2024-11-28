package com.ensta.myfilmlist.dao.impl;
import com.ensta.myfilmlist.dao.RealisateurDAO;
import com.ensta.myfilmlist.model.Realisateur;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

public class JdbcRealisateurDAO implements RealisateurDAO{

    /*
    DAO = data access object
    Contient toute le tableau des réalisateurs
     */

    // attributs
    private JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

    // methodes
    @Override
    public List<Realisateur> findall(){
        String sql = "SELECT * FROM realisateur";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Realisateur.class));
    }
    // attention : si le nom des colonnes est different il va falloir adapter le mapper
    @Override
    public Realisateur findByNomAndPrenom(String nom, String prenom){
        String sql = "SELECT * FROM realisateur WHERE nom = ? AND prenom = ?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{nom, prenom},
                    new BeanPropertyRowMapper<>(Realisateur.class)
            );
        } catch (EmptyResultDataAccessException e) {
            // Si aucun réalisateur n'est trouvé, on retourne null
            return null;
        }
    }
    @Override
    public Optional<Realisateur> findById(long id) {
        String sql = "SELECT * FROM realisateur WHERE id = ?";
        List<Realisateur> results = jdbcTemplate.query(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Realisateur.class)
        );

        // Si aucun résultat n'est trouvé, on retourne un Optional vide
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }


}
