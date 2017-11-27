import React, { Component } from 'react';
import logo from './global/images/logo.svg';
import './App.css';
import Edit from './edit/Edit';
import Show from './show/Show';
class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <div className="App-intro">
          <div className="App-block">
            <Edit />
          </div>
          <div className="App-block">
            <Show />
          </div>
        </div>
      </div>
    );
  }
}

export default App;
