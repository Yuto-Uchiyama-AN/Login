package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Customer;

public class CustomerDAO extends DAO {

	public Customer search(int id, String password)
		throws Exception{
		Customer customer=null;

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
				"select * flom customer where id=? and password=?");
		st.setInt(1, id);
		st.setString(2, password);
		ResultSet rs =st.executeQuery();

		while(rs.next()) {
			customer=new Customer();
			customer.setId(rs.getInt("id"));
			customer.setPassword(rs.getString("password"));

		}
		st.close();
		con.close();
		return customer;
	}

}
