// src/CountPeople.js
import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0
    };
  }

  updateEntry = () => {
    this.setState(prevState => ({
      entryCount: prevState.entryCount + 1
    }));
  };

  updateExit = () => {
    this.setState(prevState => ({
      exitCount: prevState.exitCount + 1
    }));
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1>Mall Entry/Exit Counter</h1>
        <p><strong>People Entered:</strong> {this.state.entryCount}</p>
        <p><strong>People Exited:</strong> {this.state.exitCount}</p>
        <button onClick={this.updateEntry} style={{ margin: '10px', padding: '10px' }}>Login</button>
        <button onClick={this.updateExit} style={{ margin: '10px', padding: '10px' }}>Exit</button>
      </div>
    );
  }
}

export default CountPeople;
