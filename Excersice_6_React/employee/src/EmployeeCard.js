import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';
function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div className="employee-card">
      <h3>{employee.name}</h3>
      <p>{employee.position}</p>
      <button className={theme === 'light' ? 'btn-light' : 'btn-dark'}>Edit</button>
      <button className={theme === 'light' ? 'btn-light' : 'btn-dark'}>Delete</button>
    </div>
  );
}

export default EmployeeCard;
