//Criação e desenvolvimento:  Lincoln Ávila - 01/2015

package github.vraptor4.controller;

import github.vraptor4.model.entity.PontosTO;
import github.vraptor4.model.repository.PontosRepository;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
@Path("/poi")
public class PontosController {
	@Inject
    private Result result;
    @Inject
    private PontosRepository pontosRepository;
    
    public String index(HttpServletRequest req, HttpServletResponse res)
  	      throws Exception {
  	return "../index.jsp";
  }
    
    @Post
    @Path("/save")
    public void insert(PontosTO poi) {
    	pontosRepository.insertPoi(poi);
    	result.redirectTo("index");
    }
 
    @Post
    @Path("/list")
    public void listAll() {
        result.use(Results.json())
            .withoutRoot()
            .from(pontosRepository.list())
            .serialize();
    }
    
    @Post
    @Path("/listProximity")
    public void list(Integer coordenadaX, Integer coordenadaY, Integer dMax) {

        result.use(Results.json())
            .withoutRoot()
            .from(pontosRepository.listProximity(coordenadaX,coordenadaY,dMax))
            .serialize();
    }
   
    
}
