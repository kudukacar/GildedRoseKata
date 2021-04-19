interface Item {
  sellIn: number,
  quality: number, 
  name: string
}

export interface ItemsProp {
  items: Item[]
}

export interface ItemDisplay {
  backgroundColor: string;
  image: string;
  name: string;
}