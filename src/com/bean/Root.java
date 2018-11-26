package com.bean;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Root")
public class Root {

    private List<Node> basicNode;

    private List<Node> extendNode;
    
    public List<Node> getBasicNode() {
        return basicNode;
    }

    @XmlElementWrapper(name = "BasicNode")
    @XmlElement(name = "Node")
    public void setBasicNode(List<Node> basicNode) {
        this.basicNode = basicNode;
    }

    public List<Node> getExtendNode() {
        return extendNode;
    }

    @XmlElementWrapper(name = "ExtendNode")
    @XmlElement(name = "Node")
    public void setExtendNode(List<Node> extendNode) {
        this.extendNode = extendNode;
    }

    @Override
    public String toString() {
        return "Root [basicNode=" + basicNode + ", extendNode=" + extendNode + "]";
    }

}
