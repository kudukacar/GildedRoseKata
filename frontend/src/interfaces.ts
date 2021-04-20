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