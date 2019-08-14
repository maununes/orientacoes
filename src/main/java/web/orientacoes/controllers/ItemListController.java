package web.orientacoes.controllers;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import web.orientacoes.models.Item;
import web.orientacoes.models.ItemRepository;

@Scope (value = "session")
@Component (value = "productList")
@ELBeanName(value = "productList")
@Join(path = "/", to = "/product-list.jsf")
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
        return items;
    }
}
