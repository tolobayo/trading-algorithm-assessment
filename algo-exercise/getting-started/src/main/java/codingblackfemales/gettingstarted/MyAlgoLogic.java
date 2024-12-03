package codingblackfemales.gettingstarted;

import codingblackfemales.action.Action;
import codingblackfemales.action.CancelChildOrder;
import codingblackfemales.action.CreateChildOrder;
import codingblackfemales.action.NoAction;
import codingblackfemales.algo.AlgoLogic;
import codingblackfemales.sotw.ChildOrder;
import codingblackfemales.sotw.SimpleAlgoState;
import codingblackfemales.sotw.marketdata.BidLevel;
import codingblackfemales.util.Util;
import messages.order.Side;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAlgoLogic implements AlgoLogic {

    private static final Logger logger = LoggerFactory.getLogger(MyAlgoLogic.class);

    @Override
    public Action evaluate(SimpleAlgoState state) {

        var orderBookAsString = Util.orderBookToString(state);

        logger.info("[MYALGO] The state of the order book is:\n" + orderBookAsString);

        /* OBJECTIVE
         * Create an algo that adds buy orders for the lowest price on market and cancels orders that are not within range of lowest bid (i.e. price is set too high above or too below lowest market rate)
         * This algo ensures bids are always within market value and set for best price
         */

        //Set bidding range
        final int BIDDING_RANGE = 3;

         //Find lowest bidding price on the market
         int lowestBidIdx = 0;
         for (int i = 0; i < state.getBidLevels(); i++) {
            final BidLevel ask = state.getBidAt(i);
            if (ask.price < state.getBidAt(lowestBidIdx).price) {
                lowestBidIdx = i;
            }
         }

         final List<ChildOrder> activeOrders = state.getActiveChildOrders();

         BidLevel lowestBid = state.getBidAt(lowestBidIdx);

         //Find active orders that match the current low
         long numLowBuyOrders = activeOrders
                        .stream()
                        .filter(order -> 
                            order.getSide().equals(Side.BUY) && 
                            order.getPrice() == lowestBid.price)
                        .count();

         //If there are no active buy orders equal to the current lowest bid, create one
         if (numLowBuyOrders == 0) {
            logger.info("[MYALGO] Adding order for " + lowestBid.quantity + " @ " + lowestBid.price);
            return new CreateChildOrder(Side.BUY, lowestBid.quantity, lowestBid.price);

        //Otherwise cancel any buy order that is not within range of lowest bid
         } else {
             for (ChildOrder option : activeOrders) {
                if (option.getSide().equals(Side.BUY)) {
                    if (option.getPrice() > (lowestBid.price + BIDDING_RANGE) ||
                        option.getPrice() < (lowestBid.price - BIDDING_RANGE)) {
                        logger.info("[MYALGO] Cancelling Order ID: " + option.getOrderId());
                        return new CancelChildOrder(option);
                    }
                }
             }
         }

        logger.info("[MYALGO] No action occured.");
        return NoAction.NoAction;
    }
}