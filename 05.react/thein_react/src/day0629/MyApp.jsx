import Car from "./sementic/Car";
import Section from "./sementic/Section";
import ShoppingList from "./sementic/ShoppingList";

function MyApp() {
  return (
    <>
      <Section />
      <ShoppingList />
      <Car color="red" />
      <Car color="blue" />
      <Car color="green" />
    </>
  );
}

export default MyApp;
