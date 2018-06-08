import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import UserProfile from './components/UserProfile';
import { BrowserRouter as Router, Route } from 'react-router-dom';

require('dotenv').config();

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <Route exact path = "/" component = {Home} />
          <Route exact path = "/users/:id" component = {UserProfile} />
        </div>
      </Router>
    );
  }
}

export default App;
