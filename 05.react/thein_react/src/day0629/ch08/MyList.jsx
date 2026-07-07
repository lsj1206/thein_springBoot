const data = [1, 2, 3, 4, 5];

function MyList() {
  return (
    <>
      <ul className="mylist">
        {data.map((number, index) => (
          <li key={index}>Listitem {number}</li>
        ))}
      </ul>
    </>
  );
}

export default MyList;

