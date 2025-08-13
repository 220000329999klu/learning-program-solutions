import React, { useState } from 'react';
import EmployeeList from './EmployeeList';
import ThemeContext from './ThemeContext';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(theme === 'light' ? 'dark' : 'light');
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div className={`app ${theme}`}>
        <h1>Employee Management Application</h1>
        <button onClick={toggleTheme}>
          Toggle Theme (Current: {theme})
        </button>
        <EmployeeList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
