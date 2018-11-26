package com.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="Node")
public class Node {

    private String remark;

    private String value;

    public Node() {
        super();
    }

    public Node(String remark, String value) {
        super();
        this.remark = remark;
        this.value = value;
    }

    @XmlAttribute(name="Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @XmlValue
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [remark=" + remark + ", value=" + value + "]";
    }
    
}
