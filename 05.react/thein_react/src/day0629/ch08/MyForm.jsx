import { useState } from "react";

function MyForm() {
  const [user, setUser] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });

  const handleChange = (event) => {
    setUser({
      ...user,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`Hello ${user.firstName} ${user.lastName}`);
  };

  return (
    <form className="myform" onSubmit={handleSubmit}>
      <label htmlFor="firstName">First name</label>
      <input id="firstName" type="text" name="firstName" onChange={handleChange} value={user.firstName} />
      <label htmlFor="lastName">Last name</label>
      <input id="lastName" type="text" name="lastName" onChange={handleChange} value={user.lastName} />
      <label htmlFor="email">Email</label>
      <input id="email" type="email" name="email" onChange={handleChange} value={user.email} />
      <input type="submit" value="Submit" />
    </form>
  );
}

export default MyForm;