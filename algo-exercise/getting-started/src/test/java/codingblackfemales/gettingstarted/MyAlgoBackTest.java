package codingblackfemales.gettingstarted;

import codingblackfemales.algo.AlgoLogic;
import codingblackfemales.sotw.OrderState;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This test plugs together all of the infrastructure, including the order book (which you can trade against)
 * and the market data feed.
 *
 * If your algo adds orders to the book, they will reflect in your market data coming back from the order book.
 *
 * If you cross the srpead (i.e. you BUY an order with a price which is == or > askPrice()) you will match, and receive
 * a fill back into your order from the order book (visible from the algo in the childOrders of the state object.
 *
 * If you cancel the order your child order will show the order status as cancelled in the childOrders of the state object.
 *
 */
public class MyAlgoBackTest extends AbstractAlgoBackTest {

    @Override
    public AlgoLogic createAlgoLogic() {
        return new MyAlgoLogic();
    }


    //Cancels orders that are out of range
    @Test
    public void testCancelOutOfRangeOrders() throws Exception {
       
        send(createTick());

        //Check that algo creates order for inital low bid
        var order = container.getState().getChildOrders().stream().findFirst();
        assertEquals(91, order.get().getPrice());

        //Market data adds new low bid out of bidding range
        send(createTickWithLowBidsOutOfRange());

        long numCancelled = container.getState().getChildOrders().stream().filter(option -> option.getState() == OrderState.CANCELLED).count();

        //Check that old out of range bids have been cancelled
        assertEquals(2, container.getState().getChildOrders().size());
        assertEquals(1, numCancelled);
    }

}
