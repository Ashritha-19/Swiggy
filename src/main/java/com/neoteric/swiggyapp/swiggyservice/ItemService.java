package com.neoteric.swiggyapp.swiggyservice;

import com.neoteric.swiggyapp.swiggymodel.MenuItems;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemService {
  public   List<MenuItems> itemsList = new ArrayList<>();

    public MenuItems getItem(String name){
        for (MenuItems items : itemsList){
            if (Objects.equals(items.itemName, name)){
                return items;
            }
        }
        return null;
    }
}
