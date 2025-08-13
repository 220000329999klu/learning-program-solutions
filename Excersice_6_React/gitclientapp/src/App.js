// src/App.js
import React, { useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);
  const [username, setUsername] = useState('techiesyed');
  const gitClient = new GitClient();

  const fetchRepos = async () => {
    const repoNames = await gitClient.getRepositories(username);
    setRepos(repoNames);
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>GitHub Repo Viewer</h1>
      <input 
        type="text" 
        value={username} 
        onChange={e => setUsername(e.target.value)} 
        placeholder="Enter GitHub username"
      />
      <button onClick={fetchRepos}>Fetch Repos</button>
      <ul>
        {repos.map((repo, idx) => (
          <li key={idx}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
