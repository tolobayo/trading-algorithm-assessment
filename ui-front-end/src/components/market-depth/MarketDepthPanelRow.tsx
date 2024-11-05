import { MarketDepthRow } from "./useMarketDepthData";

interface MarketDepthPanelRowProps {
  data: MarketDepthRow;
}

export const MarketDepthPanelRow = (props: MarketDepthPanelRowProps) => {
  return <tr>{props.data.bidQuantity}</tr>;
};
