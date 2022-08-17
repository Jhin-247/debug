package com.tuan.debugassisgnment;

public class Button {
    private int type;
    private int subType;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public Button(int type, int subType) {
        this.type = type;
        this.subType = subType;
    }

    public Button() {
    }
}
