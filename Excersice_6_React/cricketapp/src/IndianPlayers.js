// src/IndianPlayers.js
import React from 'react';

function IndianPlayers() {
  const oddTeam = ['Rohit', 'Virat', 'KL Rahul'];
  const evenTeam = ['Gill', 'Hardik', 'Pant'];

  // Destructuring example
  const [odd1, odd2, odd3] = oddTeam;
  const [even1, even2, even3] = evenTeam;

  const T20Players = ['Rohit', 'Virat', 'Gill'];
  const RanjiPlayers = ['Pujara', 'Rahane', 'Jadeja'];

  // Merge arrays using spread operator
  const allPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        <li>{odd3}</li>
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        <li>{even3}</li>
      </ul>

      <h2>All Merged Players (T20 + Ranji)</h2>
      <ul>
        {allPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
