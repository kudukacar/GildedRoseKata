import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Layout from './layout';
import FetchItems from './fetch_items';
import ItemsIndex from './items_index';

const App = () => {
  return (
    <BrowserRouter>
      <Layout>
        <Switch>
          <Route 
            exact path="/" 
            component={() => <FetchItems component={ItemsIndex} />}/>
        </Switch>
      </Layout>
    </BrowserRouter>
  );
}

export default App;
