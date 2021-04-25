package org.dealoftheday.admin.menu;

import java.io.Serializable;

public class MenuManager implements Serializable {

    private static final long serialVersionUID = -1L;

    private MenuItem menuData;

    public void setMenuData(MenuItem menuData) {
        this.menuData = menuData;
    }

    public MenuItem getMenuData() {
        return menuData;
    }

}
