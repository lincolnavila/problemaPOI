package github.vraptor4.model.repository;

import github.vraptor4.model.entity.PontosTO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

@RequestScoped
public class PontosRepository {
	@Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(PontosTO.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<PontosTO> list() {
    	Criteria cr = session.createCriteria(PontosTO.class)
    		    .setProjection(Projections.projectionList()
    		      .add(Projections.property("nomePoi"), "nomePoi")
    		      .add(Projections.property("coordenadaX"), "coordenadaX")
    		      .add(Projections.property("coordenadaY"), "coordenadaY")
    		    )
    		    .setResultTransformer(Transformers.aliasToBean(PontosTO.class));

    		  List<PontosTO> list = cr.list();
    		  return list;
    }
    
    /*public void insertPoi(PontosTO poi) {
    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();

    	session.save(ponto);
    	tx.commit();
    	session.close();
    }*/
    
    public void insertPoi(PontosTO poi) {
        session.save(poi);
      }
    
    
    
    
    
    
}
