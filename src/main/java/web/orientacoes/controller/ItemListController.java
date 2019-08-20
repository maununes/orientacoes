package web.orientacoes.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import web.orientacoes.model.Item;
import web.orientacoes.model.ItemRepository;

@Scope (value = "session")
@Component (value = "itemListController")
@ELBeanName(value = "itemListController")
@Join(path = "/", to = "/item-list.jsf")
public class ItemListController {
    @Autowired
    private ItemRepository itemRepository;

    private List<Item> items;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
    	items = itemRepository.findAll();
    }

    public List<Item> getItems() {
    	items = itemRepository.findAll();
        return items;
    }
}
