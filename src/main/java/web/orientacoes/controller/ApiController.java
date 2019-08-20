package web.orientacoes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import web.orientacoes.model.Item;
import web.orientacoes.model.ItemRepository;

@Scope(value = "session")
@RestController
public class ApiController {
	
	@Autowired
    private ItemRepository itemRepository;
	
	@RequestMapping("/list")
	public String list() throws JsonProcessingException { 
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonString = mapper.writeValueAsString(this.itemRepository.findAll());
		return jsonString;
	}
	
	@RequestMapping("/remove/{id}")
	public String add(@PathVariable("id") Long id) throws JsonProcessingException { 
		itemRepository.deleteById(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonString = mapper.writeValueAsString(this.itemRepository.findAll());
		return jsonString;
	}
	
	@RequestMapping("/add/{todo}")
	public String add(@PathVariable("todo") String todo) throws JsonProcessingException { 
		Item item = new Item(todo);
		itemRepository.save(item);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonString = mapper.writeValueAsString(this.itemRepository.findAll());
		return jsonString;
	}
	
	@JsonSerialize
	@RequestMapping("/inativa/{id}")
	public String inativa(@PathVariable("id") Long id) throws JsonProcessingException { 
		
		Item item = itemRepository.getOne(id);
		item.setAtivo(0);
		itemRepository.save(item);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonString = mapper.writeValueAsString(this.itemRepository.findAll());
		return jsonString;
	}
	
	@JsonSerialize
	@RequestMapping("/ativa/{id}")
	public String ativa(@PathVariable("id") Long id) throws JsonProcessingException { 
		
		Item item = itemRepository.getOne(id);
		item.setAtivo(1);
		itemRepository.save(item);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonString = mapper.writeValueAsString(this.itemRepository.findAll());
		return jsonString;
	}
	
}	
