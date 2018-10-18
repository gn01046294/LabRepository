package service;

import model.CustomerBean;

public interface CustomeIService {

	CustomerBean login(String username, String password);

	boolean changePassword(String username, String oldPassword, String newPassword);

}