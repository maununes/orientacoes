package web.orientacoes.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import web.orientacoes.models.Item;
import web.orientacoes.models.ItemRepository;

@Scope(value = "session")
@Component(value = "itemController")
@ELBeanName(value = "itemController")
@Join(path = "/item", to = "/item-form.jsf")
public class ItemController {
	@Autowired
    private ItemRepository itemRepository;
	
	private Item item = new Item();

    public String save() {
    	itemRepository.save(item);
        item = new Item();
        return "/item-list.xhtml?faces-redirect=true";
    }

    public Item getItem() {
        return item;
    }
}
