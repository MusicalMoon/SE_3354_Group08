import React from "react";
import { Hero, HomeCategories, Subscribe } from "../../components";
import { useGetRecipesQuery } from "../../features/recipe/recipeApiSlice";
import useAuth from "../../hooks/useAuth";
import useTitle from "../../hooks/useTitle";

const Home = () => {
  const user = useAuth();
  const recipes = useGetRecipesQuery();
  useTitle("Reciply - Home");

  return (
    <>
      <Hero />
      <HomeCategories
        title={"recipe"}
        data={recipes?.data}
        isLoading={recipes?.isLoading}
      />
    </>
  );
};

export default Home;
