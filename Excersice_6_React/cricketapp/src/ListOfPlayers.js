// src/ListOfPlayers.js
import React from 'react';

function ListOfPlayers() {
  const players = [
    { name: 'Rohit', score: 80 },
    { name: 'Virat', score: 60 },
    { name: 'KL Rahul', score: 45 },
    { name: 'Gill', score: 90 },
    { name: 'Hardik', score: 30 },
    { name: 'Pant', score: 75 },
    { name: 'Jadeja', score: 50 },
    { name: 'Ashwin', score: 88 },
    { name: 'Bumrah', score: 20 },
    { name: 'Shami', score: 68 },
    { name: 'Siraj', score: 85 }
  ];

  const highScorers = players.map((player, index) => (
    <li key={index}>
      {player.name} - {player.score}
    </li>
  ));

  const lowScorers = players
    .filter(player => player.score < 70) // ES6 arrow function
    .map((player, index) => (
      <li key={index}>
        {player.name} - {player.score}
      </li>
    ));

  return (
    <div>
      <h2>All Players</h2>
      <ul>{highScorers}</ul>

      <h2>Players with score below 70</h2>
      <ul>{lowScorers}</ul>
    </div>
  );
}

export default ListOfPlayers;
