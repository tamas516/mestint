package search;

import java.io.IOException;
import java.lang.Iterable;


public interface State {

	public Iterable<State> getPossibleMoves() throws IOException;
	
	public boolean isSolution();
	
	public double getHeuristic();
	
	public double getDistance();
	
	public State getParent();
}
