package com.pro1.UserManagementservice.handler;

public class NoEmailAndPassword extends RuntimeException {
    public NoEmailAndPassword(String s) {
    	super(s);
    }
}
