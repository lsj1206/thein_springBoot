function Car2({ carinfo }) {
  return (
    <div>
      <h2 className={carinfo.color}>
        My car is a {carinfo.name} {carinfo.model}.
        <br />
        It is a {carinfo.color} {carinfo.year} model.
      </h2>
    </div>
  );
}

export default Car2;