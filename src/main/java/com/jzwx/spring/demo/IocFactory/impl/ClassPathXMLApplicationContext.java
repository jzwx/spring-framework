package main.java.com.jzwx.spring.demo.IocFactory.impl;

import main.java.com.jzwx.spring.demo.IocFactory.ApplicationContext;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import java.lang.reflect.Method;

import java.io.File;
import java.net.URL;
import java.util.*;


/**
 * @Author:jzwx
 * @Desicription: 依赖注入，控制反转(IOC,DI)
 * @Date:Created in 2018-08-31 10:05
 * @Modified By:
 */
public class ClassPathXMLApplicationContext implements ApplicationContext {

    private File file;

    private Map<String, Object> map = new HashMap<>();

    /**
     * xml配置文件读取，bean的装配
     * @param config_file
     */
    public ClassPathXMLApplicationContext(String config_file) {
        URL url = this.getClass().getClassLoader().getResource(config_file);
        try {
            /** 通过xml的文件路径,获取到xml文件 */
            file = new File(url.toURI());
            /** 读取xml文件内容,并放入到map中 */
            XMLParsing();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * bean的装配
     * @throws Exception
     */
    private void XMLParsing() throws Exception {
        /** 使用JDOM首先要指定使用什么解析器 false这表示使用的是默认的解析器 */
        SAXBuilder builder = new SAXBuilder();
        /** 获取xml文件目录数据 */
        Document doc = builder.build(file);

        /** 在jdom中用 xpath快速定位节点 */
        XPath xPath = XPath.newInstance("//bean");

        /** 将xpath定位到的所有bean节点放入list中保存起来 */
        List beans = xPath.selectNodes(doc);

        //迭代器是一种设计模式，它是一个对象，它可以遍历并选择序列中的对象，而开发人员不需要了解该序列的底层结构。迭代器通常被称为“轻量级”对象，因为创建它的代价小。
        /** 通过 Iterator迭代器遍历存有bean节点的list */
        Iterator i = beans.iterator();

        /** 进行迭代读取根节点下所有节点 */
        while (i.hasNext()) {
            /** 获取bean节点 */
            Element bean = (Element) i.next();

            /** 获取bean节点中id属性的值 */
            String id = bean.getAttributeValue("id");
            /** 获取bean节点中class属性的值 */
            String cls = bean.getAttributeValue("class");
            /** 通过bean节点中class属性的值转换成obj对象 */
            Object obj = Class.forName(cls).newInstance();
            /** 获取该obj对象中所有的方法 */
            Method[] method = obj.getClass().getDeclaredMethods();
            /** 获取bean节点下的所有property子节点 */
            List<Element> list = bean.getChildren("property");
            /** 遍历bean包含所有property子节点的list */
            for (Element el : list) {
                /** 将property子节点中的name属性值和实体类中的属性做比较,如果找到对应属性就将对应的属性附上value属性值 */
                for (int n = 0; n < method.length; n++) {
                    String name = method[n].getName();
                    String temp = null;
                    if (name.startsWith("set")) {
                        temp = name.substring(3, name.length()).toLowerCase();
                        /** 如果property属性下有name属性找到对象中对应属性赋上value值，如果没有证明是service服务接口那么通过ref反射创建这个对象到对应的service服务接口下 */
                        if (el.getAttribute("name") != null) {
                            if (temp.equals(el.getAttribute("name").getValue())) {
                                method[n].invoke(obj, el.getAttribute("value").getValue());
                            }
                        } else {
                            method[n].invoke(obj, map.get(el.getAttribute("ref").getValue()));
                        }
                    }
                }
            }
            /** 将配置文件中的对象装配到map中 */
            map.put(id, obj);
        }
    }

    /**
     * 依赖注入，获取服务需要的对象
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        return map.get(name);
    }
}
