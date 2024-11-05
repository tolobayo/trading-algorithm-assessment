import { PanelRowCellProps } from "./MarketDepthPanelRow";

interface QuantityCellProps extends PanelRowCellProps {
  quantity: number;
}

export const QuantityCell = (props: QuantityCellProps) => {
  return <td>{props.quantity}</td>;
};
