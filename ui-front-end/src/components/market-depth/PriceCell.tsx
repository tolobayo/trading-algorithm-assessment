import { PanelRowCellProps } from "./MarketDepthPanelRow";

interface PriceCellProps extends PanelRowCellProps {
  price: number;
}

export const PriceCell = (props: PriceCellProps) => {
  return <td>{props.price}</td>;
};
