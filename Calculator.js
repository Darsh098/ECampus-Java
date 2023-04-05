import { useState } from "react";
import React from "react";

class Calculator extends React.Component {
  constructor() {
    super();
    this.state = { firstVal: 0, secondVal: 0, sum: 0 };
  }

  handleCalculate = () => {
    this.setState({
      sum: Number(this.state.firstVal) + Number(this.state.secondVal),
    });
  };

  render() {
    const { firstVal, secondVal, sum } = this.state;
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
          Calculator
        </h1>

        <h4
          style={{
            color: "blue",
            backgroundColor: "beige",
            borderColor: "darkgray",
            borderWidth: 1 + "px",
            borderStyle: "solid",
          }}
        >
          Enter First Value :
          <input
            type={"number"}
            id={"firstVal"}
            name={"firstVal"}
            value={firstVal}
            onChange={(event) =>
              this.setState({ firstVal: event.target.value })
            }
          ></input>
          <br />
          <br />
          Enter Second Value :
          <input
            type={"number"}
            id={"secondVal"}
            name={"secondVal"}
            value={secondVal}
            onChange={(event) =>
              this.setState({ secondVal: event.target.value })
            }
          ></input>
          <br />
          <br />
          <button
            type={"submit"}
            style={{ color: "aqua", backgroundColor: "black" }}
            onClick={this.handleCalculate}
          >
            Calculate
          </button>
          <h2>Sum : {sum}</h2>
        </h4>
      </div>
    );
  }
}

export default Calculator;
