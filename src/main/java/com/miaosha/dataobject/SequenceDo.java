package com.miaosha.dataobject;

public class SequenceDo {
    private String name;

    private Integer currentValue;

    private Integer step;

    public SequenceDo(String name, Integer currentValue, Integer step) {
        this.name = name;
        this.currentValue = currentValue;
        this.step = step;
    }

    public SequenceDo() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }
}