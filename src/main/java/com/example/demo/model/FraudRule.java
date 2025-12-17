package com.example.demo.model;

public class FraudRule {
    private long id;
    private String ruleCode;
    private String description;
    private String ruleType;
    private Boolean active;

    public FraudRule() {}

    public FraudRule(String ruleCode,String description,String ruleType,Boolean active) {
        this.ruleCode=ruleCode;
        this.description=description;
        this.ruleType=ruleType;
        this.active=active;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public String getRuleType() {
        return ruleType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
