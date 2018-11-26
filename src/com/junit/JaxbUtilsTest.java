package com.junit;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.bean.Node;
import com.bean.Root;
import com.bean.Student;
import com.util.JaxbUtils;

public class JaxbUtilsTest {
    
    
    @Test
    public void testXmlToBean() {
        String xmlstr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<Root>"
                + "<BasicNode><Node Remark=\"文件编号\">123</Node><Node Remark=\"证照名称\">aaa</Node></BasicNode>"
                + "<ExtendNode><Node Remark=\"证照废止列表地址\">abolishedurl</Node><Node Remark=\"证照在线查询地址\">queryurl</Node></ExtendNode>"
                + "</Root>";
        Root root = JaxbUtils.xmlToBean(xmlstr, Root.class);
        System.out.println(root);
    }
    
    @Test
    public void testBeanToXml2() {
        Node node1 = new Node("文件编号", "123");
        Node node2 = new Node("证照名称", "aaa");
        Node node3 = new Node("证照废止列表地址", "abolishedurl");
        Node node4 = new Node("证照在线查询地址", "queryurl");
        
        List<Node> basicNode = new ArrayList<>();
        basicNode.add(node1);
        basicNode.add(node2);
        
        List<Node> extendNode = new ArrayList<>();
        extendNode.add(node3);
        extendNode.add(node4);
        
        Root root = new Root();
        root.setBasicNode(basicNode);
        root.setExtendNode(extendNode);
        
        String result = JaxbUtils.beanToXml(root, Root.class);
        System.out.println(result);
    }
    
    @Test
    public void testBeanToXml() {
        Student student = new Student();
        student.setNumber("1001");
        student.setName("张飞");
        student.setSex("男");
        String result = JaxbUtils.beanToXml(student, Student.class);
        System.out.println(result);
    }
}
