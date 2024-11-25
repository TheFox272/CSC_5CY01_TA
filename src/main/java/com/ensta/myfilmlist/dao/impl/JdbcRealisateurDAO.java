package com.ensta.myfilmlist.dao.impl;
import com.ensta.myfilmlist.dao.RealisateurDAO;
import com.ensta.myfilmlist.model.Realisateur;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import java.util.Optional;
import java.util.ArrayList;

public class JdbcRealisateurDAO implements RealisateurDAO{

    /*
    DAO = data access object
    Contient toute le tableau des réalisateurs
     */

    // attributs

    private DataSource dataSource = ConnectionManager.getDataSource();

    // methodes
    // est ce que on doit faire des sql exceptions ?
    @Override
    public List<Realisateur> findall(){
        return null;
    }
    @Override
    public Realisateur findByNomAndPrenom(String nom, String prenom){
        return null;
    }
    @Override
    public Optional<Realisateur> findById(long id){
        return null;
    }


}
