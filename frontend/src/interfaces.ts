import Form from './form';
import ItemsIndex from './items_index';

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

export interface CreateItemProps {
  Component: typeof Form
}

export interface FetchItemProps {
  Component: typeof ItemsIndex
}