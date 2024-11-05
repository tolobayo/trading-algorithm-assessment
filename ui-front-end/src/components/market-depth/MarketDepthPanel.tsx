import { MarketDepthRow } from "./useMarketDepthData";
import "./MarketDepthPanel.css";

import { PriceCell } from "./PriceCell";
import { QuantityCell } from "./QuantityCell";

export interface PanelRowCellProps {
  column: "ask" | "bid";
}

interface MarketDepthPanelProps {
  data: MarketDepthRow[];
}

export const MarketDepthPanel = (props: MarketDepthPanelProps) => {
  console.log({ props });

  const maxQuantity = props.data.reduce(
    (max, curr) => Math.max(max, curr.bidQuantity, curr.offerQuantity),
    -Infinity
  );
  return (
    <table className="MarketDepthPanel">
      <thead>
        <tr>
          <td colSpan={1}></td>
          <th colSpan={2} scope="col">
            Bid
          </th>
          <th colSpan={2} scope="col">
            Ask
          </th>
        </tr>
        <tr>
          <td></td>
          <th scope="col">Quantity</th>
          <th scope="col">Price</th>
          <th scope="col">Price</th>
          <th scope="col">Quantity</th>
        </tr>
      </thead>
      <tbody>
        {props.data.map((rowData) => (
          <tr>
            <td>{rowData.level}</td>
            <QuantityCell
              column={"bid"}
              quantity={rowData.bidQuantity}
              max={maxQuantity}
            />
            <PriceCell column={"bid"} price={rowData.bid} />
            <PriceCell column={"ask"} price={rowData.offer} />
            <QuantityCell
              column={"ask"}
              quantity={rowData.offerQuantity}
              max={maxQuantity}
            />
          </tr>
        ))}
      </tbody>
    </table>
  );
};
