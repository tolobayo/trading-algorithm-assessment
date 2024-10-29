package codingblackfemales.gettingstarted;

import codingblackfemales.action.Action;
import codingblackfemales.action.NoAction;
import codingblackfemales.algo.AlgoLogic;
import codingblackfemales.sotw.ChildOrder;
import codingblackfemales.sotw.SimpleAlgoState;
import codingblackfemales.sotw.marketdata.AskLevel;
import codingblackfemales.util.Util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAlgoLogic implements AlgoLogic {

    private static final Logger logger = LoggerFactory.getLogger(MyAlgoLogic.class);

    @Override
    public Action evaluate(SimpleAlgoState state) {

        var orderBookAsString = Util.orderBookToString(state);

        logger.info("[MYALGO] The state of the order book is:\n" + orderBookAsString);

        //TODO: Adapt this to only buy for historically low prices

        /* OBJECTIVE
         * Create buy orders for the lowest price on market
         * 
         * STEPS
         * 1. Find lowest ask price on the market
         * 2. Check active orders to see if prices are lower or higher
         * 3. If prices are higher cancel current active orders and create new    order w/ low price
         *
         * QUESTIONS
         * How are we meant to implement the logic for when to create and cancel an order, what are the contrainsts?
         * Can you only have one active child order at a time?
         * Do we need to set a limit for how many orders we can have at once?
         * What is the difference between a child order and an active child order?
         */

         //

         //Find lowest price on the market
        //  int lowestAskIdx = 0;
        //  for (int i = 0; i < state.getAskLevels(); i++) {
        //     final AskLevel ask = state.getAskAt(i);
        //     if (ask.price < state.getAskAt(lowestAskIdx).price) {
        //         lowestAskIdx = i;
        //     }
        //  }
        //  final List<ChildOrder> activeOrders = state.getActiveChildOrders();
        //  for (ChildOrder option : activeOrders) {
        //     if (option.getSide().equals(Side.BUY))

        //  }



         

         logger.info("[MYALGO] The current bid levels is: " + state.getBidLevels());
         logger.info("[MYALGO] The current ask levels is: " + state.getAskLevels());

        return NoAction.NoAction;
    }
}