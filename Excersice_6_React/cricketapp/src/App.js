// src/App.js
import React from 'react';
import ListOfPlayers from './ListOfPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
  const flag = true; // Toggle this to false to test the second component

  return (
    <div className="App" style={{ textAlign: 'center' }}>
      <h1>Cricket App</h1>
      {flag ? <ListOfPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
