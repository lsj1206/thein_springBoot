import Car from "./Car";
import Car2 from "./Car2";

const mycar1 = {
  name: "Ford",
  model: "Mustang",
  color: "red",
  year: 2015,
};

const mycar2 = {
  name: "Lamborghini",
  model: "Aventador",
  color: "yellow",
  year: 2016,
};

const mycar3 = {
  name: "Genesis",
  model: "GV90",
  color: "black",
  year: 2024,
};

const mycar4 = {
  name: "BMW",
  model: "M3",
  color: "blue",
  year: 2020,
};

function Garage() {
  return (
    <div>
      <Car brand="Ford" />
      <Car brand="BMW" />
      <Car brand="Renault" />
      <Car brand="Kia" />
      <Car2 carinfo={mycar1} />
      <Car2 carinfo={mycar2} />
      <Car2 carinfo={mycar3} />
      <Car2 carinfo={mycar4} />
    </div>
  );
}

export default Garage;