import React from 'react';
import { ItemsProp, ItemDisplay } from './interfaces';
import './items_index.css';
import normal from './assets/normal.jpeg';
import agedbrie from './assets/agedbrie.jpg';
import backstage from './assets/backstage.png';
import conjured from './assets/conjured.jpeg';
import sulfuras from './assets/sulfuras.png';

const ItemsIndex = (props: { itemsProp: ItemsProp }) => {
  const { itemsProp } = props;
  const { items } = itemsProp;

  const agedbrieDisplay: ItemDisplay = {
    image: agedbrie,
    name: "Aged Brie",
  }
  const normalDisplay: ItemDisplay = {
    image: normal,
    name: "Normal",
  }
  const backstageDisplay: ItemDisplay = {
    image: backstage,
    name: "Backstage Pass",
  }

  const conjuredDisplay: ItemDisplay = {
    image: conjured,
    name: "Conjured",
  }

  const sulfurasDisplay: ItemDisplay = {
    image: sulfuras,
    name: "Sulfuras",
  }

  const images = new Map([
    ["AgedBrie", agedbrieDisplay],
    ["BackstagePasses", backstageDisplay],
    ["Conjured", conjuredDisplay],
    ["Sulfuras", sulfurasDisplay],
    ["Normal", normalDisplay]
  ]);

  return(
    <div className="items">
      {items.length === 0 ? 
      (<div>Loading...</div>) : 
      items.map((item, index) =>
      <div key={index} className="wrapper">
        <img 
          src={images.get(item.name)?.image} 
          alt={item.name} 
          className="image" 
          />
        <div className={item.name}>
          <ul className="item">
            <li className="item-name">{images.get(item.name)?.name}</li>
            <li>Quality is {item.quality}</li>
            <li>Sell in {item.sellIn} days</li>
          </ul>
        </div>
      </div>
        )}
    </div>
  )
}

export default ItemsIndex;