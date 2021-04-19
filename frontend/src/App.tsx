import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Layout from './layout';
import FetchItems from './fetch_items';

const App = () => {
  return (
    <BrowserRouter>
      <Layout>
        <Switch>
          <Route exact path="/" component={FetchItems}/>
        </Switch>
      </Layout>
    </BrowserRouter>
  );
}

export default App;
