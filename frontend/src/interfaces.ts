import { ComponentProps, ComponentPropsWithRef } from "react";
import { RouteComponentProps } from "react-router";

interface Item {
  sellIn: number,
  quality: number, 
  name: string
}

export interface ItemsProp {
  items: Item[]
}

export interface ItemDisplay {
  image: string;
  name: string;
}

export interface CreateItemValues {
  itemType: string,
  name: string,
  quality: number | null,
  sellIn: number | null
}