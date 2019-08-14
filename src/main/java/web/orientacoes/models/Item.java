package web.orientacoes.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private int ativo;

    public Item(String nome) {
    	this.nome = nome;
    	this.ativo = 1;
    }

	public Item() {
		// TODO Auto-generated constructor stub
	}
}
