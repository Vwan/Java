package com.hp.struts;

public interface Action {
	String SUCCESS="success";
	String ERROR="fail";
	String execute() throws Exception;
}
