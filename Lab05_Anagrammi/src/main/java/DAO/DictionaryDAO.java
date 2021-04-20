package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DictionaryDAO {

	public boolean isCorrect(String anagramma) {
		final String sql = "SELECT * FROM parola WHERE nome = '" + anagramma + "'";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				rs.close();
				st.close();
				conn.close();
				return true;
			} else {
				rs.close();
				st.close();
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
}
