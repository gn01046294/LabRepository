package service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CustomerBean;
import model.CustomerIDAO;

@Service
public class CustomerService implements CustomeIService {
	
	@Autowired
	private CustomerIDAO customerIDAO;

	public CustomerService(CustomerIDAO customerIDAO) {
		this.customerIDAO = customerIDAO;
	}

	@Override
	public CustomerBean login(String username, String password) {
		CustomerBean cb = customerIDAO.select(username);
		if (cb != null) {
			if (password != null && password.length() != 0) {
				byte[] pwd = cb.getPassword();
				byte[] temp = password.getBytes();
				if (Arrays.equals(pwd, temp)) {
					return cb;
				}
			}
		}
		return null;
	}

	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		CustomerBean bean = this.login(username, oldPassword);
		if (bean != null) {
			byte[] temp = newPassword.getBytes();
			return customerIDAO.update(temp, bean.getEmail(), bean.getBirth(), username);
		}
		return false;
	}
}
