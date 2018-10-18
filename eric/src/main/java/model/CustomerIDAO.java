package model;

public interface CustomerIDAO {

	public CustomerBean select(String custid);
	
	public boolean update(byte[] password, String email, java.util.Date birth, String custid);
	
}
