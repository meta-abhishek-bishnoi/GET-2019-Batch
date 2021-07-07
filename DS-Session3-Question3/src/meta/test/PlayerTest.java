/**
 * @author Abhishek Bishnoi
 * @since Aug 2, 2019
 * This is Contains Test Cases Of Problem
 */
package meta.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import meta.utility.Player;
import meta.utility.Service;

public class PlayerTest {

	@Test
	public void getBowlerTestOne_HappyFlow() {
		List<Integer> expected = Arrays.asList(new Integer[]{4, 2, 4, 2, 4, 1, 2, 3, 4, 1, 2 });
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(4,4));
		players.add(new Player(2,4));
		players.add(new Player(3,1));
		players.add(new Player(1,2));
		List<Integer> actual = Service.getBowlerSequence(4, players);
		assertEquals(expected, actual);
	}

	@Test
	public void getBowlerTestTwo_HappyFlow() {
		List<Integer> expected = Arrays.asList(new Integer[]{11, 11, 1, 11, 2, 1, 11  });
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(1,2));
		players.add(new Player(11,4));
		players.add(new Player(2,1));
		List<Integer> actual = Service.getBowlerSequence(4, players);
		assertEquals(expected, actual);
	}
	
	@Test(expected = AssertionError.class)
	public void getBowlerTest_Exception_WhenListIsNull(){
		List<Integer> expected = Arrays.asList(new Integer[]{});
		List<Player> players = null;
		List<Integer> actual = Service.getBowlerSequence(4, players);
		assertEquals(expected, actual);
	}
	
	@Test (expected = AssertionError.class)
	public void getBowlerTest_Exception_WhenPlayerIsNull(){
		List<Integer> expected = Arrays.asList(new Integer[]{ });
		List<Player> players = new ArrayList<Player>();
		players.add(null);
		players.add(new Player(1,2));
		List<Integer> actual = Service.getBowlerSequence(4, players);
		assertEquals(expected, actual);
	}
	
}
