package indywinners_Dao;

import indywinners.Pack.IndyWinner;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;



public class Dao_Indy_Implementation implements IndyWinnerDAO {
	private static final String DatabaseUrl = "jdbc:mysql://localhost:3306/indywinners?useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection (DatabaseUrl, USER, PASS);
	}

	@Override
	public List<IndyWinner> getIndyWinners(int offset, int limit) {
		List<IndyWinner> winners = new ArrayList<>();
		String sql = "SELECT * FROM indywinners ORDER BY year DESC LIMIT ? OFFSET ?";
		
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, limit);
			stmt.setInt(2, offset);
			
			try (ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					IndyWinner winner = new IndyWinner(
							rs.getInt("YEAR"),
							rs.getString("DRIVER"),
							rs.getDouble("AVERAGESPEED"),
							rs.getString("COUNTRY")
							);
					winners.add(winner);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return winners;
	}

	@Override
	public int getTotalCount() {
		String sql = "SELECT COUNT(*) AS Total FROM indywinners";
		int count = 0;
		
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()) {
			
			if (rs.next()) {
				count = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	

}
