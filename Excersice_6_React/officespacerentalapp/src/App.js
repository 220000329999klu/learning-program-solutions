// src/App.js
import React from 'react';
import officeImage from './office.jpg'; // Add an image named office.jpg inside /src

function App() {
  // Object of a single office
  const office = {
    name: "Cozy Work Hub",
    rent: 55000,
    address: "MG Road, Bangalore"
  };

  // Array of multiple office spaces
  const officeList = [
    { name: "Elite Spaces", rent: 75000, address: "Koramangala, Bangalore" },
    { name: "Startup Zone", rent: 45000, address: "HSR Layout, Bangalore" },
    { name: "Prime Offices", rent: 85000, address: "Indiranagar, Bangalore" },
    { name: "Budget Workspaces", rent: 30000, address: "BTM Layout, Bangalore" }
  ];

  // Function to return rent color style
  const getRentStyle = (rent) => {
    return {
      color: rent >= 60000 ? 'green' : 'red',
      fontWeight: 'bold'
    };
  };

  return (
    <div style={{ textAlign: 'center', padding: '20px', fontFamily: 'Arial' }}>
      <h1>Office Space Rental App</h1>

      {/* Display image */}
      <img src={officeImage} alt="Office Space" width="400" style={{ borderRadius: '10px' }} />

      <h2>Featured Office</h2>
      <p><strong>Name:</strong> {office.name}</p>
      <p><strong>Address:</strong> {office.address}</p>
      <p><strong>Rent:</strong> <span style={getRentStyle(office.rent)}>₹{office.rent}</span></p>

      <h2>Available Office Spaces</h2>
      <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        {officeList.map((item, index) => (
          <div key={index} style={{ border: '1px solid #ccc', padding: '10px', margin: '10px', width: '300px', borderRadius: '8px' }}>
            <p><strong>Name:</strong> {item.name}</p>
            <p><strong>Address:</strong> {item.address}</p>
            <p><strong>Rent:</strong> <span style={getRentStyle(item.rent)}>₹{item.rent}</span></p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
