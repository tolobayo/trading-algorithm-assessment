import { PanelRowCellProps } from "./MarketDepthPanel";
import "./QuantityCell.css";

interface QuantityCellProps extends PanelRowCellProps {
  quantity: number;
  max: number;
}

export const QuantityCell = (props: QuantityCellProps) => {
  console.log(props.max);
  return (
    <td>
      <div
        className={props.column === "ask" ? "AskCell" : "BidCell"}
        style={{
          width: `${(props.quantity / props.max) * 100}%`,
        }}
      >
        {props.quantity}
      </div>
    </td>
  );
};
