import { MarketDepthPanelRow } from "./MarketDepthPanelRow";
import { MarketDepthRow } from "./useMarketDepthData";
import "./MarketDepthPanel.css";

interface MarketDepthPanelProps {
  data: MarketDepthRow[];
}

export const MarketDepthPanel = (props: MarketDepthPanelProps) => {
  console.log({ props });
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
          <MarketDepthPanelRow data={rowData} />
        ))}
      </tbody>
    </table>
  );
};
