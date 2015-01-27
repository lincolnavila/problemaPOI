package github.vraptor4.controller;

import java.lang.ProcessBuilder.Redirect;

import github.vraptor4.model.entity.PontosTO;
import github.vraptor4.model.repository.PontosRepository;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
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
 
    @Get
    @Path("/list")
    public void listAll() {
        result.use(Results.json())
            .withoutRoot()
            .from(pontosRepository.list())
            .serialize();
    }
    
    @Post
    @Path("/save")
    public void insert(PontosTO poi) {
    	pontosRepository.insertPoi(poi);
    	result.redirectTo("index.jsp");
    }
   
    
    public String index(HttpServletRequest req, HttpServletResponse res)
    	      throws Exception {
    	return "../index.jsp";
    }
    
    
    
}
