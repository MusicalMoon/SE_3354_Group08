
import React, { useState } from "react";
import { Button, Input, Logo } from "../../components";
import { IoMailOutline } from "react-icons/io5";
import { BiLockAlt } from "react-icons/bi";
import { Link, useNavigate } from "react-router-dom";
import { useSignInMutation } from "../../features/auth/authApiSlice";
import { useDispatch } from "react-redux";
import { setCredentials } from "../../features/auth/authSlice";
import { toast } from "react-toastify";
import useTitle from "../../hooks/useTitle";

const SignIn = () => {
  const [formDetails, setFormDetails] = useState({
    email: "",
    password: "",
  });
  const [signIn, { isLoading }] = useSignInMutation();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  useTitle("Reciply - Sign In");

  const handleChange = (e) => {
    setFormDetails({ ...formDetails, [e.target.id]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const userData = await toast.promise(
        signIn({ ...formDetails }).unwrap(),
        {
          pending: "Please wait...",
          success: "Sign in successfull",
          error: "Sign in failed",
        }
      );
      dispatch(setCredentials({ ...userData }));
      localStorage.setItem("persist", true);
      setFormDetails({ email: "", password: "" });
      navigate("/");
    } catch (error) {
      toast.error(error.data);
      console.error(error);
    }
  };

  return (
    <section className="flex w-full h-screen">
      {/* Sign in form container */}
      <div className="basis-1 m-auto flex flex-col">
        <Logo customCss={"mx-auto md:mx-0"} />
        {/* Sign in form heading */}
        <div className="mt-12 mb-6 flex flex-col gap-10">
          <h2 className="text-center md:text-left font-bold text-3xl">
            Welcome Back
          </h2>
          <p className="text-center md:text-left text-sm">
            New to Reciply?{" "}
            <Link
              to={"/auth/signup"}
              className="text-primary font-semibold"
            >
              Create an account
            </Link>
          </p>
        </div>
        {/*Sign in form */}
        <form
          className="flex flex-col gap-4"
          onSubmit={handleSubmit}
        >
          <Input
            type={"email"}
            id={"email"}
            icon={<IoMailOutline />}
            handleChange={handleChange}
            value={formDetails.email}
            label={"Email"}
            placeholder={""}
          />
          <Input
            type={"password"}
            id={"password"}
            icon={<BiLockAlt />}
            handleChange={handleChange}
            value={formDetails.password}
            label={"Password"}
            placeholder={"At least 6 characters long"}
          />
          <Button
            content={"Sign in"}
            type={"submit"}
            customCss={"mt-10 rounded-lg"}
            loading={isLoading}
          />
        </form>
      </div>
      
    </section>
    
  );

  
};

export default SignIn;

/*
import React from "react";
import "./style.css";

export const Login = () => {
  return (
    <div className="login">
      <div className="div">
        <div className="navigation">
          <div className="overlap-group">
            <div className="rectangle" />
            <div className="navbar">
              <div className="text-wrapper">Explore</div>
              <div className="text-wrapper-2">Cuisines</div>
              <div className="text-wrapper-2">About Us</div>
              <div className="text-wrapper-3">My profile</div>
            </div>
          </div>
          <div className="text-wrapper-4">Password:</div>
          <div className="text-wrapper-5">Reciply</div>
          <div className="overlap">
            <img className="star" alt="Star" src="/img/star-1.svg" />
          </div>
        </div>
        <div className="overlap-2">
          <div className="overlap-3">
            <div className="rectangle-2" />
            <div className="text-wrapper-6">Username:</div>
          </div>
          <div className="overlap-4">
            <div className="rectangle-3" />
            <div className="text-wrapper-7">Password:</div>
          </div>
          <div className="text-wrapper-8">Login</div>
          <div className="overlap-5">
            <div className="text-wrapper-9">Don’t have an account?</div>
            <div className="text-wrapper-10">Sign up</div>
          </div>
        </div>
        <div className="rectangle-4" />
      </div>
    </div>
  );
};
*/
