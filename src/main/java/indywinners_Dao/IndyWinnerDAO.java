package indywinners_Dao;

import java.util.List;
import indywinners.Pack.IndyWinner;

public interface IndyWinnerDAO {
	List<IndyWinner> getIndyWinners(int offset, int limit);
	int getTotalCount();
}
