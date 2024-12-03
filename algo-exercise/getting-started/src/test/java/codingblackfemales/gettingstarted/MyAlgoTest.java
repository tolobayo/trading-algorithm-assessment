package codingblackfemales.gettingstarted;

import codingblackfemales.algo.AlgoLogic;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * This test is designed to check your algo behavior in isolation of the order book.
 *
 * You can tick in market data messages by creating new versions of createTick() (ex. createTick2, createTickMore etc..)
 *
 * You should then add behaviour to your algo to respond to that market data by creating or cancelling child orders.
 *
 * When you are comfortable you algo does what you expect, then you can move on to creating the MyAlgoBackTest.
 *
 */
public class MyAlgoTest extends AbstractAlgoTest {

    @Override
    public AlgoLogic createAlgoLogic() {
        //this adds your algo logic to the container classes
        return new MyAlgoLogic();
    }

    //Creates a new order at lowest bid
    @Test
    public void testCreateOrderWithLowestBid() throws Exception {
        send(createTick());

        assertEquals(1, container.getState().getChildOrders().size());

        var order = container.getState().getChildOrders().stream().findFirst();
        assertEquals(100, order.get().getPrice());
    }
    
    //Updates order to add new low bid
    @Test
    public void testAddNewLowBid() throws Exception {
        send(createTick());
        var firstOrder = container.getState().getActiveChildOrders().stream().findFirst();
        assertEquals(100, firstOrder.get().getPrice());

        send(createTickWithLowerBids());

        var secondOrder = container.getState().getActiveChildOrders().stream().findFirst();
        assertEquals(73, secondOrder.get().getPrice());
    }
    
}
