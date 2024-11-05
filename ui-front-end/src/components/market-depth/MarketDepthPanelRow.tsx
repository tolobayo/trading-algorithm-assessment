import { PriceCell } from "./PriceCell";
import { QuantityCell } from "./QuantityCell";
import { MarketDepthRow } from "./useMarketDepthData";

interface MarketDepthPanelRowProps {
  data: MarketDepthRow;
}
export interface PanelRowCellProps {
  column: "ask" | "bid";
}

export const MarketDepthPanelRow = (props: MarketDepthPanelRowProps) => {
  return (
    <tr>
      <td>{props.data.level}</td>
      <QuantityCell column={"bid"} quantity={props.data.bidQuantity} />
      <PriceCell column={"bid"} price={props.data.bid} />
      <PriceCell column={"ask"} price={props.data.offer} />
      <QuantityCell column={"ask"} quantity={props.data.offerQuantity} />
    </tr>
  );
};
