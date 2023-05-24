package search;

import java.io.IOException;
import java.util.List;


public interface Solver {

	public List<State> solve(State initialState) throws IOException;

}
