package com.test.app.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zc on 2015/6/8.
 */
@XmlRootElement(name = "object")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Saying implements Serializable{

    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    @XmlElement(name="id")
    public long getId() {
        return id;
    }

    @JsonProperty
    @XmlElement(name="content")
    public String getContent() {
        return content;
    }
}