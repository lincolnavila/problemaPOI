//Criação e desenvolvimento:  Lincoln Ávila - 01/2015

package github.vraptor4.model.repository;

import github.vraptor4.model.entity.PontosTO;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

@RequestScoped
public class PontosRepository {
	@Inject
    private Session session;
 
	//Método para listar todos
	//Hibernate ja traz a lista completa por meio do projectionList(), então especifica-se os atributos que necessita pelo Projections.property
	
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
    
    //Método para listar por proximidade
    /* Nesse método foi utilizado a listaCompleta que o hibernate traz também, para poder percorrê-la,
       e fazer a regra da distância com os valores que o usuário digitou, após isso é criado uma Lista de Strings para armazenar o retorno. */
    
    @SuppressWarnings("unchecked")
    public List<String> listProximity(Integer coordenadaX, Integer coordenadaY, Integer dMax) {
    	
    	
    	Criteria cr = session.createCriteria(PontosTO.class)
    			
    		    .setProjection(Projections.projectionList()
	    		.add(Projections.property("nomePoi"), "nomePoi")
    		    .add(Projections.property("coordenadaX"), "coordenadaX")
    		    .add(Projections.property("coordenadaY"), "coordenadaY")		
    		    )
    		    .setResultTransformer(Transformers.aliasToBean(PontosTO.class));

    		  List<PontosTO> listaCompleta = cr.list();
    		  List<String> retorno = new ArrayList<String>(); 
    		  
    		  for (int i = 0; i < listaCompleta.size(); i++) {		  
    			  double valor = Math.sqrt(Math.pow((listaCompleta.get(i).getCoordenadaX() - coordenadaX),2) + Math.pow((listaCompleta.get(i).getCoordenadaY() - coordenadaY),2));
    			  if(valor <= dMax) {
    				 retorno.add(listaCompleta.get(i).getNome());
    				  
    			  }
   
    		  }		  
    		  return retorno;
    }
    
    /*No cadastro o hibernate utiliza essa forma bem simples de salvar, onde ele faz o save automatico no banco*/
    public void insertPoi(PontosTO poi) {
        session.save(poi);
      }
    
}
