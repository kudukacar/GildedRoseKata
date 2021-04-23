import React, {useState, useEffect} from 'react';
import { ItemsProp, FetchItemProps } from './interfaces';

const FetchItems: React.FC<FetchItemProps> = ({ Component }) => {
  const [items, setItems] = useState<ItemsProp>({
    items: []
  });

  useEffect(() => {
    fetch("/items", {
      method: 'GET',
      headers: new Headers({
        "Authorization": `Basic ${btoa(`${process.env.REACT_APP_USERNAME}:${process.env.REACT_APP_PASSWORD}`)}`
      }),
    })
    .then(response => response.json())
    .then(items => setItems({items}));
  })

  return (
      <Component itemsProp={items}/>
  )
}

export default FetchItems;