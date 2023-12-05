/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        primary: "#22c55e",
        primaryLight: "#dcfce7",
        light: "#fffefc",
      },
      backgroundImage: {
        hero: "url('https://www.seriouseats.com/thmb/-IySaVtAL727t2vKY-FfI2M2EA8=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/20230804-SEA-BuffaloChickenSalad-RobbyLozano-000-70ff310ea4be4a28a04048a9c536e748.jpg')",
      },
    },
  },
  plugins: [],
};
