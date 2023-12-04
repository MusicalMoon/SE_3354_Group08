import React from "react";
import { Hero, HomeCategories, Subscribe } from "../../components";
import { useGetRecipesQuery } from "../../features/recipe/recipeApiSlice";
import { useGetBlogsQuery } from "../../features/blog/blogApiSlice";
import useAuth from "../../hooks/useAuth";
import useTitle from "../../hooks/useTitle";

const Home = () => {
  const user = useAuth();
  const recipes = useGetRecipesQuery();
  const blogs = useGetBlogsQuery();
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
