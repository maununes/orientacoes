package web.orientacoes.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import web.orientacoes.model.Item;
import web.orientacoes.model.ItemRepository;

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
        System.out.println("ItemController save");
        return "/item-list.xhtml?faces-redirect=true";
    }

    public Item getItem() {
        return item;
    }
}
