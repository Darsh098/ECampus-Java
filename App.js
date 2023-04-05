import React from "react";

class App extends React.Component {
  constructor() {
    super();
    this.state = { count: 1 };
  }

  render() {
    return (
      <div>
        <h1
          style={{
            fontFamily: "Poor Richard",
            backgroundColor: "lightblue",
            textAlign: "center",
            margin: 0 + "px",
            borderStyle: "solid",
            borderColor: "blue",
            borderWidth: 3 + "px",
            borderLeftWidth: 0 + "px",
            borderRightWidth: 0 + "px",
          }}
        >
          Counter
        </h1>
        <h3
          style={{
            color: "blue",
            backgroundColor: "beige",
            borderColor: "darkgray",
            borderWidth: 1 + "px",
            borderStyle: "solid",
          }}
        >
          Clicked {this.state.count} Times!!
          <br />
          <br />
          <button
            style={{ color: "aqua", backgroundColor: "black" }}
            onClick={() =>
              this.setState({
                count: this.state.count + 1,
              })
            }
          >
            Click Me
          </button>
        </h3>
      </div>
    );
  }
}

export default App;
