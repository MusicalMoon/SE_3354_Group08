import React from "react";
import {
  AiFillGithub,
  AiFillLinkedin,
  AiFillTwitterCircle,
} from "react-icons/ai";
import { motion } from "framer-motion";
import { Logo } from "..";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer className="border-b-4 border-primary bg-green-50 pt-12 mt-24">
      {/* Footer top */}
      <div className="box flex flex-col md:flex-row  justify-between border-b-2 border-green-100 pb-10 gap-8">
        {/* Footer top left */}
        <div className="basis-1/2 flex flex-col gap-6 items-center md:items-start text-center md:text-start">
          <Logo />
          <p>
            Reciply. A hub to share your recipes, flavors, and ideas! Join to create a plate alongside ours.
          </p>
        </div>
        {/* Footer top right */}
        <div className="flex gap-10 basis-1/2 justify-center md:justify-end flex-wrap md:flex-nowrap">
          {/* Footer links */}
          <ul className="flex flex-col gap-2 font-semibold mx-8 items-center md:items-start">
            <li className="text-gray-700 text-sm text-bold mb-2">Product</li>
            <motion.li whileHover={{ x: 5 }}>
              <Link>Home</Link>
            </motion.li>
            <motion.li whileHover={{ x: 5 }}>
              <Link>Recipes</Link>
            </motion.li>
          </ul>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
