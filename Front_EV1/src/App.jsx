import { Container } from "@mui/material";
import Navbar from "./components/navbar/Navbar";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Registro from "./pages/Registro";
import InboxIcon from '@mui/icons-material/Inbox';
import NoCrashIcon from '@mui/icons-material/NoCrash';

// Links o rutas a las que se redirigirá el usuario
const navArrayLinks = [
  {
      title: "Home",
      path: "/",
      icon: <InboxIcon />
  },
  {
      title: "Registro",
      path: "/registro",
      icon: <NoCrashIcon />
  },

]

export default function App() {
  return (
    <>
      <Navbar navArrayLinks={navArrayLinks} />
      <Container sx={{ mt: 5 }}>
        <Routes>
          <Route
           path="/" 
           element={<Home />} 
           />
          <Route 
          path="/registro" 
          element={<Registro />} 
          />
        </Routes>
      </Container>
    </>
  );
}