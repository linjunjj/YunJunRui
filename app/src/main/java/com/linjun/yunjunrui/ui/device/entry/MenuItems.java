package com.linjun.yunjunrui.ui.device.entry;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：
 */
public class MenuItems {
    private int icon;
    private String text;

    public MenuItems() {}

    public MenuItems(String text) {
        this.text = text;
    }

    public MenuItems(int iconId, String text) {
        this.icon = iconId;
        this.text = text;
    }

    public int getIcon() {
        return icon;

    }
    public void setIcon(int iconId) {
        this.icon = iconId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
