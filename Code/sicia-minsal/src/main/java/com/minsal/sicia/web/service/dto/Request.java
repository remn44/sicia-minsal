package com.minsal.sicia.web.service.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;
	private String description;

	public Request() {

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
