import React, { useState } from "react";

function GuestPage() {
  return (
    <div>
      <h2>Welcome Guest!</h2>
      <p>Browse our flights below:</p>
      <ul>
        <li>Flight 101 - New York to London</li>
        <li>Flight 205 - Paris to Tokyo</li>
        <li>Flight 309 - Sydney to Dubai</li>
      </ul>
      <p>Please login to book tickets.</p>
    </div>
  );
}

function UserPage() {
  return (
    <div>
      <h2>Welcome User!</h2>
      <p>You can book your tickets here:</p>
      <form>
        <label>
          Select Flight:
          <select>
            <option value="101">Flight 101 - New York to London</option>
            <option value="205">Flight 205 - Paris to Tokyo</option>
            <option value="309">Flight 309 - Sydney to Dubai</option>
          </select>
        </label>
        <br />
        <br />
        <button type="submit">Book Ticket</button>
      </form>
    </div>
  );
}

function App() {
  // State to track if user is logged in or not
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Handlers to toggle login state
  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  let pageContent;
  if (isLoggedIn) {
    pageContent = <UserPage />;
  } else {
    pageContent = <GuestPage />;
  }

  return (
    <div style={{ textAlign: "center", fontFamily: "Arial", marginTop: "40px" }}>
      <h1>Ticket Booking App</h1>

      {/* Conditionally render Login/Logout button */}
      {isLoggedIn ? (
        <button onClick={handleLogout}>Logout</button>
      ) : (
        <button onClick={handleLogin}>Login</button>
      )}

      <hr style={{ margin: "20px auto", width: "50%" }} />

      {/* Render Guest or User page */}
      {pageContent}
    </div>
  );
}

export default App;
