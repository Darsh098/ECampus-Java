import { useState } from "react";

export default function Timer() {
  const [time, setTime] = useState(new Date());

  const UpdateTimer = () => {
    setTime(new Date());
  };

  setInterval(UpdateTimer, 1000);

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
        Current Time
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
        {time.toLocaleTimeString()}
      </h3>
    </div>
  );
}
