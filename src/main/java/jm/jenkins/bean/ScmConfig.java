package jm.jenkins.bean;

import org.dom4j.Element;

public abstract class ScmConfig {

    private String address;

    public abstract Element getXmlContent();

    public ScmConfig(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
