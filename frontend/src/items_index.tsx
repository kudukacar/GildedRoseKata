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
    backgroundColor: "#DAD6FA",
    image: agedbrie,
    name: "Aged Brie",
  }
  const normalDisplay: ItemDisplay = {
    backgroundColor: "#ED9C19",
    image: normal,
    name: "Normal",
  }
  const backstageDisplay: ItemDisplay = {
    backgroundColor: "#FFEDED",
    image: backstage,
    name: "Backstage Pass",
  }

  const conjuredDisplay: ItemDisplay = {
    backgroundColor: "#82C1DF",
    image: conjured,
    name: "Conjured",
  }

  const sulfurasDisplay: ItemDisplay = {
    backgroundColor: "#D7E447",
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
        <ul className="item" style={{backgroundColor: images.get(item.name)?.backgroundColor}}>
          <li className="item-name">{images.get(item.name)?.name}</li>
          <li>Quality is {item.quality}</li>
          <li>Sell in {item.sellIn} days</li>
        </ul>
      </div>
        )}
    </div>
  )
}

export default ItemsIndex;