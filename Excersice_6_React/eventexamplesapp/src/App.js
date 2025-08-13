// src/App.js
import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      message: ""
    };
    // Bind methods to this
    this.increment = this.increment.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleIncrementClick = this.handleIncrementClick.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handleSyntheticEvent = this.handleSyntheticEvent.bind(this);
  }

  increment() {
    this.setState((prevState) => ({ count: prevState.count + 1 }));
  }

  sayHello() {
    this.setState({ message: "Hello! Welcome to React Events Lab." });
  }

  // Method to call multiple functions on Increment button click
  handleIncrementClick() {
    this.increment();
    this.sayHello();
  }

  // Method which accepts argument
  sayWelcome(msg) {
    this.setState({ message: msg });
  }

  // Synthetic event handler for onClick
  handleSyntheticEvent(e) {
    // e is a SyntheticEvent object
    this.setState({ message: "I was clicked" });
  }

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "50px", fontFamily: "Arial" }}>
        <h1>React Event Handling Examples</h1>

        <div>
          <h2>Counter: {this.state.count}</h2>
          {/* Increment button calls multiple methods */}
          <button onClick={this.handleIncrementClick}>Increment</button>
          <button onClick={() => this.setState({ count: this.state.count - 1 })}>
            Decrement
          </button>
        </div>

        <div style={{ marginTop: "20px" }}>
          {/* Button calls function with argument */}
          <button onClick={() => this.sayWelcome("Welcome to React Events!")}>
            Say Welcome
          </button>
        </div>

        <div style={{ marginTop: "20px" }}>
          {/* Synthetic event example */}
          <button onClick={this.handleSyntheticEvent}>Click me (Synthetic Event)</button>
        </div>

        <p style={{ marginTop: "20px", fontWeight: "bold" }}>{this.state.message}</p>

        <hr style={{ margin: "40px 0" }} />

        {/* Currency Convertor Component */}
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
