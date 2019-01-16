package com.iot.nero.parent_system.dto.system;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午8:08
 */
public class Processor implements Serializable {
    private Integer physical;
    private Integer logical;
    private String Identifier;
    private String ProcessorID;


    public Processor() {
    }

    public Processor(Integer physical, Integer logical, String identifier, String processorID) {
        this.physical = physical;
        this.logical = logical;
        Identifier = identifier;
        ProcessorID = processorID;
    }

    public Integer getPhysical() {
        return physical;
    }

    public void setPhysical(Integer physical) {
        this.physical = physical;
    }

    public Integer getLogical() {
        return logical;
    }

    public void setLogical(Integer logical) {
        this.logical = logical;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public String getProcessorID() {
        return ProcessorID;
    }

    public void setProcessorID(String processorID) {
        ProcessorID = processorID;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "physical=" + physical +
                ", logical=" + logical +
                ", Identifier='" + Identifier + '\'' +
                ", ProcessorID='" + ProcessorID + '\'' +
                '}';
    }
}
