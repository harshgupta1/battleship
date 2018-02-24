package com.pb.game.battleship;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ShipTypeTest {

	@Test
	public void Should_ReturnValidShipTypes_When_Instantiated(){
		List<String> actualShipTypes = Stream.of(ShipType.values()).map(Enum::name).collect(Collectors.toList());
		assertThat(actualShipTypes, containsInAnyOrder("P","Q"));
	}
	
	@Test
	public void Should_ReturnValidShipPower_When_Instantiated(){
		assertThat(ShipType.valueOf("P").getStrength(), is(1));
		assertThat(ShipType.valueOf("Q").getStrength(), is(2));
	}
}
