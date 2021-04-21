import React, { FormEventHandler } from 'react';
import { CreateItemValues } from './interfaces';

const Form = (props: { 
  createItemValues: CreateItemValues,
  setCreateItemValues: Function,
  handleSubmit: FormEventHandler
}) => {
  const { createItemValues, setCreateItemValues, handleSubmit } = props;

  return(
    <form onSubmit={handleSubmit}>
      <label>name:
        <input
          title="name"
          type="text"
          name="name"
          value={createItemValues.name}
          onChange={(e) => setCreateItemValues({...createItemValues, name: e.target.value})}
          required
        />
      </label>
      <label>item type:
        <input
          title="itemType"
          type="text"
          name="item type"
          value={createItemValues.itemType}
          onChange={(e) => setCreateItemValues({...createItemValues, itemType: e.target.value})}
          required
        />
      </label>
      <label>sell in:
        <input
          title="sellIn"
          type="number"
          name="sellin"
          value={createItemValues.sellIn === null ? "" : createItemValues.sellIn}
          onChange={(e)=> setCreateItemValues({...createItemValues, sellIn: e.target.value})}
          required
        />
      </label>
      <label>quality:
        <input
          title="quality"
          type="number"
          name="quality"
          value={createItemValues.quality === null ? "" : createItemValues.quality}
          onChange={(e) => setCreateItemValues({...createItemValues, quality: e.target.value})}
          required
        />
      </label>
      <input aria-label="submit" type="submit" name="submit"/>
    </form>
  )
}

export default Form;