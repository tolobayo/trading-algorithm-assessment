import { PanelRowCellProps } from "./MarketDepthPanel";
import "./PriceCell.css";

interface PriceCellProps extends PanelRowCellProps {
  price: number;
}

export const PriceCell = (props: PriceCellProps) => {
  return (
    <td>
      <div className={`PriceCell ${props.column === "ask" ? "reverse" : ""}`}>
        <span>^</span>
        <span>{props.price}</span>
      </div>
    </td>
  );
};
