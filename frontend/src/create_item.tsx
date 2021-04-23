import React, { useState } from 'react';
import { CreateItemValues, CreateItemProps } from './interfaces';
import { withRouter, RouteComponentProps } from 'react-router-dom';

const CreateItem: React.FC<CreateItemProps & RouteComponentProps> = ({ Component, history }) => {
  const [createItemValues, setCreateItemValues] = useState<CreateItemValues>({
    itemType: "",
    name: "",
    quality: null,
    sellIn: null
  })

  const handleSubmit = async (e: React.FormEvent<HTMLInputElement>) => {
    e.preventDefault();
    await fetch("/items", {
      method: 'POST',
      headers: new Headers({
        "Authorization": `Basic ${btoa(`${process.env.REACT_APP_USERNAME}:${process.env.REACT_APP_PASSWORD}`)}`,
        "Content-Type": 'application/json'
      }),
      body: JSON.stringify(createItemValues)
    });
    history.push("/");
  }

  return (
    <Component 
      createItemValues={createItemValues}
      setCreateItemValues={setCreateItemValues}
      handleSubmit={handleSubmit}
    />
  )
}

export default withRouter(CreateItem);