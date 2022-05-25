package com.mehmet.dao;

import com.mehmet.model.Davali;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DavaliDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession () {
        return sessionFactory.getCurrentSession();
    }


    public List<Davali> davaliListele() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Davali> criteriaQuery = criteriaBuilder.createQuery(Davali.class);
        Root<Davali> root = criteriaQuery.from(Davali.class);

        criteriaQuery.select(root);
        Query<Davali> query = currentSession.createQuery(criteriaQuery);
        List<Davali> davaliList = query.getResultList();
        return davaliList;
    }
}
