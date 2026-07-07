const data = [
  { id: 1, brand: "Ford", model: "Mustang" },
  { id: 2, brand: "Genesis", model: "G90" },
  { id: 3, brand: "Tesla", model: "Model S" },
];

function MyTable() {
  return (
    <>
      <table className="mytable">
        <tbody>
          {data.map((item) => (
            <tr key={item.id}>
              <td>{item.brand}</td>
              <td>{item.model}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}

export default MyTable;

