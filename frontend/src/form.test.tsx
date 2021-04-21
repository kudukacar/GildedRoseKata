import React from 'react';
import Form from './form';
import { CreateItemValues } from './interfaces';
import { render, fireEvent } from '@testing-library/react';

class FormValues {
  itemValues: CreateItemValues;
  submitted: boolean;

  constructor() {
    this.itemValues = {
      itemType: "",
      name: "",
      quality: 0,
      sellIn: 0
    },
    this.submitted = false;
  }

  setCreateItemValues = (createItemValues: CreateItemValues) => {
    this.itemValues = createItemValues;
  }

  handleSubmit = (e: React.FormEvent<HTMLInputElement>) => {
    e.preventDefault();
    this.submitted = true;
  }
}

test('records the items name', () => {
  const formValues = new FormValues();
  const { getByTitle } = render(
    <Form 
      createItemValues={formValues.itemValues} 
      setCreateItemValues={formValues.setCreateItemValues} 
      handleSubmit={formValues.handleSubmit}
    />)
  const input = getByTitle('name');
  fireEvent.change(input, { target: { value: 'Potato' }})
  expect(formValues.itemValues.name).toBe('Potato')
})

test('records the items item type', () => {
  const formValues = new FormValues();
  const { getByTitle } = render(
    <Form 
      createItemValues={formValues.itemValues} 
      setCreateItemValues={formValues.setCreateItemValues} 
      handleSubmit={formValues.handleSubmit}
    />)
  const input = getByTitle('itemType');
  fireEvent.change(input, { target: { value: 'Normal' }})
  expect(formValues.itemValues.itemType).toBe('Normal')
})

test('records the items sell in', () => {
  const formValues = new FormValues();
  const { getByTitle } = render(
    <Form 
      createItemValues={formValues.itemValues} 
      setCreateItemValues={formValues.setCreateItemValues} 
      handleSubmit={formValues.handleSubmit}
    />)
  const input = getByTitle('sellIn');
  fireEvent.change(input, { target: { value: 10 }})
  expect(formValues.itemValues.sellIn).toBe("10")
})

test('records the items quality', () => {
  const formValues = new FormValues();
  const { getByTitle } = render(
    <Form 
      createItemValues={formValues.itemValues} 
      setCreateItemValues={formValues.setCreateItemValues} 
      handleSubmit={formValues.handleSubmit}
    />)
  const input = getByTitle('quality');
  fireEvent.change(input, { target: { value: 10 }})
  expect(formValues.itemValues.quality).toBe("10")
})

test("executes a function upon submit", () => {
  const formValues = new FormValues();
  const { getByLabelText} = render(
    <Form 
      createItemValues={formValues.itemValues} 
      setCreateItemValues={formValues.setCreateItemValues} 
      handleSubmit={formValues.handleSubmit}
    />)
  fireEvent.click(getByLabelText("submit"));
  expect(formValues.submitted).toBe(true);
});