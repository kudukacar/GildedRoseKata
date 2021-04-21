import React, { useState } from 'react';
import Form from './form';
import { CreateItemValues } from './interfaces';
import { Redirect } from 'react-router-dom';


const CreateItem = (props: { component: typeof Form }) => {
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
        "Authorization": `Basic ${btoa(`${process.env.REACT_APP_USERNAME}:${process.env.REACT_APP_PASSWORD}`)}`
      }),
      body: JSON.stringify(createItemValues)
    });
    return <Redirect to="/" />;
  }

  return (
    <props.component 
      createItemValues={createItemValues}
      setCreateItemValues={setCreateItemValues}
      handleSubmit={handleSubmit}
    />
  )
}

export default CreateItem;