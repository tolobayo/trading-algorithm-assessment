import { PanelRowCellProps } from "./MarketDepthPanelRow";
import "./QuantityCell.css";

interface QuantityCellProps extends PanelRowCellProps {
  quantity: number;
}

export const QuantityCell = (props: QuantityCellProps) => {
  return (
    <td>
      <div className={props.column === "ask" ? "AskCell" : "BidCell"}>
        {props.quantity}
      </div>
    </td>
  );
};
