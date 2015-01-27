package github.vraptor4.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PontosTO {
	@Id
    @SequenceGenerator(name = "pontos_seq", sequenceName = "pontos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pontos_seq")
	
	private Long id;
    private String nomePoi;
    private Integer coordenadaX;
    private Integer coordenadaY;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nomePoi;
    }
 
    public void setNome(String nome) {
        this.nomePoi = nome;
    }

	public Integer getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public Integer getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

}
