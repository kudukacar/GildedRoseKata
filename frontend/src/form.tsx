import React, { FormEventHandler } from 'react';
import { CreateItemValues } from './interfaces';
import './form.css';

const Form = (props: { 
  createItemValues: CreateItemValues,
  setCreateItemValues: Function,
  handleSubmit: FormEventHandler
}) => {
  const { createItemValues, setCreateItemValues, handleSubmit } = props;

  return(
    <div className="form-wrapper">
      <form onSubmit={handleSubmit} className="form">
        <div>
          <label>name:</label>
          <input
                  title="name"
                  type="text"
                  name="name"
                  value={createItemValues.name}
                  onChange={(e) => setCreateItemValues({...createItemValues, name: e.target.value})}
                  required
                />
        </div>
        <div>
          <label>item type:</label>
          <input
              title="itemType"
              type="text"
              name="item type"
              value={createItemValues.itemType}
              onChange={(e) => setCreateItemValues({...createItemValues, itemType: e.target.value})}
              required
            />
        </div>
        <div>
          <label>sell in:</label>
          <input
              title="sellIn"
              type="number"
              name="sellin"
              value={createItemValues.sellIn === null ? "" : createItemValues.sellIn}
              onChange={(e)=> setCreateItemValues({...createItemValues, sellIn: e.target.value})}
              required
            />
        </div>
        <div>
          <label>quality:</label>
          <input
              title="quality"
              type="number"
              name="quality"
              value={createItemValues.quality === null ? "" : createItemValues.quality}
              onChange={(e) => setCreateItemValues({...createItemValues, quality: e.target.value})}
              required
            />
        </div>
        <input aria-label="submit" type="submit" name="submit" value="SUBMIT"/>
      </form>
    </div>
  )
}

export default Form;