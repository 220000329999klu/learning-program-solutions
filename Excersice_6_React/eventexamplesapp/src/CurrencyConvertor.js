// src/CurrencyConvertor.js
import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: "",
      euros: null,
      message: ""
    };
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleInputChange(e) {
    this.setState({ rupees: e.target.value });
  }

  handleSubmit(e) {
    e.preventDefault(); // Prevent form reload
    const rupees = parseFloat(this.state.rupees);
    if (isNaN(rupees)) {
      this.setState({ message: "Please enter a valid number", euros: null });
      return;
    }
    // Conversion rate (example): 1 INR = 0.011 Euro
    const euros = (rupees * 0.011).toFixed(2);
    this.setState({ euros, message: "" });
  }

  render() {
    return (
      <div>
        <h2>Currency Convertor (INR to Euro)</h2>
        <form onSubmit={this.handleSubmit}>
          <input
            type="text"
            placeholder="Enter amount in Rupees"
            value={this.state.rupees}
            onChange={this.handleInputChange}
          />
          <button type="submit">Convert</button>
        </form>
        {this.state.message && <p style={{ color: "red" }}>{this.state.message}</p>}
        {this.state.euros !== null && (
          <p>
            ₹{this.state.rupees} = €{this.state.euros}
          </p>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
